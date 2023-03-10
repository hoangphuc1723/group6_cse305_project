/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package staff_view;

import controller.AccountInforMap;
import controller.Administrator;
import controller.RestoreDataUtils;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.AssistantWardenMaintenance;
import model.Form;
import view.LoginForm;
import view.LoginForm;

/**
 *
 * @author kuriy
 */
public class WardenMaintenance extends javax.swing.JFrame {

    /**
     * Creates new form StaffHomePage
     */
    DefaultTableModel model = new DefaultTableModel();
    AssistantWardenMaintenance assistant;

    public WardenMaintenance(int hallNumber) {
        initComponents();
        //this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addListener();
        this.assistant = Administrator.getListMaintenanceAssistant().get(hallNumber-1);
        
        File file = new File("wardena" + hallNumber + ".txt");
        assistant.setListForm(RestoreDataUtils.restoreFormListData(file));
        addDataToTable();
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
        removeMenuItem = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        maintenanceTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        staffMenu = new javax.swing.JMenu();

        removeMenuItem.setText("Address");
        removeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMenuItemActionPerformed(evt);
            }
        });
        popupMenu.add(removeMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STAFF Homepage");

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
        jScrollPane1.setViewportView(maintenanceTable);
        if (maintenanceTable.getColumnModel().getColumnCount() > 0) {
            maintenanceTable.getColumnModel().getColumn(0).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            maintenanceTable.getColumnModel().getColumn(1).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(2).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(3).setResizable(false);
            maintenanceTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        staffMenu.setText("View");
        jMenuBar1.add(staffMenu);
        staffMenu.getAccessibleContext().setAccessibleName("Form");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logoutButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(logoutButton)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    public static void addRowMaintenanceTable(Object[] object) {
        DefaultTableModel maintenance = (DefaultTableModel) maintenanceTable.getModel();
        maintenance.addRow(object);
    }
    
    public void addDataToTable(){
        for(Form form : assistant.getListForm()){
            String id = form.getStudentID();
            String name = AccountInforMap.getName(id);
            String room = AccountInforMap.getRoom(id);
            Object[] object = new Object[]{form.getStudentID(), name, room, form.getSummary()};
            addRowMaintenanceTable(object);
        }
    }

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void removeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeMenuItemActionPerformed
        int row = maintenanceTable.getSelectedRow();
        assistant.addressTheProblem(assistant.getListForm().get(row));
        model = (DefaultTableModel) maintenanceTable.getModel();
        model.removeRow(row);
    }//GEN-LAST:event_removeMenuItemActionPerformed

    
    private void addListener() {
        maintenanceTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    doubleClickOnTable(maintenanceTable);
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

    private void doubleClickOnTable(Component evt) {
        int row = maintenanceTable.getSelectedRow();
        StringBuilder sBuilder = new StringBuilder();

        try {
            String id = (String) maintenanceTable.getValueAt(row, 0);
            String name = (String) maintenanceTable.getValueAt(row, 1);
            String room = (String) maintenanceTable.getValueAt(row, 2);
            String des = (String) maintenanceTable.getValueAt(row, 3);
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
            java.util.logging.Logger.getLogger(WardenMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WardenMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WardenMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WardenMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new WardenMaintenance().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private static javax.swing.JTable maintenanceTable;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenuItem removeMenuItem;
    private javax.swing.JMenu staffMenu;
    // End of variables declaration//GEN-END:variables
}
