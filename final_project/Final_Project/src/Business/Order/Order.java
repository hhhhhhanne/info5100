/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Enterprise.Agent;
import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Person.BenefitPerson;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Chance
 */
public class Order {
    private Agent from;
    private BenefitPerson to;
    //Food Inventory include Food and quantity; Food have food name and price;
    private ArrayList<FoodInventory> offer;
    private Date date;

    public Order(Agent from, BenefitPerson to) {
        this.from = from;
        this.to = to;
        this.offer = new ArrayList<>();
    }
    
    public void addFoodInventory(FoodInventory foodinv) {
        this.offer.add(foodinv);
    }

    public Agent getFrom() {
        return from;
    }

    public void setFrom(Agent from) {
        this.from = from;
    }

    public BenefitPerson getTo() {
        return to;
    }

    public void setTo(BenefitPerson to) {
        this.to = to;
    }

    public ArrayList<FoodInventory> getOffer() {
        return offer;
    }

    public void setOffer(ArrayList<FoodInventory> Offer) {
        this.offer = Offer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    
}
