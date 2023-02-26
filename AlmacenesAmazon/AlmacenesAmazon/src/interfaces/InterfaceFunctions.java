package interfaces;

import java.io.File;
import javax.swing.JOptionPane;
import grafos.MatrizAdy;
import primitivas.Main;
import grafos.Grafos;
import primitivas.List;
import primitivas.Nodo;
import primitivas.Products;
import primitivas.Warehouse;
import org.graphstream.graph.Node;
import org.graphstream.graph.Edge;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.ui.view.Viewer;
import primitivas.Functions;

/**
 *
 * @author Camila Garcia
 * @author Andres
 * @author carri
 */
public class InterfaceFunctions {

    /**
     * Iniciar la pagina de Productos: Mostrar Productos
     *
     */
    public static void ShowProductsInit() {

        Grafos grafo = Code.getGraph();

        List warehousedfs = grafo.WarehouseDFS();
        List warehousebfs = grafo.WarehouseBFS();

        Code.getShowInvPage().getTextFieldDFS().setText(TotalProductsOnWarehouses(warehousedfs));
        Code.getShowInvPage().getTextFieldBFS().setText(TotalProductsOnWarehouses(warehousebfs));

    }

    /**
     * Iniciar Pedido Nuevo
     */
    public static void NewOrdInit() {
        Grafos grafo = Code.getGraph();
        List warehouses1 = grafo.WarehouseDFS();
        List warehouses2 = grafo.getWarehouses();
        String[] warehousesName = grafo.warehousestring();
        Code.getNuevoPedidoPage().getInvTextField().setText(TotalProductsOnWarehouses(warehouses1));

        for (String item : warehousesName) {
            if (warehouses2.getWarehouseName(item).getProducts()!= null) {
                Code.getNuevoPedidoPage().getWarehouseCB().removeItem(item);
                Code.getNuevoPedidoPage().getWarehouseCB().addItem(item);
            }

        }
    }

   ///Cambiar Disponibilidad de los productos
    public static void setAvailableProducts(String Name) {
        Code.getNuevoPedidoPage().getProductCB().removeAllItems();

        Grafos graph = Code.getGraph();
        Warehouse selectedWarehouse = graph.searchWarehouse(Name);
        String[] productsNames = selectedWarehouse.getProducts().productsarray();

        for (String item : productsNames) {
            Code.getNuevoPedidoPage().getProductCB().addItem(item);
        }

    }

    /**
     * Actualizar el texfield del pedido nuevo cuando el usuario agrega un producto
         y la cantidad
     *
     * @param actualOrder
     */
    public static void updateTFOrder(String actualOrder) {
        String amount = Code.getNuevoPedidoPage().getProductAmountTF().getText();
        if (isNum(amount)) {
            String product = Code.getNuevoPedidoPage().getProductCB().getSelectedItem().toString();
            actualOrder += product + ": " + amount + "\n";
            Code.getNuevoPedidoPage().getOrderTA().setText(actualOrder);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida");
        }
    }

    /**
     * Ayuda para eliminar todo lo que usa el nuevo Pedido
     *
     */
    public static void reset() {
        Code.getNuevoPedidoPage().getWarehouseCB().setEnabled(true);
        setAvailableProducts(Code.getNuevoPedidoPage().getWarehouseCB().getSelectedItem().toString());
        Code.getNuevoPedidoPage().getOrderTA().setText("");
    }

    /**
     * Se completa el pedido cuando estan disponibles en el almacen
     * @param order
     * @param warehouseName
     */
    public static void completePedidoNuevo(String order, String warehouseName) {
        Grafos grafo = Code.getGraph();
        List warehouses = grafo.getWarehouses();
        Warehouse pickedwarehouse = warehouses.getWarehouseName(warehouseName);
        String[] orderAux = order.split("\n");

        boolean DispStock = true;
        Warehouse missingProducts = new Warehouse();

        for (String productString : orderAux) {
            String[] productAux = productString.split(":");
            String productName = productAux[0];

            int ProductAmount = Integer.parseInt(productAux[1].replace(" ", ""));
            int currentStock = pickedwarehouse.searchProduct(productName).getAmount();

            if (currentStock < ProductAmount) {
                DispStock = false;
                Products missingProduct = new Products(productName,(ProductAmount - currentStock));
                missingProducts.getProducts().addATheEnd(missingProduct);
            }

        }

        if (DispStock) {
            for (String productString : orderAux) {
                String[] productAux = productString.split(":");
                String productName = productAux[0];
                int productQty = Integer.parseInt(productAux[1].replace(" ", ""));
                int originalQty = pickedwarehouse.searchProduct(productName).getAmount();
                pickedwarehouse.searchProduct(productName).setAmount(originalQty - productQty);

            }

            JOptionPane.showMessageDialog(null, "Añadido Exitosamente");
            NewOrdInit();
            reset();

        } else {
            searchOnWarehouses(missingProducts, warehouseName, orderAux, pickedwarehouse);
        }
    }

