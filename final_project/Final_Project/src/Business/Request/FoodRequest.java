/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import Business.Account.Account;
import Business.Enterprise.Enterprise;
import Business.Food.Food;
import java.util.Date;

/**
 *
 * @author Chance
 */
public class FoodRequest extends Request{
    
    private Food food;
    private int quantity;
    private Account sender;
    private Account receiver;
    private String status;
    private String shipping;
    private Enterprise enterprise;
    private Date sendDate;
    
    public FoodRequest() {
        super(RequestType.FoodRequest);
        this.sendDate = new Date();
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Date getSendDate() {
        return sendDate;
    }

    
}
