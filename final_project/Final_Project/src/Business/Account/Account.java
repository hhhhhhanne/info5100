/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Account;

import Business.Person.P;
import Business.Person.Person;
import Business.Request.RequestList;
import Business.Role.Role;

/**
 *
 * @author Chance
 */
public class Account {
    private static int counter = 0;
    private int accId;
    private String username;
    private String password;
    private P person;
    private AccountStatus status;
    private Role accountRole;
    private RequestList requestList;
    
    public Account(String username, String password, Role role, P person) {
        counter++;
        this.accId = this.counter;
        this.username = username;
        this.password = password;
        this.accountRole = role;
        this.person = person;
        this.status = AccountStatus.Activate;
        requestList = new RequestList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(Role accountRole) {
        this.accountRole = accountRole;
    }

    public P getPerson() {
        return person;
    }

    public void setPerson(P person) {
        this.person = person;
    }
    
    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getAccId() {
        return accId;
    }
    
    public enum AccountStatus{
        Registered("Registered"), Processing("Processing"), 
        Approved("Approved"), Denied("Denied"),
        Cancelled("Cancelled"), Activate("Activate");
        
        private String value;
        private AccountStatus(String status) {
            this.value = status;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }

    public RequestList getRequestList() {
        return requestList;
    }

    public void setRequestList(RequestList requestList) {
        this.requestList = requestList;
    }
    
    @Override
    public String toString() {
        return this.username;
    }
    
}