    /**
     *
     *
     * 
     * Cambia la cantidad de productos del almacen original luego que el usuario hizo el pedido
     *
     * @param orderSplit
     * @param missingStock
     * @param selectedStorage
     */
    public static void NewWarehouseProducts(String[] orderSplit, Warehouse missingStock, Warehouse selectedStorage) {
        for (String orderString : orderSplit) {
            String productName = orderString.split(":")[0];

            if (missingStock.searchProduct(productName) != null) {
                selectedStorage.searchProduct(productName).setAmount(0);
            } else {
                int amountoreduce = Integer.parseInt(orderString.split(":")[1].replace(" ", ""));
                Products productToReduce = selectedStorage.searchProduct(productName);
                productToReduce.setAmount(productToReduce.getAmount() - amountoreduce);
            }
        }
    }

    /*
     * 
     * Encuentra el producto en otros Warehouses por la ruta mas corta
     * Actualiza los productos y notifica al usuario
     *
     * @param missingProducts
     * @param originalWarehouses
     * @param orderAux
     * @param pickedWarehouse
     */
    public static void searchOnWarehouses(Warehouse missingProducts, String originalWarehouses, String[] orderAux, Warehouse pickedWarehouse) {
        List warehouseProducts = new List();
        Grafos allWarehouses = Code.getGraph();
        for (int i = 0; i < allWarehouses.getWarehouses().getSize(); i++) {

            if (!allWarehouses.getWarehouses().WarehouseNodebyIndex(i).getData().getId().equals(originalWarehouses)) {
                boolean DispProducts = true;
                Warehouse currentProducts = allWarehouses.getWarehouses().WarehouseNodebyIndex(i).getData();

                Nodo<Products> currentMissingProduct = missingProducts.getProducts().getpFirst();
                for (int j = 0; j < missingProducts.getProducts().getSize(); j++) {
                    
                    Products productInStorage = currentProducts.searchProduct(currentMissingProduct.getData().getName());
                    if (productInStorage == null) {
                        DispProducts = false;
                        break;
                    } else if (productInStorage.getAmount() < currentMissingProduct.getData().getAmount()) {
                        DispProducts = false;
                        break;
                    }
                    currentMissingProduct = currentMissingProduct.getpNext();

                }

                if (DispProducts) {
                    warehouseProducts.addATheEnd(allWarehouses.getWarehouses().WarehouseNodebyIndex(i).getData());
                }
            }

        }

        if (warehouseProducts.getSize() <= 0) {
            JOptionPane.showMessageDialog(null, "Cantidad no disponible en ninguno de los almacenes");
            NewOrdInit();
            reset();
        } else {

            NewWarehouseProducts(orderAux, missingProducts, pickedWarehouse);

            String shortRuta = getShortRuta(warehouseProducts, originalWarehouses);
            String[] shortRutaAux = shortRuta.split(";");
            Warehouse warehouseWithProducts = allWarehouses.searchWarehouse(shortRutaAux[1].split(",")[0]);
            String alert = "Faltan estos productos para el pedido:\n";

            Nodo<Products> productosMissingStock = missingProducts.getProducts().getpFirst();
            for (int i = 0; i < missingProducts.getProducts().getSize(); i++) {
                Products productToReduce = warehouseWithProducts.searchProduct(productosMissingStock.getData().getName());
                productToReduce.setAmount(productToReduce.getAmount() - productosMissingStock.getData().getAmount());

                alert += "- " + productosMissingStock.getData().getName() + ": " + productosMissingStock.getData().getAmount() + "\n";
                productosMissingStock = productosMissingStock.getpNext();
            }
            //report to user
            alert += "Así que se solicitaron los productos a: " + warehouseWithProducts.getId() + "\n";
            alert += "Siguiendo la ruta más corta " + "(" + shortRutaAux[0] + "Km)" + ": ";
            alert += shortRutaAux[1].replace(",", " --> ");

            JOptionPane.showMessageDialog(null, alert);
            createShortRutagrafo(shortRutaAux[1]);

            NewOrdInit();
            reset();

        }

    }    
    /**
     *
     * Crear la ruta corta para el grafo y mostrarla
     *
     * @param ruta
     */
    public static void createShortRutagrafo(String ruta) {
        MultiGraph multiGraph = new MultiGraph("GraphMap");
        Grafos grafo1 = Code.getGraph();
        MatrizAdy adjMatrix = grafo1.getMatrixAdy();
        List warehouses = grafo1.getWarehouses();
        String[] rutaAux = ruta.split(",");

        for (String warehouse : rutaAux) {
            System.out.println(warehouse);
            Node n = multiGraph.addNode(warehouse);
            n.setAttribute("ui,label",warehouse);
        }

        int forAux;
        if (rutaAux.length <= 2) {
            forAux = 1;
        } else {
            forAux = rutaAux.length - 1;
        }

        for (int i = 0; i < forAux; i++) {
            String desde = rutaAux[i];
            String hasta = rutaAux[i + 1];
            int desdeIndex = warehouses.IndexofElement(desde);
            int hastaIndex = warehouses.IndexofElement(hasta);
            String routeValue = String.valueOf(adjMatrix.getMatrix()[desdeIndex][hastaIndex]);
            String edgeId = desde + "-" + hasta;
            Edge ed = multiGraph.addEdge(edgeId, desde, hasta, true);

            ed.setAttribute("ui.label", routeValue);

        }

        String grafoAux = "node { text-offset: 0px, -10px; size: 20px; text-size: 12; fill-color: orange, red; fill-mode: gradient-horizontal; text-alignment: above; text-color: #255; text-background-mode: plain; text-background-color: white; } edge { size: 2px; fill-color: #444; text-alignment: above; text-size: 20; arrow-size: 12; text-color: orange; text-offset: 10px, -20px;}";
        multiGraph.setAttribute("ui.stylesheet", grafoAux);

        System.setProperty("org.graphstream.ui", "swing");

        Viewer viewer = multiGraph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }

