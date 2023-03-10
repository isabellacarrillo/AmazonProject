
package interfaces;

/**
 *
 * @author Camila Garcia
 */


import javax.swing.JOptionPane;
import grafos.Grafos;
public class AddRutes extends javax.swing.JFrame {

    String from = "";
    String direction = "";

    /**
     * Creates new form AddNewRutesPage
     */

    public AddRutes() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        receiverChooserComboBox.setEnabled(false);
        selectParamButton.setEnabled(false);
        costTextField.setEnabled(false);
        addNewRutesButton.setEnabled(false);

    }
   
    public void fillTransmitterChooserCombo(Grafos g1) {
        transmitterChooserComboBox.removeAllItems();
        String[] storage = g1.warehousestring();
        for (int i = 0; i < storage.length; i++) {
            transmitterChooserComboBox.addItem(storage[i]);
        }
    }
    public void fillReceiverChooserCombo(Grafos g1) {
        receiverChooserComboBox.removeAllItems();
        String[] storage = g1.warehousestring();
        String[] arrayAux = InterfaceFunctions.DeTextArray(direction);
        for (int i = 0; i < storage.length; i++) {
            if (!storage[i].equalsIgnoreCase(from)) {
                boolean validator = true;
                for (int j = 0; j < arrayAux.length; j++) {
                    String[] aux = arrayAux[j].split(",");
                    if (aux[0].equalsIgnoreCase(storage[i])) {
                        validator = false;

                    }
                }
                if (validator) {
                    receiverChooserComboBox.addItem(storage[i]);

                }
            }
        }

    }
    
    /**
     * Get the graph information from Code
     * @param graph 
     */

    public void createGprah(Grafos graph) {
        Grafos g1 = graph;
        rutesTextArea.setEditable(false);
        fillTransmitterChooserCombo(g1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        receiverChooserComboBox = new javax.swing.JComboBox<>();
        transmitterChooserComboBox = new javax.swing.JComboBox<>();
        selectParamButton = new javax.swing.JButton();
        costTextField = new javax.swing.JTextField();
        selectFromButton = new javax.swing.JButton();
        showStorageTransmitterLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rutesTextArea = new javax.swing.JTextArea();
        selectDistanceLabel = new javax.swing.JLabel();
        selectedRutesLabel = new javax.swing.JLabel();
        addReceiverLabel = new javax.swing.JLabel();
        addTransmitterLabel = new javax.swing.JLabel();
        transmitterStorage = new javax.swing.JLabel();
        backToTheMenuButton = new javax.swing.JButton();
        addNewRutesButton = new javax.swing.JButton();
        deleteAllButton = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(null);
        jPanel4.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 50, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receiverChooserComboBox.setBackground(new java.awt.Color(255, 255, 255));
        receiverChooserComboBox.setForeground(new java.awt.Color(0, 0, 0));
        receiverChooserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receiverChooserComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(receiverChooserComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 180, 30));

        transmitterChooserComboBox.setBackground(new java.awt.Color(255, 255, 255));
        transmitterChooserComboBox.setForeground(new java.awt.Color(0, 0, 0));
        transmitterChooserComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transmitterChooserComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(transmitterChooserComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, 30));

        selectParamButton.setBackground(new java.awt.Color(255, 153, 0));
        selectParamButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        selectParamButton.setForeground(new java.awt.Color(0, 0, 0));
        selectParamButton.setText("Ok");
        selectParamButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectParamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectParamButtonActionPerformed(evt);
            }
        });
        jPanel1.add(selectParamButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 180, 30));

        costTextField.setBackground(new java.awt.Color(255, 255, 255));
        costTextField.setForeground(new java.awt.Color(0, 0, 0));
        costTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(costTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 220, 30));

        selectFromButton.setBackground(new java.awt.Color(255, 153, 0));
        selectFromButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        selectFromButton.setForeground(new java.awt.Color(0, 0, 0));
        selectFromButton.setText("Ok");
        selectFromButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectFromButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFromButtonActionPerformed(evt);
            }
        });
        jPanel1.add(selectFromButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, 30));

        showStorageTransmitterLabel.setFont(new java.awt.Font("Cambria Math", 1, 14)); // NOI18N
        showStorageTransmitterLabel.setForeground(new java.awt.Color(255, 255, 255));
        showStorageTransmitterLabel.setText("  ");
        jPanel1.add(showStorageTransmitterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 150, -1));

        rutesTextArea.setBackground(new java.awt.Color(255, 255, 255));
        rutesTextArea.setColumns(20);
        rutesTextArea.setForeground(new java.awt.Color(0, 0, 0));
        rutesTextArea.setRows(5);
        jScrollPane1.setViewportView(rutesTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 220, -1));

        selectDistanceLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        selectDistanceLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectDistanceLabel.setText("Distancia(KM)");
        jPanel1.add(selectDistanceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 110, -1));

        selectedRutesLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        selectedRutesLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectedRutesLabel.setText("Rutas seleccionadas:");
        jPanel1.add(selectedRutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 180, -1));

        addReceiverLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        addReceiverLabel.setForeground(new java.awt.Color(255, 255, 255));
        addReceiverLabel.setText("Almacen que recibe:");
        jPanel1.add(addReceiverLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 220, 30));

        addTransmitterLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        addTransmitterLabel.setForeground(new java.awt.Color(255, 255, 255));
        addTransmitterLabel.setText("Almacen que envia:");
        jPanel1.add(addTransmitterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 150, 30));

        transmitterStorage.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        transmitterStorage.setForeground(new java.awt.Color(255, 255, 255));
        transmitterStorage.setText("Emite:");
        jPanel1.add(transmitterStorage, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 180, -1));

        backToTheMenuButton.setBackground(new java.awt.Color(0, 0, 0));
        backToTheMenuButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        backToTheMenuButton.setForeground(new java.awt.Color(255, 153, 0));
        backToTheMenuButton.setText("<Menu");
        backToTheMenuButton.setBorder(null);
        backToTheMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToTheMenuButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backToTheMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 150, 40));

        addNewRutesButton.setBackground(new java.awt.Color(255, 153, 0));
        addNewRutesButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        addNewRutesButton.setForeground(new java.awt.Color(0, 0, 0));
        addNewRutesButton.setText("Agregar Rutas");
        addNewRutesButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addNewRutesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewRutesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addNewRutesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 120, 40));

        deleteAllButton.setBackground(new java.awt.Color(255, 153, 0));
        deleteAllButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        deleteAllButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteAllButton.setText("Borrar");
        deleteAllButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteAllButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 110, 40));

        jPanel1.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectParamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectParamButtonActionPerformed
        if (receiverChooserComboBox.getSelectedItem() != null) {
            String cost = costTextField.getText();
            String storage = receiverChooserComboBox.getSelectedItem().toString();
            System.out.println(storage);
            if (InterfaceFunctions.isNum(cost)) {
                int distance = Integer.parseInt(cost);
                String output = "";
                direction += storage + "," + distance + "  ";
                fillReceiverChooserCombo(Code.getGraph());
                rutesTextArea.setText("");
                String[] directionArray = direction.split("  ");
                for (int i = 0; i < directionArray.length; i++) {
                    output += directionArray[i] + "\n";

                }
                rutesTextArea.setText(output);
                addNewRutesButton.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un numero v??lido en la distancia");
            }
        }

        costTextField.setText("");


    }//GEN-LAST:event_selectParamButtonActionPerformed

    private void selectFromButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFromButtonActionPerformed

        from = transmitterChooserComboBox.getSelectedItem().toString();
        fillReceiverChooserCombo(Code.getGraph());
        receiverChooserComboBox.setEnabled(true);
        selectParamButton.setEnabled(true);
        costTextField.setEnabled(true);
        transmitterChooserComboBox.setEnabled(false);
        selectFromButton.setEnabled(false);
        showStorageTransmitterLabel.setText(from);

    }//GEN-LAST:event_selectFromButtonActionPerformed

    private void receiverChooserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receiverChooserComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receiverChooserComboBoxActionPerformed

    private void costTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costTextFieldActionPerformed

    private void backToTheMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToTheMenuButtonActionPerformed
        Code.getBackToMainPage();
    }//GEN-LAST:event_backToTheMenuButtonActionPerformed

    private void addNewRutesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewRutesButtonActionPerformed
        InterfaceFunctions.NewRutasB(direction, from);
        from = "";
        direction = "";
        receiverChooserComboBox.removeAllItems();
        transmitterChooserComboBox.setEnabled(true);
        selectFromButton.setEnabled(true);
        receiverChooserComboBox.setEnabled(false);
        selectParamButton.setEnabled(false);
        costTextField.setEnabled(false);
        addNewRutesButton.setEnabled(false);
        costTextField.setText("");
        rutesTextArea.setText("");
        showStorageTransmitterLabel.setText("Seleccione un almac??n primero");
    }//GEN-LAST:event_addNewRutesButtonActionPerformed

    private void deleteAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllButtonActionPerformed
        from = "";
        direction = "";
        receiverChooserComboBox.removeAllItems();
        transmitterChooserComboBox.setEnabled(true);
        selectFromButton.setEnabled(true);
        receiverChooserComboBox.setEnabled(false);
        selectParamButton.setEnabled(false);
        costTextField.setEnabled(false);
        addNewRutesButton.setEnabled(false);
        costTextField.setText("");
        rutesTextArea.setText("");
        showStorageTransmitterLabel.setText("Seleccione un almac??n primero");

    }//GEN-LAST:event_deleteAllButtonActionPerformed

    private void transmitterChooserComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transmitterChooserComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transmitterChooserComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddRutes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRutes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRutes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRutes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRutes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    javax.swing.JLabel Logo;
    private javax.swing.JButton addNewRutesButton;
    private javax.swing.JLabel addReceiverLabel;
    private javax.swing.JLabel addTransmitterLabel;
    private javax.swing.JButton backToTheMenuButton;
    private javax.swing.JTextField costTextField;
    private javax.swing.JButton deleteAllButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> receiverChooserComboBox;
    private javax.swing.JTextArea rutesTextArea;
    private javax.swing.JLabel selectDistanceLabel;
    private javax.swing.JButton selectFromButton;
    private javax.swing.JButton selectParamButton;
    private javax.swing.JLabel selectedRutesLabel;
    private javax.swing.JLabel showStorageTransmitterLabel;
    private javax.swing.JComboBox<String> transmitterChooserComboBox;
    private javax.swing.JLabel transmitterStorage;
    // End of variables declaration//GEN-END:variables
}
