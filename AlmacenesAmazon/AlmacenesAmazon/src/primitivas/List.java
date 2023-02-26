/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

/**
 *
 * @author carri
 */
public class List { //Class atributes 
    private Nodo pFirst;
    private Nodo pLast;
    private int size;
    
    

    public List() { //Constructor 
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public List(Nodo pFirst, Nodo pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = 0;
    }
    
    //Method to empty my list
    public void empty(){
       this.pFirst = null; 
       this.pLast = null;
       this.size = 0;
        
    }
    
    //Method to check if my list is empty
    public boolean isEmpty(){
        return getpFirst() == null;
    }
    
        // Method that adds at the end of the list
        public void addEnd(Object element) {
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setpFirst(node);
        } else {
            Nodo pointer = getpFirst();
            while (pointer.getpNext() != null) {
                pointer = pointer.getpNext();
            }
            pointer.setpNext(node);
        }
        this.size++;
    }

    
    //Append to list from the back
     public void addATheEnd(Object data){ 
        Nodo nodito = new Nodo(data);
        if (isEmpty()) {
            setpFirst(nodito);
            this.pLast= nodito;

        } else {
            Nodo aux = this.pFirst;
            for (int i = 0; i < size; i++) {
                if (aux.getpNext() == null) {
                    aux.setpNext(nodito);
                    this.pLast = nodito;
                } else {
                    aux = aux.getpNext();
                }
            }
        }

        size++;
    }
    