    /**
     *
     * Tomar la ruta mas corta Dijkstra
     *
     *
     * @param warehousesWithStock
     * @param originalWarehouse
     * @return string
     */
    public static String getShortRuta(List warehousesWithStock, String originalWarehouse) {
        List RutaCorta = new List();
        List allWarehouses = Code.getGraph().getWarehouses();
        int[][] adjMatrix = Code.getGraph().getMatrixAdy().getMatrix();
        for (int i = 0; i < warehousesWithStock.getSize(); i++) {
            String currentStorageWithStock = warehousesWithStock.WarehouseNodebyIndex(i).getData().getId();

            List visitedNodes = new List();
            Object[][] RutaMatriz = new Object[adjMatrix.length][3];

            //fill columns [0] warehouses names, [1] shortest distance, [2] previous node
            for (int j = 0; j < allWarehouses.getSize(); j++) {
                RutaMatriz[j][0] = allWarehouses.WarehouseNodebyIndex(j).getData().getId();
                RutaMatriz[j][1] = Integer.MAX_VALUE;

//                unVisitedNodes.addATheEnd(allStorages.getStorageNodeByIndex(j).getStorage().getName());
                if (RutaMatriz[j][0].equals(currentStorageWithStock)) {
                    RutaMatriz[j][1] = 0;
                }
            }

            //Dijkstra
            while (visitedNodes.getSize() != allWarehouses.getSize()) {

                //identify the lowest distance unvisited node
                String lowestUnvisitedNode = "default";
                for (int j = 0; j < allWarehouses.getSize(); j++) {
                    String currentStorageName = allWarehouses.WarehouseNodebyIndex(j).getData().getId();

                    if (!visitedNodes.searchList(currentStorageName)) {

                        if (lowestUnvisitedNode.equals("default")) {
                            lowestUnvisitedNode = currentStorageName;
                        } else {
                            int lowestUnvisitedRow = allWarehouses.IndexofElement(lowestUnvisitedNode);
                            int currentRow = allWarehouses.IndexofElement(currentStorageName);

                            int lowestRouteValue = (int) RutaMatriz[lowestUnvisitedRow][1];
                            int currentRouteValue = (int) RutaMatriz[currentRow][1];

                            if (currentRouteValue < lowestRouteValue) {
                                lowestUnvisitedNode = currentStorageName;
                            }
                        }

                    }

                }
                int lowestIUnvisitedIndex = allWarehouses.IndexofElement(lowestUnvisitedNode);

                for (int j = 0; j < adjMatrix[lowestIUnvisitedIndex].length; j++) {
                    int currentRoute = adjMatrix[lowestIUnvisitedIndex][j];
                    if (currentRoute != 0) {
                        String currentNeighbour = (String) RutaMatriz[j][0];

                        if (!visitedNodes.searchList(currentNeighbour)) {
                            int newDistance = currentRoute + ((int) RutaMatriz[lowestIUnvisitedIndex][1]);
                            int oldDistance = (int) RutaMatriz[j][1];

                            if (newDistance < oldDistance) {
                                //update new lowest route and previous node
                                RutaMatriz[j][1] = newDistance;
                                RutaMatriz[j][2] = lowestUnvisitedNode;
                            }

                        }
                    }
                }

                visitedNodes.addATheEnd(lowestUnvisitedNode);

            }
            // end of Dijkstra        

            int currentIndex = allWarehouses.IndexofElement(originalWarehouse);
            String finalRoute = String.valueOf((int) RutaMatriz[currentIndex][1]) + ";" + originalWarehouse + ",";
            boolean isRouteIncomplete = true;

            while (isRouteIncomplete) {
                if (RutaMatriz[currentIndex][2] == null) {
                    isRouteIncomplete = false;
                } else {
                    finalRoute += ((String) RutaMatriz[currentIndex][2]) + ",";
                    currentIndex = allWarehouses.IndexofElement(RutaMatriz[currentIndex][2].toString());
                }
            }

            RutaCorta.addATheEnd(finalRoute);
        }

        String lowestRoute = RutaCorta.getpFirst().getData().toString();
        for (int i = 0; i < RutaCorta.getSize(); i++) {
            int currentValue = Integer.parseInt(((String) RutaCorta.getElementInIndex(i)).split(";")[0]);
            int lowestValue = Integer.parseInt(lowestRoute.split(";")[0]);

            if (currentValue < lowestValue) {
                lowestRoute = (String) RutaCorta.getElementInIndex(i);
            }
        }

        String correctedLowestRoute = lowestRoute.split(";")[0] + ";" + invertirRuta(lowestRoute.split(";")[1]);
        return correctedLowestRoute;
    }

