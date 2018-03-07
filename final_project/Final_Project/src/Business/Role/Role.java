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
import javax.swing.JPanel;

/**
 *
 * @author Chance
 */
public abstract class Role {
    
    public enum RoleType{
        SystemAdmin("SystemAdmin"),
        StateProviderAdminRole("StateProviderAdminRole"),
        ProviderAdmin("ProviderAdmin"),
        
        ServiceRole("ServiceRole"),
        InventoryRole("Inventory");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            Account account, 
            Organization organization, 
            Enterprise enterprise, 
            Business business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
