/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class OrganizationDirectory {
    private ArrayList<Organization> orgDirectory;
    
    public OrganizationDirectory() {
        this.orgDirectory = new ArrayList<>();
    }

    public ArrayList<Organization> getOrgDir() {
        return orgDirectory;
    }

    public void setOrgDir(ArrayList<Organization> orgDir) {
        this.orgDirectory = orgDir;
    }
    
    public Organization addOrganiztion(String name, OrganizationType type) {
        for(Organization org: this.orgDirectory) {
            if(org.getName().equals(name)) {
                JOptionPane.showMessageDialog(null, "Organization name already exist.");
                return null;
            }
        }
        Organization neworg = null;
        if(type == OrganizationType.Inventory) {
            neworg = new InventoryOrganization(name);
            neworg.setOrgType(OrganizationType.Inventory);
        }
        if(type == OrganizationType.Service) {
            neworg = new ServiceOrganization(name);
            neworg.setOrgType(OrganizationType.Service);
        }
        this.orgDirectory.add(neworg);
        return neworg;
    }
    
    public void deleteOrganization(Organization org) {
        this.orgDirectory.remove(org);
    }
}
