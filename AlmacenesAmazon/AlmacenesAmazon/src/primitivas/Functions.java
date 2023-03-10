/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivas;

import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;
import grafos.MatrizAdy;
import grafos.Grafos;

/**
 *
 * @author carri
 */
public class Functions {
    
      public String read_txt(String direction) {
        String text = "";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direction));
            String temp = "";
            String bfRead;
            int option = 0;
            while ((bfRead = bf.readLine()) != null) {
                
                if (bfRead.equalsIgnoreCase("Rutas;")) {
                    option = 1;
                    temp = temp + bfRead+"\n";
                    
                }else if(option ==0){
                    temp = temp + bfRead;
                }else{
                    temp = temp + bfRead + "\n";
                }

                

            }
            text = temp;
        } catch (Exception e) {
            text = "";
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");

        }

        return text;
    }

    /**
     * Get vertice's number
     *
     * @param arInfo
     * @return number of vertices
     */
    public int numVertices(String arInfo) {
        int v = 0;
        if (arInfo.equals("")) {
            return -1;
        }

        try {
            String[] arrayInfo = arInfo.split(";");
            for (int i = 0; i < arrayInfo.length; i++) {
                if (arrayInfo[i].equalsIgnoreCase("Rutas")) {
                    break;
                } else if (arrayInfo[i].equalsIgnoreCase("Almacenes")) {

                } else {
                    v = i;

                }

            }
        } catch (Exception e) {
            v = -1;
        }

        return v;
    }

    /**
     * Extract the txt information; Storage and routes
     *
     * @param arInfo
     * @param am
     * @return graph
     */
    public Grafos getInfo(String arInfo, MatrizAdy am) {

        Grafos g1 = new Grafos(am);
        List l2 = new List();
        g1.setWarehouses(l2);

        String[] arrayInfo = arInfo.split(";");
        for (int i = 0; i < arrayInfo.length; i++) {

            String auxiliar = arrayInfo[i];

            if (auxiliar.length() > 7) {
                auxiliar = auxiliar.substring(0, 7);
            }

            if (arrayInfo[i].equalsIgnoreCase("Rutas")) {
                String chain = arrayInfo[i+1];
                String[] chain2 = chain.split("\n");
                System.out.println(chain2.length);
                for (int j = 1; j < chain2.length; j++) {
                    String[] chain3 = chain2[j].split(",");

                    
                    int numeroFrom = g1.getNumberofWarehouse(chain3[0]);
                    int numeroTo = g1.getNumberofWarehouse(chain3[1]);
                    am.addAnEdge(numeroFrom, numeroTo, Integer.parseInt(chain3[2]));
                }
                
            } else if (arrayInfo[i].equalsIgnoreCase("Almacenes")) {

            } else if (auxiliar.equalsIgnoreCase("Almacen")) {
                List l1 = new List();

                String[] arrayInvent = arrayInfo[i].split(":");
                String oracion = arrayInvent[1];
                //System.out.println(arrayInfo[i]);
                String name = arrayInvent[0];

//                System.out.println("\n");
                int kar = 0;
                for (int j = 0; j < oracion.length(); j++) {
                    if (oracion.charAt(j) == ',') {
                        String product = oracion.substring(0, j);
                        for (int k = 0; k < oracion.length() - j; k++) {

                            try {
                                Integer.parseInt(Character.toString(oracion.charAt(j + k + 1)));
                            } catch (Exception e) {
                                kar = j + k;

                                break;
                            }
                        }
                        int amount = Integer.parseInt(oracion.substring(j + 1, kar + 1));
                        oracion = oracion.replace(product + "," + oracion.substring(j + 1, kar + 1), "");
                        j = 0;
                        kar = 0;


                        Products p1 = new Products(product, amount);
                        l1.addAtTheStart(p1);

                    }
                }

                g1.createNewWarehouse(name,l1);

            }
        }

        return g1;

    }
    
    /**
     * Saves the graph information on the txt
     * @param g
     * @param direction 
     */

    public void write_txt(Grafos g, String direction) {
        String info = "Almacenes;";
        Nodo <Warehouse> aux = g.getWarehouses().getpFirst();
        String[] storage = new String[g.getSize()];
        for (int i = 0; i < g.getSize(); i++) {
            info += "\n" + aux.getData().getId() + ":";
            String[] arrayAux = aux.getData().getId().split(" ");
            storage[i] = arrayAux[1];
            for (int j = 0; j < aux.getData().getProducts().getSize(); j++) {
                info += "\n" + aux.getData().getProducts().getProductInIndex(j).getName() + "," + aux.getData().getProducts().getProductInIndex(j).getAmount();
                if (j == aux.getData().getProducts().getSize() - 1) {
                    info += ";";

                }
            }
            aux = aux.getpNext();

        }

        info += "\nRutas;";
        int[][] matrix = g.getMatrixAdy().getMatrix();

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage.length; j++) {
                if (matrix[i][j] != 0) {
                    info += "\n" + storage[i] + "," + storage[j] + "," + matrix[i][j];
                }

            }
            //System.out.println(storage[i]);
        }

//        System.out.println(info);
        try {
            PrintWriter pw = new PrintWriter(direction);
            pw.print(info);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso!", "??xito", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}

