/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Account.AccountDirectory;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Chance
 */
public abstract class Organization {
    private int id;
    private String name;
    private PersonDirectory personDirectory;
    private AccountDirectory accountDirectory;
    private static int count = 0;
    private OrganizationType orgType;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public AccountDirectory getAccountDirectory() {
        return accountDirectory;
    }

    public void setAccountDirectory(AccountDirectory accountDirectory) {
        this.accountDirectory = accountDirectory;
    }

    public OrganizationType getOrgType() {
        return orgType;
    }

    public void setOrgType(OrganizationType orgType) {
        this.orgType = orgType;
    }

    
    public enum OrganizationType{
        Inventory("Inventory"), Service("Service");
        private String value;
        private OrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        count++;
        this.name = name;
        this.id = count;
        this.personDirectory = new PersonDirectory();
        this.accountDirectory = new AccountDirectory();
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public abstract ArrayList<Role> getSupportedRole();
}
