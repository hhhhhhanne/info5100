/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Network.Network;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseDirectory;
    
    public EnterpriseDirectory() {
        enterpriseDirectory = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(ArrayList<Enterprise> enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    public Enterprise addEnterprise(String name, EnterpriseType type ) {
        for(Enterprise ent: this.enterpriseDirectory) {
            if(ent.getName().equals(name)) {
                JOptionPane.showMessageDialog(null, "Enterprise name already exist.");
                return null;
            }
        }
        Enterprise newEnterprise = null;
        if (type == EnterpriseType.FoodBank){
            newEnterprise = new FoodBank(name);
        }
        if(type == EnterpriseType.Agent) {
            newEnterprise = new Agent(name);
        }
        if(type == EnterpriseType.Supplier) {
            newEnterprise = new Supplier(name);
        }
        //System.out.println(newEnterprise);
        this.enterpriseDirectory.add(newEnterprise);
        return newEnterprise;
    }
    
    public void deleteEnterprise(Enterprise ent) {
        this.enterpriseDirectory.remove(ent);
    }
    
}
