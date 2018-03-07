/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Account.Account;
import Business.Order.OrderDirectory;
import Business.Plan.Plan;
import Business.Region.Region.StateName;

/**
 *
 * @author Chance
 */
public class BenefitPerson extends P{
    private float income;
    private String ssn;
    private Account account;
    private Plan planAssign;
    private StateName state;
    private float balance;
    private OrderDirectory orderDirectory;
    
    public BenefitPerson(String name, String ssn, StateName state) {
        super(name);
        this.ssn = ssn;
        this.state = state;
        this.orderDirectory = new OrderDirectory();
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Plan getPlanAssign() {
        return planAssign;
    }

    public void setPlanAssign(Plan planAssign) {
        this.planAssign = planAssign;
    }

    public StateName getState() {
        return state;
    }

    public void setState(StateName state) {
        this.state = state;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

    
}
