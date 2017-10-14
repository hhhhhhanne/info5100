/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HumanResources.PersonDirectory;

import Business.SystemAdministration.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class Person {
    private String firstName;
    private String lastName;
    private ArrayList<UserAccount> accounts;

    public Person() {
        ArrayList<UserAccount> accounts = new ArrayList<UserAccount>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<UserAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<UserAccount> accounts) {
        this.accounts = accounts;
    }
    
    public UserAccount addAccount(UserAccount account){
        for(UserAccount ac: accounts)
        {
            if(!ac.getUserName().equals(account.getUserName()))
                accounts.add(account);
                return account;
        }
        return null;
    }


    @Override
    public String toString(){
    return getFirstName() + ""+getLastName();
    }
}
