package interfaces;
/**
 *
 * @author Camila Garcia
 */

public class Main extends javax.swing.JFrame {
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveDataButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        invReportButton = new javax.swing.JButton();
        invManagementButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        uploadDataButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addNewRutesButton = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        newOrderButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        newStorageButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        storageMapButton = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("ALMACENES");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 230, 40));

        saveDataButton.setBackground(new java.awt.Color(255, 153, 0));
        saveDataButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        saveDataButton.setForeground(new java.awt.Color(255, 255, 255));
        saveDataButton.setText("Guardar Datos");
        saveDataButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveDataButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataButtonActionPerformed(evt);
            }
        });
        jPanel4.add(saveDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 240, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Logo-Amazon (3) (1).jpg"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 70));

        invReportButton.setBackground(new java.awt.Color(0, 0, 0));
        invReportButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        invReportButton.setForeground(new java.awt.Color(255, 255, 255));
        invReportButton.setText("REPORTE INVENTARIO");
        invReportButton.setBorder(null);
        invReportButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invReportButtonActionPerformed(evt);
            }
        });
        jPanel3.add(invReportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 170, 30));

        invManagementButton.setBackground(new java.awt.Color(0, 0, 0));
        invManagementButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        invManagementButton.setForeground(new java.awt.Color(255, 255, 255));
        invManagementButton.setText("GESTION DE INVENTARIO");
        invManagementButton.setBorder(null);
        invManagementButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        invManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invManagementButtonActionPerformed(evt);
            }
        });
        jPanel3.add(invManagementButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 170, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/folder (1).png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 110, 90));

        uploadDataButton.setBackground(new java.awt.Color(0, 0, 0));
        uploadDataButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        uploadDataButton.setForeground(new java.awt.Color(255, 255, 255));
        uploadDataButton.setText("CARGAR DATA");
        uploadDataButton.setToolTipText("");
        uploadDataButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        uploadDataButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadDataButtonActionPerformed(evt);
            }
        });
        jPanel3.add(uploadDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 170, 30));
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/inv-removebg-preview (1).png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, 200));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rut-removebg-preview (1).png"))); // NOI18N

        addNewRutesButton.setBackground(new java.awt.Color(0, 0, 0));
        addNewRutesButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        addNewRutesButton.setForeground(new java.awt.Color(255, 255, 255));
        addNewRutesButton.setText("AGREGAR RUTAS");
        addNewRutesButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addNewRutesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addNewRutesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewRutesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(53, 53, 53))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(addNewRutesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(addNewRutesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 210, -1));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        newOrderButton.setBackground(new java.awt.Color(0, 0, 0));
        newOrderButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        newOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        newOrderButton.setText("NUEVO PEDIDO");
        newOrderButton.setBorder(null);
        newOrderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOrderButtonActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pedido (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(newOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel8)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(newOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 210, 220));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Almacen (1).png"))); // NOI18N

        newStorageButton.setBackground(new java.awt.Color(0, 0, 0));
        newStorageButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        newStorageButton.setForeground(new java.awt.Color(255, 255, 255));
        newStorageButton.setText("NUEVO ALMACEN");
        newStorageButton.setBorder(null);
        newStorageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newStorageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStorageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(newStorageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newStorageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, -1, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/map__1_-removebg-preview.png"))); // NOI18N

        storageMapButton.setBackground(new java.awt.Color(0, 0, 0));
        storageMapButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        storageMapButton.setForeground(new java.awt.Color(255, 255, 255));
        storageMapButton.setText("MAPA ALMACENES");
        storageMapButton.setBorder(null);
        storageMapButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        storageMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storageMapButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel12))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(storageMapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(storageMapButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 350, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Triggers page change to NewStoragePage on press
     */
    private void newStorageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStorageButtonActionPerformed

        Code.openNewAlmacen();
    }//GEN-LAST:event_newStorageButtonActionPerformed

    private void invManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invManagementButtonActionPerformed
        Code.openStockManagementPage();
    }//GEN-LAST:event_invManagementButtonActionPerformed

    private void saveDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataButtonActionPerformed
        InterfaceFunctions.saveInfo("¿Está seguro que desea guardar la información actual?");
    }//GEN-LAST:event_saveDataButtonActionPerformed

    private void newOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOrderButtonActionPerformed
        Code.openNewOrderPage();
    }//GEN-LAST:event_newOrderButtonActionPerformed

    private void uploadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadDataButtonActionPerformed
        InterfaceFunctions.saveInfo("¿Desea guardar la información actual?");
        Code.openUploadDataPage();
    }//GEN-LAST:event_uploadDataButtonActionPerformed

    private void invReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invReportButtonActionPerformed
        // TODO add your handling code here:
        Code.openShowInvPage();
    }//GEN-LAST:event_invReportButtonActionPerformed

    private void storageMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storageMapButtonActionPerformed
        Code.showGraphMap();
    }//GEN-LAST:event_storageMapButtonActionPerformed

    private void addNewRutesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewRutesButtonActionPerformed
        Code.openAddNewRutes();
    }//GEN-LAST:event_addNewRutesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewRutesButton;
    private javax.swing.JButton invManagementButton;
    private javax.swing.JButton invReportButton;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton newOrderButton;
    private javax.swing.JButton newStorageButton;
    private javax.swing.JButton saveDataButton;
    private javax.swing.JButton storageMapButton;
    private javax.swing.JButton uploadDataButton;
    // End of variables declaration//GEN-END:variables
}