    /**
     *
     * Cambia la secuencia del almacenamiento
     *
     * @param original
     * @return String
     */
    public static String invertirRuta(String original) {
        String invertido = "";
        String[] originalAux = original.split(",");
        for (int i = originalAux.length - 1; i >= 0; i--) {
            invertido += originalAux[i] + ",";
        }

        return invertido.substring(0, invertido.length() - 1);
    }

    /**
     *
     *Construir los productos totales en los almacenes
     *
     * 
     */
    public static String TotalProductsOnWarehouses(List nodoWarehouses) {
        String notification = "";
        Nodo pointer = nodoWarehouses.getpFirst();

        while (pointer != null) {
            Warehouse currentWarehouse = (Warehouse) pointer.getData();
            notification += currentWarehouse.getId() + ":\n";
            List currentProducts = currentWarehouse.getProducts();

            if (currentProducts != null) {
                for (int i = 0; i < currentProducts.getSize(); i++) {
                    Products currentProduct = currentProducts.getProductInIndex(i);
                    notification += currentProduct.getName() + ": " + currentProduct.getAmount() + "\n";
                }
            } else {
                notification += "No hay productos todavia\n";
            }

            notification += "\n";

            pointer = pointer.getpNext();
        }

        return notification;

    }

    /**
     *
     * @param word
     * @param word2
     * @return boolean
     */
    public static boolean areTheSame(String word, String word2) {
        return word.equalsIgnoreCase(word2);
    }

    /**
     *
     * @param num
     * @return boolean
     */
    public static boolean isNum(String num) {
        try {
            int number = Integer.parseInt(num);
            return true;

        } catch (NumberFormatException e) {

        }
        return false;
    }

    /**
     *
     * @param array
     * @return boolean
     */
    public static boolean isAWarehouse(String[] array) {
        return array[0].equals("Almacen");

    }

