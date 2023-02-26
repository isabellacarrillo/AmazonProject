/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafos;

import primitivas.List;
import primitivas.Nodo;
import primitivas.Warehouse;
import primitivas.Products;

/**
 *
 * @author carri
 */
public class Grafos {

    private MatrizAdy matrixady;
    private List warehouses;
    private int size;

    //Constructor
    public Grafos(MatrizAdy matrixady) {
        this.matrixady = matrixady;
        this.warehouses = null;
        this.size = 0;
    }

    //Empty Constructor
    public Grafos() {
    }
    
    //Prints the Warehouses' inventory of products
    public void printInventory(int index){
        warehouses.WarehouseNodebyIndex(index).getData().getProducts().printInventoryofProducts();
    }
    
    //Method that will print the Warehouses name
    public void printNameofWarehouse(int num){
        System.out.println("\n" + warehouses.WarehouseNodebyIndex(num).getData().getId());
    }

    //This method creates a new Warehouse 
    public void createNewWarehouse(String id, List list) {
        Warehouse warehouse = new Warehouse(id, list);
        if (warehouses.isEmpty()) {
            warehouses.addAtTheStart(warehouse);

        } else {
            warehouses.addATheEnd(warehouse);
        }
        size++;

    }

    //This method creates a new product
    public Products createNewProduct(String name, int amount) {
        Products product = new Products(name, amount);
        return product;
    }

    //Method that gets the first node of a graph
    public Nodo getFirstNode() {
        return getWarehouses().getpFirst();
    }
    
    //Method that will get the number of the warehouse
    public int getNumberofWarehouse(String letter){
        int num = 0;
        for (int i = 0; i < warehouses.getSize(); i++) {
            String warehouse = warehouses.WarehouseNodebyIndex(i).getData().getId();
            String [] array = warehouse.split(" ");
            if (letter.equalsIgnoreCase(array[1])){
                num = i;
                break;
            }
            
        }
        return num;
    }

    //Method that returns the index number of a given node
    public int getIndexofNode(Nodo node) {
        Nodo pointer = getWarehouses().getpFirst();
        int cont = 0;
        while (pointer != node) {
            pointer = pointer.getpNext();
            cont++;
        }
        return cont;
    }

    //Search for a list of products
    public List searchListProduct(String name) {
        Nodo<Warehouse> aux = this.getWarehouses().getpFirst();
        for (int i = 0; i < this.getWarehouses().getSize(); i++) {
            if (aux.getData().getId().equalsIgnoreCase(name)){
                return aux.getData().getProducts();
            }
        }
        return null;
    }
    
    //No me esta dejando hacer el commit
        

    // Returns a string array with the name of all warehouses 
    public String[] warehousestring() {
        String[] cadena;
        cadena = new String[size];
        for (int i = 0; i < size; i++) {
            cadena[i] = warehouses.WarehouseNodebyIndex(i).getData().getId();

        }
        return cadena;
    }

    // method that returns the warehouse 
   public Warehouse searchWarehouse(String id) {

        Nodo<Warehouse> aux = new Nodo<>();
        aux = this.getWarehouses().getpFirst();
        for (int i = 0; i < this.getWarehouses().getSize(); i++) {

            if (aux.getData().getId().equalsIgnoreCase(id)) {
                return aux.getData();

            }
            aux = aux.getpNext();

        }
        return aux.getData();

    } 
    
      // method that returns the warehouse index with name/id
    public int WarehouseNumberName(String id){
            int num = 0;
            for (int i = 0; i < warehouses.getSize(); i++) {
                String warehouse = warehouses.WarehouseNodebyIndex(i).getData().toString();
                
                if (warehouse.equalsIgnoreCase(id)){
                    num = i;
                    break;
                    
                }
            
        }
            return num;
            
    }
    
    //Method that creates an empty warehouse
    public void insertEmptyWarehouse(String name){
        Warehouse warehouse = new Warehouse(name);
        this.warehouses.addEnd(warehouse);
        this.size++;
    }

    // DFS algorithm, returns lists of all graphs warehouses
    // Depth First Search algorithm is used for searching a graph
    // starts at the top and goes as far down as it can on a given branch 
    //and then backtracks to find unexplored paths, and explores them.
    public List WarehouseDFS() {

        Nodo node = getFirstNode();
        List nodosrecorridos = new List();
        List indexrecorridos = new List();

        int[][] matrizadya = getMatrixAdy().getMatrix();
        boolean allnodesrecorridos = false;
        int stepsback = 0;

        while (!allnodesrecorridos) {
            int index = getIndexofNode(node);
            boolean route = false;
            if (!nodosrecorridos.searchList(node.getData())) {
                nodosrecorridos.addATheEnd(node.getData());
                indexrecorridos.addStart(index);
            }
            for (int i = 0; i < matrizadya[index].length; i++) {
                int ruta = matrizadya[index][i];
                if (ruta != 0) {
                    if (!indexrecorridos.searchList(i)) {
                        node = getWarehouses().WarehouseNodebyIndex(i);
                        route = true;
                        stepsback = 0;
                        break;

                    }
                }

            }
            if (nodosrecorridos.getSize() == getWarehouses().getSize()) {
                allnodesrecorridos = true;
            }
            if (!route) {
                stepsback++;
                int newindex = (int) indexrecorridos.getElementInIndex(stepsback);
                node = getWarehouses().WarehouseNodebyIndex(newindex);
            }

        }

        return nodosrecorridos;
    }

    // BFS algorithm, returns lists of all graph warehouses
    //Breadth First Search Algorithm is used for searching a graph
    //Begins at the rooot and investigates all nodes at current depth level before moving on to nodes
    //at next depth level. 
    public List WarehouseBFS() {
        Nodo node = getFirstNode();
        List nodosrecorridos = new List();
        List checkindex = new List();

        int[][] matrizadya = getMatrixAdy().getMatrix();
        boolean allnodesrecorridos = false;

        nodosrecorridos.addEnd(node.getData());
        checkindex.addEnd(getIndexofNode(node));

        while (!allnodesrecorridos) {
            node = getWarehouses().WarehouseNodebyIndex((int) (checkindex.getpFirst().getData()));
            checkindex.deleteAtTheStart();
            int index = getIndexofNode(node);

            for (int i = 0; i < matrizadya[index].length; i++) {
                int ruta = matrizadya[index][i];
                if (ruta != 0) {
                    Warehouse check = getWarehouses().WarehouseNodebyIndex(i).getData();
                    if (!nodosrecorridos.searchList(check)) {
                        nodosrecorridos.addEnd(getWarehouses().WarehouseNodebyIndex(i).getData());
                        checkindex.addEnd(i);
                    }

                }

            }
            if (nodosrecorridos.getSize() == getWarehouses().getSize()) {
                allnodesrecorridos = true;
            }

        }
        getMatrixAdy().printMatrix();
        return nodosrecorridos;
    }

    //Getters y Setters
    /**
     * @return the matrix
     */
    public MatrizAdy getMatrixAdy() {
        return matrixady;
    }

    /**
     * @param matrix the matrix to set
     */
    public void setMatrix(MatrizAdy matrix) {
        this.matrixady = matrix;
    }

    /**
     * @return the warehouses
     */
    public List getWarehouses() {
        return warehouses;
    }

    /**
     * @param warehouses the warehouses to set
     */
    public void setWarehouses(List warehouses) {
        this.warehouses = warehouses;
    }

    /**
     * @return the count
     */
    public int getSize() {
        return size;
    }

    /**
     * @param count the count to set
     */
    public void setSize(int count) {
        this.size = count;
    }

}
