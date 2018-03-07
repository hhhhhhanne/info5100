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
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class OrderDirectory {
    private ArrayList<Order> OrderDirectory;

    public OrderDirectory() {
        this.OrderDirectory = new ArrayList<>();
    }
    
    public Order addOrder(Agent from, BenefitPerson to) {
        Order order = new Order(from, to);
        
        if(order == null) {
            JOptionPane.showMessageDialog(null, "Error when creat order");
            return null;
        }
        this.OrderDirectory.add(order);
        
        return order;
    }

    public ArrayList<Order> getOrderDirectory() {
        return OrderDirectory;
    }

    public void setOrderDirectory(ArrayList<Order> OrderDirectory) {
        this.OrderDirectory = OrderDirectory;
    }
    
    
}