    /**
     *
     * @param name
     * @return boolean
     */
    public static boolean alreadyExistWarehouse(String name) {
        for (int i = 0; i < Code.getGraph().getSize(); i++) {
            if (Code.getGraph().getWarehouses().WarehouseNodebyIndex(i).getData().getId().equalsIgnoreCase(name)) {
                return true;
            }

        }
        return false;

    }

    /**
     * Validate and create the new warehouse
     *
     * @param desde
     * @param hasta
     * @param recibeC
     * @param transmiteC
     * @param nameArray
     * @param name
     */
    public static void createWarehouseButton(String desde, String hasta, String recibeC, String transmiteC, String[] nameArray, String name) {
        if (InterfaceFunctions.areTheSame(desde, hasta)) {
            JOptionPane.showMessageDialog(null, "Debe elegir dos almacenes diferentes");
        } else {
            if (!InterfaceFunctions.isNum(transmiteC) || !InterfaceFunctions.isNum(recibeC)) {
                JOptionPane.showMessageDialog(null, "ERROR:Las distancias deben ser en numeros");
            } else {
                if (!InterfaceFunctions.isAWarehouse(nameArray)) {
                    JOptionPane.showMessageDialog(null, "Para el nombre del Almacen indique al inicio: 'Almacén'");

                } else {
                    if (InterfaceFunctions.alreadyExistWarehouse(name)) {
                        JOptionPane.showMessageDialog(null, "Ya existe el almacén");
                    } else {
                        Code.getGraph().insertEmptyWarehouse(name);
                        Products element = new Products( "Placa",0);
                        List products = new List();
                        products.addAtTheStart(element);

                        Code.getGraph().getWarehouses().WarehouseNodebyIndex(Code.getGraph().getWarehouses().getSize() - 1).getData().setProducts(products);
                        JOptionPane.showMessageDialog(null, "Creado Exitosamente");
                        createNewMatrixWithAnother(Code.getGraph().getMatrixAdy(), Code.getGraph().getSize());
                        Code.getGraph().getMatrixAdy().addAnEdge(Code.getGraph().WarehouseNumberName(desde), Code.getGraph().getSize() - 1, Integer.parseInt(transmiteC));
                        Code.getGraph().getMatrixAdy().addAnEdge(Code.getGraph().getSize() - 1, Code.getGraph().WarehouseNumberName(hasta), Integer.parseInt(recibeC));
                        //GlobalUI.getGraph().getAdjMatrix().printMatrix();
                        JOptionPane.showMessageDialog(null, "Creado Exitosamente");
                    }
                }
            }
        }

    }

    /**
     * Crear una matriz nueva copiando
     *
     * @param matrizAdyacente
     * @param vertice
     */
    public static void createNewMatrixWithAnother(MatrizAdy matrizAdyacente, int vertice) {
        MatrizAdy newMatrix = new MatrizAdy(vertice);
        for (int j = 0; j < matrizAdyacente.getNumVertex(); j++) {
            System.arraycopy(matrizAdyacente.getMatrix()[j], 0, newMatrix.getMatrix()[j], 0, matrizAdyacente.getNumVertex());

        }

        Code.getGraph().setMatrix(newMatrix);

    }

    /**
     * Crear la funcion para el grafico de mapas de grafos
     */
    public static void createMapaGrafos() {
        MultiGraph multiGraph = new MultiGraph("GraphMap");
        Grafos grafo1 = Code.getGraph();
        MatrizAdy adjMatrix = grafo1.getMatrixAdy();
        List warehouses = grafo1.getWarehouses();

        Nodo <Warehouse> pointer = warehouses.getpFirst();
        while (pointer != null) {
            Node n = multiGraph.addNode(pointer.getData().getId());
            String warehouseName = pointer.getData().getId();
            n.setAttribute("ui.label",warehouseName + "\n");

            pointer = pointer.getpNext();
        }

        for (int i = 0; i < adjMatrix.getMatrix().length; i++) {

            for (int j = 0; j < adjMatrix.getMatrix()[i].length; j++) {

                if (adjMatrix.getMatrix()[i][j] != 0) {
                    String warehouse1 = warehouses.WarehouseNodebyIndex(i).getData().getId();
                    String warehouse2 = warehouses.WarehouseNodebyIndex(j).getData().getId();
                    String edgeName = warehouse1 + " " + warehouse2;
                    multiGraph.addEdge(edgeName, warehouse1, warehouse2, true);
                    Edge ed = multiGraph.getEdge(edgeName);
                    ed.setAttribute("ui.label", adjMatrix.getMatrix()[i][j]);
                }

            }
        }

        String grafoAux = "node { text-offset: 0px, -10px; size: 20px; text-size: 12; fill-color: red, orange; fill-mode: gradient-horizontal; text-alignment: above; text-color: #255; text-background-mode: plain; text-background-color: white; } edge { size: 2px; fill-color: #255; text-alignment: above; text-size: 20; arrow-size: 12; text-color: orange; text-offset: 10px, -20px;}";
        multiGraph.setAttribute("ui.stylesheet", grafoAux);

        System.setProperty("org.graphstream.ui", "swing");

        Viewer viewer = multiGraph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }

