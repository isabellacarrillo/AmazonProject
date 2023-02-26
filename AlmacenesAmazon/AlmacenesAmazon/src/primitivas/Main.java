package primitivas;

import interfaces.Code;
import grafos.Grafos;
import grafos.MatrizAdy;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Garcia
 */
public class Main {

    /**
     * Main app method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initializeApp();
        Code.openMain();

    }

    /**
     * Starts the data flow for the proyect
     */
    public static void initializeApp() {

        int v;
        // remember at the end to change the file to their original values 
        String direccion = "src\\primitivas\\Amazon.txt";
        Code.setDirection(direccion);
        Functions dataFile = new Functions();
        String arInfo = dataFile.read_txt(direccion);

        v = dataFile.numVertices(arInfo);
        MatrizAdy am = new MatrizAdy(v);

        
        Grafos g1 = dataFile.getInfo(arInfo, am);

        Code.setGraph(g1);

    }

    /**
     * Sets the graph info using the txt given by user
     *
     * @param path
     */
    public static void initializeAppWithNewInfo(String path) {
        int v;
        String direccion = path;

        Functions dataFile = new Functions();
        String arInfo = dataFile.read_txt(direccion);

        if (!(arInfo.contains("Almacenes") && arInfo.contains("Rutas"))) {
            JOptionPane.showMessageDialog(null, "Alerta, el documento dado no contiene el formato correspondiente, por favor intentar de nuevo", "Alerta", 2);
        } else {
            v = dataFile.numVertices(arInfo);

            if (v == -1) {
                JOptionPane.showMessageDialog(null, "Alerta, el documento dado no contiene el formato correspondiente, por favor intentar de nuevo", "Alerta", 2);

            } else {
                MatrizAdy am = new MatrizAdy(v);

                Grafos g1 = dataFile.getInfo(arInfo, am);
                if (g1 != null) {
                    Code.setDirection(direccion);
                    Code.setGraph(g1);
                    JOptionPane.showMessageDialog(null, "Proceso exitoso, los datos han sido cargados", "Éxito", 1);

                } else {
                    JOptionPane.showMessageDialog(null, "Alerta, el documento dado no contiene el formato correspondiente, por favor intentar de nuevo", "Alerta", 2);

                }
            }
        }

    }

}
