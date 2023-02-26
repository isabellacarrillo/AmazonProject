
package interfaces;

/**
 *
 * @author Camila Garcia
 */

import grafos.Grafos;
public class Code {
    private static final Main PagePrincipal = new Main();
    private static final AddRutes nuevaRuta = new AddRutes();
    private static final NewAlmacen nuevoAlmacen = new NewAlmacen();
    private static final InventaryP ProductsPag = new InventaryP();
    private static final PedidoNuevo nuevoPedido = new PedidoNuevo();
    private static final cargarArchivo cargartxt = new cargarArchivo();
    private static final gestionStock GestionarStock = new gestionStock();
    private static Grafos grafo = new Grafos();
    private static String direction;

    /**
     *
     * Abrir la interfaz
     */
    public static void openMain() {
        getMainPrincipal().setVisible(true);
    }
    /*
     * Abre NewAlmacen
     */
    public static void openNewAlmacen() {
        getNewStoragePage().setVisible(true);
        getMainPrincipal().setVisible(false);
        getNewStoragePage().createGprah(grafo);
    }

    /**
     *
     * Abre Inventary
     */
    public static void openShowInvPage() {
        getShowInvPage().setVisible(true);

        InterfaceFunctions.ShowProductsInit();

        getMainPrincipal().setVisible(false);
    }
    
    /**
     *
     * opens show AddNewRutes
     */
    public static void openAddNewRutes() {
        getAddNewRutesPage().setVisible(true);
        getMainPrincipal().setVisible(false);
        getAddNewRutesPage().createGprah(getGraph());
    }

    /**
     *
     * Hides every sub-page, and opens Main
     */
    public static void getBackToMainPage() {
        getMainPrincipal().setVisible(true);

        // in here we will be adding every page to setVisible(false)
        // so we can recycle this method for every page
        getNewStoragePage().setVisible(false);
        getShowInvPage().setVisible(false);
        getNuevoPedidoPage().setVisible(false);
        getUploadDataPage().setVisible(false);
        getAddNewRutesPage().setVisible(false);
        getStockManagementPage().setVisible(false);

    }

    /**
     *
     * opens PedidoNuevo
     */
    public static void openNewOrderPage() {
        getMainPrincipal().setVisible(false);
        
        InterfaceFunctions.NewOrdInit();
        getNuevoPedidoPage().setVisible(true);
    }

    
      /**
     *
     * opens cargarArchivo
     */
    public static void openUploadDataPage() {
        getMainPrincipal().setVisible(false);
        getUploadDataPage().setVisible(true);
    }

    /**
     * Shows the graphic for the main graph
     */
    public static void showGraphMap() {
        InterfaceFunctions.createMapaGrafos();
   }

  
    public static Main getMainPrincipal() {
        return PagePrincipal;
    }

    /**
     *
     * Getter for NewAlmacen
     *
     * @return NewAlmacen
     */
    public static NewAlmacen getNewStoragePage() {
        return nuevoAlmacen;
    }
    
    /**
     *
     * opens StockManagementPage
     */
    public static void openStockManagementPage() {
        getStockManagementPage().setVisible(true);
        GestionarStock.setGraph(getGraph());
        getMainPrincipal().setVisible(false);
    }

    /**
     *
     * Getter for InventaryP
     *
     * @return InventaryP
     */
    public static InventaryP getShowInvPage() {
        return ProductsPag;
    }

    /**
     *
     * Getter for Graph
     *
     * @return Graph
     */
    public static Grafos getGraph() {
        return grafo;
    }

    /**
     *
     * Setter for Graph
     *
     * @param graph
     */
    public static void setGraph(Grafos graph) {
        Code.grafo = graph;
    }

    /**
     *
     * Getter for PedidoNuevo
     *
     * @return PedidoNuevo
     */
    public static PedidoNuevo getNuevoPedidoPage() {
        return nuevoPedido;
    }
    
    /**
     * Getter for direction
     * @return 
     */

    public static String getDirection() {
        return direction;
    }
    
    /**
     * setter for Direction
     * @param direction 
     */

    public static void setDirection(String direction) {
        Code.direction = direction;
    }
    /**
     *
     * Getter for cargarArchivo
     *
     * @return cargarArchivo
     */
    public static cargarArchivo getUploadDataPage() {
        return cargartxt;
    }
    
    /**
     * Getter for AddRutes
     * @return 
     */

    public static AddRutes getAddNewRutesPage() {
        return nuevaRuta;
    }
    
    /**
     * Getter for gestionStock
     * @return 
     */

    public static gestionStock getStockManagementPage() {
        return GestionarStock;
    }

}