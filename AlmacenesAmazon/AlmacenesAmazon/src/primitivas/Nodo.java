/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 * @param <T>
 */
public class Nodo <T>{ //Node class atributes
    
    private T data;
    private Nodo <T> pNext;
    
    
    //Constructor knowing nothing
    public Nodo(){
        this.data = null;
        this.pNext = null;
    }
    
    //Constructor knowing the element 
    public Nodo(T elem) {
        this.data = elem;
        this.pNext = null;
    }
    
  
    // Getters y Setters

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the pNext
     */
    public Nodo <T> getpNext() {
        return pNext;
    }

    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo <T> pNext) {
        this.pNext = pNext;
    }


    
}
    

    
   
   
    


 


