/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import Business.Account.Account;
import Business.Person.Person;
import Business.Plan.Plan;

/**
 *
 * @author Chance
 */
public class UserRequest extends Request{
    private Account account;
    private float income;
    private Plan planexpect;
    private String status;
    
    public UserRequest(Account account, float income, Plan planexpect) {
        super(RequestType.UserRequest);
        this.account = account;
        this.income = income;
        this.planexpect = planexpect;
        this.status = "Processing";
    }

    public Account getAccount() {
        return account;
    }

    public float getIncome() {
        return income;
    }

    public Plan getPlanexpect() {
        return planexpect;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
