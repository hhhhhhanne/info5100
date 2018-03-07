/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Account.Account;
import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Interface.InventoryRole.InventoryWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Chance
 */
public class InventoryRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, Account account, Organization organization, Enterprise enterprise, Business business) {
        return new InventoryWorkAreaJPanel(userProcessContainer, account, enterprise, business);
    }
    
}
