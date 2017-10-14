/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.SystemAdministration.UserAccountDirectory;
import Business.HumanResources.PersonDirectory.PersonDirectory;

/**
 *
 * @author zhaoxiaohan
 */
public class Business {
    private String name;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountsDirectory;

    public Business(String n) {
        name = n;
        personDirectory = new PersonDirectory();
        userAccountsDirectory = new UserAccountDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public UserAccountDirectory getUserAccountsDirectory() {
        return userAccountsDirectory;
    }

    public void setUserAccountsDirectory(UserAccountDirectory userAccountsDirectory) {
        this.userAccountsDirectory = userAccountsDirectory;
    }
    
}
