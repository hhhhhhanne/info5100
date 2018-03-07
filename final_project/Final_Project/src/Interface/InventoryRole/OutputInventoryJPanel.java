/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.InventoryRole;

import Business.Account.Account;
import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodBank;
import Business.Enterprise.Government;
import Business.Enterprise.Supplier;
import Business.Food.FoodInventory;
import Business.Request.FoodRequest;
import Business.Request.Request;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaoxiaohan
 */
public class OutputInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OutputInventoryJPanel
     */
    private JPanel userProcessContainer;
    private Business business;
    private Account account;
    private Supplier supplier;
    private FoodBank foodbank;
    private Enterprise enterprise;
    private Government government;

    public OutputInventoryJPanel(JPanel userProcessContainer, Business business, Account account, Enterprise enterprise, Government government) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.enterprise = enterprise;
        this.government = government;
        if (enterprise instanceof Supplier) {
            this.supplier = (Supplier) enterprise;
            populateSupplierInventory();
            populateFoodBankRequest();
        }
        if (enterprise instanceof FoodBank) {
            this.foodbank = (FoodBank) enterprise;
            populateFoodBankInventory();
            populateAgentRequest();
        }
        this.workRequestJTable.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                if(workRequestJTable.getSelectedRow() > -1) {
                    tableListener();
                }
            }
        });

    }

    public void populateSupplierInventory() {
        DefaultTableModel model = (DefaultTableModel) tblin.getModel();

        model.setRowCount(0);

        for (FoodInventory inventory : supplier.getInventoryList()) {
            Object[] row = new Object[2];
            row[0] = inventory;
            row[1] = inventory.getQuantity();

            model.addRow(row);
        }
    }

    public void populateFoodBankInventory() {
        DefaultTableModel model = (DefaultTableModel) tblin.getModel();

        model.setRowCount(0);

        for (FoodInventory inventory : foodbank.getInventoryList()) {
            Object[] row = new Object[2];
            row[0] = inventory;
            row[1] = inventory.getQuantity();

            model.addRow(row);
        }
    }

    public void populateAgentRequest() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (Request request : foodbank.getOutRequestList().getRequestList()) {
            FoodRequest foodRequest = (FoodRequest) request;
            Object[] row = new Object[7];
            row[0] = foodRequest;
            row[1] = foodRequest.getFood().getName();
            row[2] = foodRequest.getQuantity();
            row[3] = foodRequest.getEnterprise();
            row[4] = foodRequest.getSender();
            row[5] = foodRequest.getReceiver();
            row[6] = foodRequest.getStatus();

            model.addRow(row);
        }
    }

    public void populateFoodBankRequest() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);

        for (Request request : business.getFoodbankRequestList().getRequestList()) {
            FoodRequest foodRequest = (FoodRequest) request;
            Object[] row = new Object[7];
            row[0] = foodRequest;
            row[1] = foodRequest.getFood().getName();
            row[2] = foodRequest.getQuantity();
            row[3] = foodRequest.getEnterprise();
            row[4] = foodRequest.getSender();
            row[5] = foodRequest.getReceiver();
            row[6] = foodRequest.getStatus();

            model.addRow(row);
        }
    }

    public void tableListener() {
        FoodRequest foodRequest = (FoodRequest) workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0);
        if (foodRequest.getSender() == this.account) {
            this.assignJButton.setEnabled(false);
            this.processJButton.setEnabled(false);
        } else {
            if (foodRequest.getStatus().equals("Sent")) {
                this.assignJButton.setEnabled(true);
                this.processJButton.setEnabled(false);
            } else if (foodRequest.getStatus().equals("Pending")) {
                if (foodRequest.getReceiver() == this.account) {
                    this.assignJButton.setEnabled(false);
                    this.processJButton.setEnabled(true);
                } else {
                    this.assignJButton.setEnabled(false);
                    this.processJButton.setEnabled(false);
                }
            } else {
                this.assignJButton.setEnabled(false);
                this.processJButton.setEnabled(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblin = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("stock - out");

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "RequestID", "FoodName", "Quantity", "Enterprise", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        processJButton.setText("Sent Ship Message");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        tblin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Food name", "Quantity"
            }
        ));
        jScrollPane2.setViewportView(tblin);

        jButton1.setText("<back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(assignJButton)
                            .addGap(37, 37, 37)
                            .addComponent(processJButton))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignJButton)
                    .addComponent(processJButton)
                    .addComponent(jButton1))
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        if (enterprise instanceof FoodBank) {

            int selectedRow = workRequestJTable.getSelectedRow();

            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "please select a row");
                return;
            }

            FoodRequest request = (FoodRequest) workRequestJTable.getValueAt(selectedRow, 0);

            if (foodbank.searchInventory(request.getFood()) == null) {
                JOptionPane.showMessageDialog(null, "there is no such food");
                return;
            } else {
                int oldNum = foodbank.searchInventory(request.getFood()).getQuantity();
                if (oldNum - request.getQuantity() < 0) {
                    JOptionPane.showMessageDialog(null, "lack stock");
                    return;
                } else {
                    foodbank.searchInventory(request.getFood()).setQuantity(oldNum - request.getQuantity());
                    request.setReceiver(account);
                    request.setStatus("Pending");
                }
            }

            populateAgentRequest();
            populateFoodBankInventory();
        }

        if (enterprise instanceof Supplier) {

            int selectedRow = workRequestJTable.getSelectedRow();

            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "please select a row");
                return;
            }

            FoodRequest request = (FoodRequest) workRequestJTable.getValueAt(selectedRow, 0);

            if (supplier.searchInventoryByName(request.getFood()) == null) {
                JOptionPane.showMessageDialog(null, "there is no such food");
                return;
            } else {
                int oldNum = supplier.searchInventoryByName(request.getFood()).getQuantity();
                if (oldNum - request.getQuantity() < 0) {
                    JOptionPane.showMessageDialog(null, "lack stock");
                    return;
                } else {
                    supplier.searchInventoryByName(request.getFood()).setQuantity(oldNum - request.getQuantity());
                    request.setReceiver(account);
                    request.setStatus("Pending");
                }
            }

            populateSupplierInventory();
            populateFoodBankRequest();
        }

    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "please select a row");
            return;
        }

        FoodRequest request = (FoodRequest) workRequestJTable.getValueAt(selectedRow, 0);
        if (!request.getStatus().equals("Pending")) {
            JOptionPane.showMessageDialog(null, "please assign this request first");
            return;
        }
        request.setStatus("Processing");

        ProcessRequestJPanel processRequestJPanel = new ProcessRequestJPanel(userProcessContainer, request, enterprise);
        userProcessContainer.add("processRequestJPanel", processRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_processJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable tblin;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
