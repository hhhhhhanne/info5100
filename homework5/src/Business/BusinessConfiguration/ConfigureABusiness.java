/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BusinessConfiguration;

import Business.Business;
import Business.HumanResources.PersonDirectory.Person;
import Business.HumanResources.PersonDirectory.PersonDirectory;
import Business.SystemAdministration.UserAccount;
import Business.SystemAdministration.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class ConfigureABusiness {
    public static Business Initialize (String n) {
    Business b = new Business(n);
    PersonDirectory pd = b.getPersonDirectory();
    ArrayList<UserAccount> accounts1 = new ArrayList<UserAccount>();
    ArrayList<UserAccount> accounts2 = new ArrayList<UserAccount>();
    ArrayList<UserAccount> accounts3 = new ArrayList<UserAccount>();
    Person p1 = pd.newPerson(); //create person object 
    p1.setFirstName("Ann");
    p1.setLastName("Wells");
    p1.setAccounts(accounts1);

    Person p2 = pd.newPerson(); // create a second person object 
    p2.setFirstName("john");
    p2.setLastName("Adam");
    

    Person p3 = pd.newPerson(); 
    p3.setFirstName("Sam");
    p3.setLastName("Brown");
    
    UserAccountDirectory uad= b.getUserAccountsDirectory(); // prepare to create user accounts
    Person p = pd.findPersonByLastName("Wells"); 
    if (p!=null){
    UserAccount ua1 = uad.newUserAccount();
    ua1.setPerson(p); //link user account to the Mr. Wells 
    ua1.setUserName("aw");
    ua1.setPwd("pw");
    ua1.setRole("SystemAdmin");
    ua1.setStatus(true);
    accounts1.add(ua1);
    p1.setAccounts(accounts1);
    }
    
    UserAccount ua2 = uad.newUserAccount();
    ua2.setPerson(p2); 
    ua2.setUserName("jadam");
    ua2.setPwd("pw");
    ua2.setRole("SystemAdmin");
    ua2.setStatus(true);
    accounts2.add(ua2);
    p2.setAccounts(accounts2);
    
    UserAccount ua3 = uad.newUserAccount();
    ua3.setPerson(p3); 
    ua3.setUserName("sbrown");
    ua3.setPwd("pw");
    ua3.setRole("hr");
    ua3.setStatus(true);
    accounts3.add(ua3);
    p3.setAccounts(accounts3);
    
    b.setUserAccountsDirectory(uad);
    return b;
    }
}
