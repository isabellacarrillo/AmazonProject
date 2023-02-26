/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitivas;

import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class Products {

    private String name;
    private int amount;

    //Empty CONSTRUCTOR
    public Products() {

        
        this.name = "";
        this.amount = 0;
    }


    public Products( String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    
    
    //Print a product
    public String printProduct(){
        return ("\nProducto: "+this.getName()+"\nCantidad: "+ String.valueOf(this.getAmount()));
    }
    
    //Update an amount of a product
    public void removeProductFromWarehouse(int amount){
        if (this.amount - amount >= 0){
            this.amount-=amount;
        }else{
            JOptionPane.showMessageDialog(null, "There is not a sufficient amount of " + this.name + " in this wharehouse to cover the order.");
            
            //We need to put something here about Dijkstra´s algorithm (call its function)
        }
        
    }
    

   

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

}
