/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitivas;

/**
 *
 * @author Andres
 */
public class Warehouse {

    private String id;
    private List products;

    public Warehouse() {
    }

    public Warehouse(String id, List products) {
        this.id = id;
        this.products = products;
    }

    public Warehouse(String id) {
        this.id = id;
    }

    //Get product from list
    public Products searchProduct(String name) {
        Nodo<Products> aux = new Nodo<Products>();
        aux = this.getProducts().getpFirst();
        Products product = null;

        while (aux != null) {
            if (aux.getData().getName().equalsIgnoreCase(name)) {
                return aux.getData();
            } else {
                aux = aux.getpNext();
            }

        }
        return null;
    }

    //Print warehouse with products
    public String printWarehouse() {
        String texto = "\nAlamcen: " + this.getId();
        Nodo<Products> aux = this.getProducts().getpFirst();
        for (int i = 0; i < this.getProducts().getSize(); i++) {
            texto += aux.getData().printProduct();
        }
        return texto;
    }

    public Products[] getProductStringArray() {
        Products[] array;
        array = new Products[this.getProducts().getSize()];
        Nodo<Products> aux = this.getProducts().getpFirst();
        for (int i = 0; i < this.getProducts().getSize(); i++) {
            array[i] = aux.getData();
            aux = aux.getpNext();
        }

        return array;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the products
     */
    public List getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(List products) {
        this.products = products;
    }

}
