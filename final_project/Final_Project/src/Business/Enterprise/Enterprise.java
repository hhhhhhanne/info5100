/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Account.AccountDirectory;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Person.PersonDirectory;

/**
 *
 * @author Chance
 */
public abstract class Enterprise extends Organization{
    private EnterpriseType type;
    private OrganizationDirectory odir;

    public EnterpriseType getType() {
        return type;
    }

    public void setType(EnterpriseType type) {
        this.type = type;
    }
    
    public enum EnterpriseType{
        Government("Government"),Supplier("Supplier"), Agent("Agent"), FoodBank("FoodBank");
        
        private String value;
        private EnterpriseType(String value) {
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
    
    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.type = type;
        //System.out.println(name);
        //System.out.println(type);
        this.odir = new OrganizationDirectory();
    }
    
    public OrganizationDirectory getOdir() {
        return odir;
    }

    public void setOdir(OrganizationDirectory odir) {
        this.odir = odir;
    }
}