    public void addStart(Object element) {
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setpFirst(node);
        } else {
            node.setpNext(getpFirst());
            setpFirst(node);
        }
        this.size++;
    }
    
    // Method that adds to a list at the start of it
     public void addAtTheStart (Object data){
        Nodo nuevo = new Nodo(data);
        nuevo.setData(data);
        
        if (isEmpty()){
            this.pFirst = nuevo;
        }else{
            nuevo.setpNext(this.pFirst);
            this.pFirst = nuevo;
        }this.size += 1;
    }
     
     //Method that adds an element in a specific position
     public void addSpecific (int position, Object elem){
         Nodo node= new Nodo();
         if(isEmpty()){
             setpFirst(node);
             this.size++;
         }else{
             if(position >0 ){
                 Nodo aux = getpFirst();
                 for (int i = 0; i < position; i++) {
                     if (aux.getpNext() == null){
                         break;
                     }
                     aux = aux.getpNext(); 
                 }
                 node.setpNext(aux.getpNext());
                 aux.setpNext(node);
                 this.size ++;
             }else{
                 addAtTheStart(elem);
             }
         }         
     }
     
    //Method that searches a list
     public boolean searchList (Object elem){
         Nodo aux = getpFirst();
         boolean found = false;
         
         while (aux!= null){
             if (aux.getData().equals(elem)){
                 found = true;
                 break;
             }
             aux = aux.getpNext();
         }
         return found;
     }
     
     
      //Method to delete element at the start of the list 
     public void deleteAtTheStart(){
         if(!isEmpty()){
             Nodo aux = getpFirst();
             setpFirst(aux.getpNext());
             aux.setpNext(null);
             this.setSize(this.getSize()-1);
         }
     }
     
     // Delete specific element
     
     public void deleteSpecific(Object elem){
         if(!isEmpty()){
             Nodo aux = getpFirst();
             if (elem == aux.getData()){
                 deleteAtTheStart();
             }else{
                 boolean found = false;
                 while(aux.getpNext()!= null && !found){
                     if (aux.getpNext().getData().equals(elem)){
                         found = true;
                         break;
                     }
                 }
                 if (found){
                     Nodo temporary = aux.getpNext();
                     aux.setpNext(temporary.getpNext());
                     temporary.setpNext(null);
                     this.size--;
                 }else{
                     System.out.println("Element is not in the list");
                 }
             }
         }
     }
     
     //This method gets a node by its index in the list
     public Nodo getNodeByIndex( int position){
         if(!isEmpty()){
             Nodo aux = getpFirst();
             for (int i = 0; i < position; i++) {
                 if (aux.getpNext()== null){
                     break;
                 }
                 aux = aux.getpNext();
                 
             }
             return aux;
         }else{
             return null;
         }
     }
     
     //This method reoders the list in ascending order
     public void orderList(){
         int ogsize = getSize();
         for (int i = 0; i < ogsize; i++) {
             Nodo lownode = LowValueNode(getNodeByIndex(i));
             deleteSpecific(lownode.getData());
             addSpecific(i,lownode.getData());
             
             
             
         }
     }
    //Method that will get the node that has the lowest value in thelist
     public Nodo LowValueNode(Nodo aux){
         Nodo pointer = aux;
         Nodo lownode = pointer;
         
         while (pointer.getpNext()!= null){
             if ((int) lownode.getData() > (int) pointer.getpNext().getData()){
                 lownode =  pointer.getpNext();
             }
             
             pointer = pointer.getpNext();
         }
         return lownode;
     }
     
     
     //Method that returns the warehouse node with its index
     public Nodo<Warehouse> WarehouseNodebyIndex (int index){
         Nodo aux = getpFirst();
         for (int i = 0; i < index; i++) {
             aux = aux.getpNext();
             
         }
         return aux;
     }
     
     public Warehouse getWarehouseName (String name){
         Nodo <Warehouse> aux = getpFirst();
         Warehouse warehouse = null;
         
         while (aux != null){
             if (name.equals(aux.getData().getId())){
                 warehouse = aux.getData();
                 break;
             }
             aux = aux.getpNext();
         }
         return warehouse;
     }
     
     // Method that returns the list index of a warehouse 
     public int IndexofElement(String name){
         Nodo <Warehouse> aux = getpFirst();
         int index = -1;
         
         for (int i = 0; i < getSize(); i++) {
             if(aux.getData().getId().equals(name)){
                 index = i;
                 break;
             }
             aux = aux.getpNext();
             
         }
         return index;
     }
             
     
     
     //Method that will return the element in the index that is specified
     public Object getElementInIndex(int position){
         if(!isEmpty()){
             Nodo aux = getpFirst();
             for (int i = 0; i < position; i++) {
                 if (aux.getpNext() == null){
                     break;
                 }
                 aux = aux.getpNext();
                 
             }
             return aux.getData();
         }else{
             return null;
         }
     }
     
     // Method to return name of products as an array
    
     public String [] productsarray(){
         String [] array;
         array = new String[getSize()];
         for (int i = 0; i < getSize(); i++) {
             array[i] = getProductInIndex(i).getName();
             
         }
         return array;
     }
     
     // method that will get the product in index
     
     public Products getProductInIndex (int position){
         if(!isEmpty()){
             Nodo <Products> aux = getpFirst();
             for (int i = 0; i < position; i++) {
                 if(aux.getpNext()== null){
                     break;
                 }
                 aux = aux.getpNext();
                 
             }
             return aux.getData();
         }else{
             return null;
         }
     }
     
      
     // Method that will print inventory of products
     public void printInventoryofProducts(){
        Nodo <Products> aux = getpFirst();
        if (!isEmpty()){
            for (int i = 0; i < getSize(); i++) {
                System.out.println("\nProducto:"+ aux.getData().getName() + "\nCantidad:" + aux.getData().getAmount());
                aux = aux.getpNext();
            }
        }
    }
     
     //Method that will print the name of the products
     public void printNameofProducts(){
         Nodo <Products> aux = getpFirst();
        if (!isEmpty()){
            for (int i = 0; i < getSize(); i++) {
                System.out.println(aux.getData().getName());
                aux = aux.getpNext();
            }
        }
     }
     
     //Method that will pro¡int the amount of each product
     public void printAmountofProducts(){
        Nodo <Products> aux = getpFirst();
        if (!isEmpty()){
            for (int i = 0; i < getSize(); i++) {
                System.out.println(aux.getData().getAmount());
                aux = aux.getpNext();
            }
        }
         
     }
     
     //This will print warehouses
     public void printWarehouse(){
         if(!isEmpty()){
             Nodo <Warehouse> aux = getpFirst();
             while(aux != null){
                 System.out.println(aux.getData().getId());
                 aux = aux.getpNext();
             }
         }else{
             System.out.println("No elements");
         }
     }
     //Method that will return the product matching the name
  public Products getProductName (String name){
      Nodo <Products> aux = getpFirst();
      Products product = null;
      while (aux != null){
          if (aux.getData().getName().equalsIgnoreCase(name)){
              product = aux.getData();
              break;
          }
          aux = aux.getpNext();
      }
      return product;
      
  }
  //Method that returns an array of type Products with all of the available products
  public Products [] productstring(){
      Products [] lista;
      lista = new Products [getSize()];
      for (int i = 0; i < getSize(); i++) {
          lista[i] = getProductInIndex(i);
          
      }
      return lista;
  }
 
  // Method that adds a product to the list
  public void newproduct (String name, int amount){
      Products product = new Products (name, amount);
      addATheEnd(product);
  }
  
    
    
    
//    //Search for products
//    public Nodo searchProduct(String id,String name){
//        Nodo<Products> aux = new Nodo<>();
//        aux = this.getpFirst();
//        if (!this.isEmpty()){
//            for (int i = 0; i < this.getSize(); i++) {
//                if ((aux.getData().getName().equals(name)) && (aux.getData().getId().equals(id))){
//                    return aux;
//                }
//                aux=aux.getpNext();
//            }
//        }else{
//            return null;
//        }
//        return null;
//    }
    
//    public void updateProduct(String name,String id, int amount){
//        Nodo<Products> aux = this.searchProduct(id, name);
//        if (aux!=null){
//            aux.getData().removeProductFromWharehouse(amount);
//        }
//        
//    }

    
    

    // Getters y Setters
    /**
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
}

