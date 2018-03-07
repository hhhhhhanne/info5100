/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.GovernmentRole;

import Business.Account.Account;
import Business.Business;
import Business.Enterprise.Government;
import Business.Network.Network;
import Business.Person.BenefitPerson;
import Business.Plan.Plan;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zhaoxiaohan
 */
public class ManagePlanJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePlanJPanel
     */
    private Business business;
    private JPanel userProcessContainer;
    private Government government;
    private Account account;

    public ManagePlanJPanel(Business business, JPanel userProcessContainer, Account account) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        for (Network nwk : this.business.getNetworkList()) {
            if (nwk.getStateAccount() == this.account) {
                this.government = nwk.getGovernment();
                break;
            }
        }
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tbPlan.getModel();

        model.setRowCount(0);
        for (Plan plan : government.getPlanlist().getPlanList()) {
            Object[] row = new Object[3];
            row[0] = plan;
            row[1] = plan.getIncomelimit();
            row[2] = plan.getBenefit();
            model.addRow(row);
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
        tbPlan = new javax.swing.JTable();
        btnCreate = new javax.swing.JButton();
        btnPeople = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Manage Plan");

        tbPlan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Income limit", "Benefit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbPlan);

        btnCreate.setText("Create Plan");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnPeople.setText("Manege people in plan");
        btnPeople.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeopleActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jButton1.setText("Send Benefit Monthly for Every Benefit Person");
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
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(80, 80, 80))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(55, 55, 55)
                .addComponent(btnCreate)
                .addGap(44, 44, 44)
                .addComponent(btnPeople)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnPeople)
                    .addComponent(btnBack))
                .addContainerGap(86, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        CreatePlanJPanel createPlanJPanel = new CreatePlanJPanel(this.business,userProcessContainer, account);
        userProcessContainer.add("createPlanJPanel", createPlanJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnPeopleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeopleActionPerformed
        // TODO add your handling code here:
        int selectedRow = tbPlan.getSelectedRow();
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select one row from table");
            return;
        }
        Plan p= (Plan)tbPlan.getValueAt(selectedRow, 0);
        ManageBenefitPeopleJPanel manageBenefitPeopleJPanel = new ManageBenefitPeopleJPanel(this.business,userProcessContainer, account, p);
        userProcessContainer.add("manageBenefitPeopleJPanel", manageBenefitPeopleJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPeopleActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        for (Account ac : government.getAccountDirectory().getAccountCatalog()) {
            if (ac.getPerson() instanceof BenefitPerson) {
                if (ac.getStatus() == Account.AccountStatus.Approved || ac.getStatus() == Account.AccountStatus.Activate) {
                    BenefitPerson bp = (BenefitPerson) ac.getPerson();
                    bp.setBalance(bp.getPlanAssign().getBenefit());
                }
            }
        }
        JOptionPane.showMessageDialog(null, "reset successfully");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnPeople;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPlan;
    // End of variables declaration//GEN-END:variables
}