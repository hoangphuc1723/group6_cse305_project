/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package staff_view;

import controller.AccountInforMap;
import controller.Administrator;
import controller.ExitOptionBackup;
import controller.RestoreDataUtils;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Form;
import model.GeneralSecretary;
import view.LoginForm;

/**
 *
 * @author kuriy
 */
public class MaintenanceSecretaryHomePage extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    GeneralSecretary secretary;
    
    public MaintenanceSecretaryHomePage(int hallNumber) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addListener();

        //
        this.secretary = Administrator.getListGeneralSecretarys().get(hallNumber - 1);
        this.secretary.setListFormMaintenance(RestoreDataUtils.restoreFormListData(new File("mata" + hallNumber + ".txt")));
        addDataToTable();
        
        //backup
        ExitOptionBackup.exitOptionList(this, hallNumber, secretary.getListFormMess());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        forwardToMaintenance = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        maintenanceTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();

        forwardToMaintenance.setText("Forward To Maintenance");
        forwardToMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardToMaintenanceActionPerformed(evt);
            }
        });
        popupMenu.add(forwardToMaintenance);

        jMenuItem1.setText("Decline");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        popupMenu.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Maintenance Form");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        maintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Room", "Content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        maintenanceTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        maintenanceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(maintenanceTable);
        if (maintenanceTable.getColumnModel().getColumnCount() > 0) {
            maintenanceTable.getColumnModel().getColumn(0).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            maintenanceTable.getColumnModel().getColumn(1).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(2).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(3).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addRowMaintenanceTable(Object[] object) {
        model = (DefaultTableModel) maintenanceTable.getModel();
        model.addRow(object);
    }
    
    public void addDataToTable(){
        for(Form form : secretary.getListFormMaintenance()){
            String name = AccountInforMap.getName(form.getStudentID());
            String room = AccountInforMap.getRoom(form.getStudentID());
            Object[] object = new Object[]{form.getStudentID(), name, room, form.getSummary()};
            addRowMaintenanceTable(object);
        }
    }


    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void forwardToMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardToMaintenanceActionPerformed
        int row = maintenanceTable.getSelectedRow();

        try {
            Form form = secretary.getListFormMaintenance().get(row);
            secretary.forwardFormMaintenance(form);
            secretary.reviseFormMaintenance(form);
            JOptionPane.showMessageDialog(rootPane, "Successfull!");
        } catch (ArrayIndexOutOfBoundsException e) {
            /*...*/
        } finally {
            ((DefaultTableModel) maintenanceTable.getModel()).removeRow(row);
        }
    }//GEN-LAST:event_forwardToMaintenanceActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int row = maintenanceTable.getSelectedRow();
        secretary.reviseFormMess(secretary.getListFormMess().get(row));
        ((DefaultTableModel) maintenanceTable.getModel()).removeRow(row);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void addListener() {
        
        //
        maintenanceTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    doubleClickOnTable(maintenanceTable, maintenanceTable);
                }
            }
        });


        //
        maintenanceTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(maintenanceTable, e.getX(), e.getY());
                }
            }
        });
    }

    private void doubleClickOnTable(Component evt, JTable a) {
        int row = a.getSelectedRow();
        StringBuilder sBuilder = new StringBuilder();

        try {
            String id = String.valueOf(a.getValueAt(row, 0));
            String name = String.valueOf(a.getValueAt(row, 1));
            String room = String.valueOf(a.getValueAt(row, 2));
            String des = secretary.getListFormMaintenance().get(row).getDescription();
            sBuilder.append("ID: ").append(id).append(", ").append("Name: ").append(name).
                    append(", Room: ").append(room).append("\n").append("Description: ").append(des);
        } catch (ArrayIndexOutOfBoundsException e) {

        } finally {
            JOptionPane.showMessageDialog(evt, sBuilder);
        }

    }

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
            java.util.logging.Logger.getLogger(MaintenanceSecretaryHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MaintenanceSecretaryHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MaintenanceSecretaryHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MaintenanceSecretaryHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MaintenanceSecretaryHomePage().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem forwardToMaintenance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private static javax.swing.JTable maintenanceTable;
    private javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables
}