    /**
     * Revisar si es TXT para cambiar la info grafica segun la confirmacion del usuuario
     *
     * @param file
     */
    public static void uploadTxt(File file) { 
        if (file.getAbsolutePath().endsWith(".txt")) {

            int option = JOptionPane.showConfirmDialog(null, "Usar: " + file.getName(), "Confirme", JOptionPane.YES_NO_OPTION);

            if (option == 0) {
                Main.initializeAppWithNewInfo(file.getAbsolutePath());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Solo puede seleccionar un archivo .txt ", "Errot", 2);
        }
    }

    /**
     * Escribir en el txt con los datos nuevos
     * @param info
     */
    public static void saveInfo(String info) {
        Functions f = new Functions();
        int window = JOptionPane.showConfirmDialog(null, info, "Confirme", JOptionPane.YES_NO_OPTION);

        if (window == 0) {

            try {
                f.write_txt(Code.getGraph(),Code.getDirection()); 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }

        }
    }

    /**
     * Añadir nuevas rutas receptoras
     *
     * @param direction
     * @param hacia
     */
    public static void NewRutasB(String direction, String hacia) {

        String[] arrayAux = direction.split("  ");
        for (int i = 0; i < arrayAux.length; i++) {
            if (!arrayAux[i].equalsIgnoreCase("")) {
                String[] secondArray = arrayAux[i].split(",");
                int num = Integer.parseInt(secondArray[1]);
                String warehouse = secondArray[0];
                Code.getGraph().getMatrixAdy().addAnEdge(Code.getGraph().WarehouseNumberName(hacia), Code.getGraph().WarehouseNumberName(warehouse), num);
            }

        }
    }

    public static void NewRutasDesdeB(String direction, String to) {

        String[] arrayAux = direction.split("  ");
        for (int i = 0; i < arrayAux.length; i++) {
            if (!arrayAux[i].equalsIgnoreCase("")) {
                String[] secondArray = arrayAux[i].split(",");
                int num = Integer.parseInt(secondArray[1]);
                String warehouse = secondArray[0];
                Code.getGraph().getMatrixAdy().addAnEdge(Code.getGraph().WarehouseNumberName(warehouse), Code.getGraph().WarehouseNumberName(to), num);
            }

        }

        Code.getGraph().getMatrixAdy().printMatrix();
    }

    /**
     * Crear un arreglo
     *
     * @param direction
     * @return
     */
    public static String[] DeTextArray(String direction) {

        String[] arrayAux = direction.split("  ");

        return arrayAux;
    }

    /**
     * Validar nombre
     *
     * @param name
     * @return
     */
    public static boolean pickedWarehouseName(String name) {

        if (InterfaceFunctions.alreadyExistWarehouse(name)) {
            JOptionPane.showMessageDialog(null, "Ya existe el almacén");
        } else {
            return true;
        }

        return false;
    }

    /**
     *Crear Almacen con rutas
     *
     * @param name
     * @param direccionA
     * @param direccionB
     */
    public static void createNewStorage(String name, String direccionA, String direccionB) {
        Code.getGraph().insertEmptyWarehouse(name);
        Products element = new Products( "Placa",0);
        List products = new List();
        products.addAtTheStart(element);
        Code.getGraph().getWarehouses().WarehouseNodebyIndex(Code.getGraph().getWarehouses().getSize() - 1).getData().setProducts(products);
        createNewMatrixWithAnother(Code.getGraph().getMatrixAdy(), Code.getGraph().getSize());
        NewRutasB(direccionA, name);
        NewRutasDesdeB(direccionB, name);

    }
}
