/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Account;

import Business.Person.BenefitPerson;
import Business.Person.P;
import Business.Person.Person;
import Business.Role.Role;
import Business.Role.SupplierRole;
import Business.Role.UserRole;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class AccountDirectory {
    private ArrayList<Account> accountCatalog;
    
    public AccountDirectory() {
        this.accountCatalog = new ArrayList<>();
    }
    
    public Account addAccount(Account acc) {
        this.accountCatalog.add(acc);
        return acc;
    }
    
    public Account addAccount(String username, String password, Role role, P person) {
        for(Account existacc: this.accountCatalog) {
            if(username.equals(existacc.getUsername())) {
                JOptionPane.showMessageDialog(null, "Username already exists in the system. Please change to another one.", "Error!", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        Account tempacc = new Account(username, password, role, person);
        this.accountCatalog.add(tempacc);
        return tempacc;
    }
    
    public Account loginValidation(String username, String password) {
        Account loginacc = null;
        for(Account existacc: this.accountCatalog) {
            if(username.equals(existacc.getUsername()) && password.equals(existacc.getPassword())) {
                loginacc = existacc;
            }
        }
        if(loginacc == null) {
            JOptionPane.showMessageDialog(null, "Login error! No such username and password account..", "Error!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return loginacc;
    }
    
    public Account authenticateUser(String username, String password){
        for (Account ua : this.accountCatalog)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }

    public ArrayList<Account> getAccountCatalog() {
        return accountCatalog;
    }

    public void setAccountCatalog(ArrayList<Account> accountCatalog) {
        this.accountCatalog = accountCatalog;
    }
    
    public Account registerAccount(String username, String password, BenefitPerson p) {
        for(Account tempacc : this.accountCatalog) {
            if(tempacc.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(null, "Username already exist. Please try another one");
                return null;
            }
        }
        Account regAccount = new Account(username, password, new UserRole(), p);
        regAccount.setStatus(Account.AccountStatus.Registered);
        this.accountCatalog.add(regAccount);
        return regAccount;
    }
    
    public Account registerSupplierAccount(String username, String password, Person p) {
        for(Account tempacc : this.accountCatalog) {
            if(tempacc.getUsername().equals(username)) {
                JOptionPane.showMessageDialog(null, "Username already exist. Please try another one");
                return null;
            }
        }
        Account regAccount = new Account(username, password, new SupplierRole(), p);
        regAccount.setStatus(Account.AccountStatus.Registered);
        this.accountCatalog.add(regAccount);
        return regAccount;
    }
    
    public void deleteAccount(Account acc) {
        this.accountCatalog.remove(acc);
    }
}
