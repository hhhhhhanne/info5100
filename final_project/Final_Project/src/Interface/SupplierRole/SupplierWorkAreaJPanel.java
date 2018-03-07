/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SupplierRole;

import Interface.GovernmentRole.ManageFoodJPanel;
import Business.Account.Account;
import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author liaoqian
 */
public class SupplierWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SupplierWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Business business;
    private Account account;
    private Enterprise enterprise;
    private Network network;
    public SupplierWorkAreaJPanel(JPanel userProcessContainer, Account account, Organization organization,Enterprise enterprise, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.business = business;
        this.enterprise=enterprise;
        
        for(Network nwk: this.business.getNetworkList()) {
            if(nwk.getState() == account.getPerson().getState()) {
                this.network = nwk;
                break;
            }
        }
        suplabel.setText(enterprise.getName()+" Supplier Work Area");
        showStatus();
    }
    
    
    public void showStatus() {
        if(account != null) {
            labelStatus.setText(account.getStatus().getValue());
        }
        if(account.getStatus() == Account.AccountStatus.Registered) {
            btnapply.setEnabled(true);
            btnorg.setEnabled(false);
            btnemp.setEnabled(false);
            btnaccount.setEnabled(false);
            btnactive.setEnabled(false);
        }
        if(this.account.getStatus() == Account.AccountStatus.Processing) {
            this.btnapply.setEnabled(false);
            this.btnorg.setEnabled(false);
            this.btnemp.setEnabled(false);
            this.btnaccount.setEnabled(false);
            btnactive.setEnabled(false);
        }
        if(this.account.getStatus() == Account.AccountStatus.Approved) {
            this.btnapply.setEnabled(false);
            this.btnorg.setEnabled(false);
            this.btnemp.setEnabled(false);
            this.btnaccount.setEnabled(false);
            btnactive.setEnabled(true);
        }
        if(this.account.getStatus() == Account.AccountStatus.Denied) {
            this.btnapply.setEnabled(true);
            this.btnorg.setEnabled(false);
            this.btnemp.setEnabled(false);
            this.btnaccount.setEnabled(false);
            btnactive.setEnabled(false);
        }
        if(this.account.getStatus() == Account.AccountStatus.Activate) {
            this.btnapply.setEnabled(false);
            this.btnorg.setEnabled(true);
            this.btnemp.setEnabled(true);
            this.btnaccount.setEnabled(true);
            btnactive.setEnabled(true);
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

        suplabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnorg = new javax.swing.JButton();
        btnemp = new javax.swing.JButton();
        btnaccount = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnactive = new javax.swing.JButton();
        btnapply = new javax.swing.JButton();

        suplabel.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        suplabel.setText("Supplier Work Area");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setText("Account Status:");

        labelStatus.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplier Management"));

        btnorg.setText("Manage Organization");
        btnorg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnorgActionPerformed(evt);
            }
        });

        btnemp.setText("Manage Employee");
        btnemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnempActionPerformed(evt);
            }
        });

        btnaccount.setText("Manage Account");
        btnaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnorg, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnemp, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnorg, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnemp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnaccount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Apply&Active"));

        btnactive.setText("Active Supplier Account");
        btnactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactiveActionPerformed(evt);
            }
        });

        btnapply.setText("Apply to be a supplier");
        btnapply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnapplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnactive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnapply, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnapply, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnactive, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(suplabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suplabel)
                    .addComponent(jLabel2)
                    .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnapplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnapplyActionPerformed
        // TODO add your handling code here:
        JPanel appJPanel = new ApplyJPanel(userProcessContainer,account,enterprise,business,network);
        userProcessContainer.add("registerJPanel", appJPanel);
        CardLayout crdLyt = (CardLayout)userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
    }//GEN-LAST:event_btnapplyActionPerformed

    private void btnorgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnorgActionPerformed
        // TODO add your handling code here:
        JPanel orgJPanel = new ManageOrganizationJPanel(userProcessContainer,enterprise,business);
        userProcessContainer.add("orgJPanel", orgJPanel);
        CardLayout crdLyt = (CardLayout)userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
    }//GEN-LAST:event_btnorgActionPerformed

    private void btnempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnempActionPerformed
        // TODO add your handling code here:
        JPanel empJPanel = new ManageEmployeeJPanel(userProcessContainer,enterprise,business);
        userProcessContainer.add("empJPanel", empJPanel);
        CardLayout crdLyt = (CardLayout)userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
    }//GEN-LAST:event_btnempActionPerformed

    private void btnaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaccountActionPerformed
        // TODO add your handling code here:
        JPanel accJPanel = new ManageAccountJPanel(userProcessContainer,enterprise,business);
        userProcessContainer.add("accJPanel", accJPanel);
        CardLayout crdLyt = (CardLayout)userProcessContainer.getLayout();
        crdLyt.next(userProcessContainer);
    }//GEN-LAST:event_btnaccountActionPerformed

    private void btnactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactiveActionPerformed
        // TODO add your handling code here:
        account.setStatus(Account.AccountStatus.Activate);
        showStatus();
    }//GEN-LAST:event_btnactiveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaccount;
    private javax.swing.JButton btnactive;
    private javax.swing.JButton btnapply;
    private javax.swing.JButton btnemp;
    private javax.swing.JButton btnorg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel suplabel;
    // End of variables declaration//GEN-END:variables
}