/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.InventoryRole;

import Business.Account.Account;
import Business.Business;
import Business.Enterprise.Agent;
import Business.Enterprise.Enterprise;
import Business.Enterprise.FoodBank;
import Business.Enterprise.Government;
import Business.Enterprise.Supplier;
import Business.Food.FoodInventory;
import Business.Network.Network;
import Business.Request.FoodRequest;
import Business.Request.Request;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.Marshaller;

/**
 *
 * @author zhaoxiaohan
 */
public class InputInventoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageServiceInventoryJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Agent agent;
    private FoodBank foodBank;
    private Supplier supplier;
    private Account account;
    private Government government;
    private Business business;

    public InputInventoryJPanel(JPanel userProcessContainer, Enterprise enterprise, Account account, Government government, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.enterprise = enterprise;
        this.government = government;
        btnAdd.setEnabled(false);
        if (enterprise instanceof Agent) {
            this.agent = (Agent) enterprise;
            populateAgentInventoryTable();
            populateAgentRequestTable();
        }
        if (enterprise instanceof FoodBank) {
            this.foodBank = (FoodBank) enterprise;
            populateFoodBankInventoryTable();
            populateFoodBankRequestTable();
        }
        if (enterprise instanceof Supplier) {
            this.supplier = (Supplier) enterprise;
            btnAdd.setEnabled(true);
            btnReceive.setVisible(false);
            btnRequest.setVisible(false);
            populateSupplierInventoryTable();
            workRequestJTable.setVisible(false);
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

    public void populateAgentInventoryTable() {
        DefaultTableModel model = (DefaultTableModel) tblin.getModel();

        model.setRowCount(0);
        for (FoodInventory inventory : agent.getInventoryList()) {
            Object[] row = new Object[3];
            row[0] = inventory;
            row[1] = inventory.getFood().getPrice();
            row[2] = inventory.getQuantity();

            model.addRow(row);
        }
    }

    public void populateAgentRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (Request request : agent.getFoodBank().getOutRequestList().getRequestList()) {
            FoodRequest foodRequest = (FoodRequest) request;
            Object[] row = new Object[7];
            row[0] = foodRequest;
            row[1] = foodRequest.getFood().getName();
            row[2] = foodRequest.getQuantity();
            row[3] = foodRequest.getEnterprise();
            row[4] = foodRequest.getReceiver();
            row[5] = foodRequest.getStatus();
            String shipping = foodRequest.getShipping();
            row[6] = shipping == null ? "Waiting" : shipping;

            model.addRow(row);
        }
    }

    public void populateFoodBankInventoryTable() {
        DefaultTableModel model = (DefaultTableModel) tblin.getModel();

        model.setRowCount(0);
        for (FoodInventory inventory : foodBank.getInventoryList()) {
            Object[] row = new Object[3];
            row[0] = inventory;
            row[1] = inventory.getFood().getPrice();
            row[2] = inventory.getQuantity();

            model.addRow(row);
        }
    }

    public void populateFoodBankRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (Request request : business.getFoodbankRequestList().getRequestList()) {
            FoodRequest foodRequest = (FoodRequest) request;
            Object[] row = new Object[7];
            row[0] = foodRequest;
            row[1] = foodRequest.getFood().getName();
            row[2] = foodRequest.getQuantity();
            row[3] = foodRequest.getEnterprise();
            row[4] = foodRequest.getReceiver();
            row[5] = foodRequest.getStatus();
            String shipping = foodRequest.getShipping();
            row[6] = shipping == null ? "Waiting" : shipping;

            model.addRow(row);
        }
    }

    public void populateSupplierInventoryTable() {
        DefaultTableModel model = (DefaultTableModel) tblin.getModel();

        model.setRowCount(0);
        for (FoodInventory inventory : supplier.getInventoryList()) {
            Object[] row = new Object[3];
            row[0] = inventory;
            row[1] = inventory.getFood().getPrice();
            row[2] = inventory.getQuantity();

            model.addRow(row);
        }
    }

    public void tableListener() {
        FoodRequest foodRequest = (FoodRequest) workRequestJTable.getValueAt(workRequestJTable.getSelectedRow(), 0);
        if (foodRequest.getSender() == this.account) {
            if (foodRequest.getStatus().equals("Shipping")) {
                this.btnReceive.setEnabled(true);
            } else {
                this.btnReceive.setEnabled(false);
            }
        } else {
            this.btnReceive.setEnabled(false);
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

        btnRequest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblin = new javax.swing.JTable();
        btnReceive = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        btnRequest.setText("Request Inventory");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        tblin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Food name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblin);

        btnReceive.setText("Receive Confirmation");
        btnReceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiveActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "FoodName", "Quantity", "Enterprise", "Receiver", "Status", "Shipping message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        jLabel1.setText("input inventory");

        btnAdd.setText("Add Inventory");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(47, 47, 47))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(162, 162, 162)
                            .addComponent(btnRequest)
                            .addGap(33, 33, 33)
                            .addComponent(btnReceive))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(86, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(252, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRequest)
                        .addComponent(btnReceive))
                    .addGap(30, 30, 30)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiveActionPerformed
        // TODO add your handling code here:
        if (enterprise instanceof Agent) {
            int selectedRow = workRequestJTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "please select a row");
                return;
            }
            FoodRequest request = (FoodRequest) workRequestJTable.getValueAt(selectedRow, 0);
            request.setStatus("Completed");
            FoodInventory in = new FoodInventory();
            in.setFood(request.getFood());
            in.setQuantity(request.getQuantity());
            if (agent.searchInventory(in.getFood()) == null) {
                agent.addInventory(in);
            } else {
                int addNum = request.getQuantity();
                int oldNum = agent.searchInventory(in.getFood()).getQuantity();
                agent.searchInventory(in.getFood()).setQuantity(addNum + oldNum);
            }
            populateAgentInventoryTable();
            populateAgentRequestTable();
        }

        if (enterprise instanceof FoodBank) {
            int selectedRow = workRequestJTable.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null, "please select a row");
                return;
            }
            FoodRequest request = (FoodRequest) workRequestJTable.getValueAt(selectedRow, 0);
            request.setStatus("Completed");
            FoodInventory in = new FoodInventory();
            in.setFood(request.getFood());
            in.setQuantity(request.getQuantity());
            if (foodBank.searchInventory(in.getFood()) == null) {
                foodBank.addInventory(in);
            } else {
                int addNum = request.getQuantity();
                int oldNum = foodBank.searchInventory(in.getFood()).getQuantity();
                foodBank.searchInventory(in.getFood()).setQuantity(addNum + oldNum);
            }
            populateFoodBankInventoryTable();
            populateFoodBankRequestTable();
        }
    }//GEN-LAST:event_btnReceiveActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestOrderJPanel", new RequestInventoryJPanel(userProcessContainer, account, enterprise, government, business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("AddInventoryJPanel", new AddInventoryJPanel(userProcessContainer, enterprise, government, business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReceive;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblin;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
