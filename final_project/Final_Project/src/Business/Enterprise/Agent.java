/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Organization.OrganizationDirectory;
import Business.Request.RequestList;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Chance
 */
public class Agent extends Enterprise {

    private ArrayList<FoodInventory> inventoryList;
    private FoodBank foodBank;

    public Agent(String name) {
        super(name, Enterprise.EnterpriseType.Agent);
        this.inventoryList = new ArrayList<FoodInventory>();
    }

    public FoodInventory addInventory(FoodInventory foodInventory) {
        inventoryList.add(foodInventory);
        return foodInventory;
    }

    public FoodInventory searchInventory(Food food) {
        for (FoodInventory in : inventoryList) {
            if (in.getFood().equals(food)) {
                return in;
            }
        }
        return null;
    }

    public ArrayList<FoodInventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<FoodInventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public FoodBank getFoodBank() {
        return foodBank;
    }

    public void setFoodBank(FoodBank foodBank) {
        this.foodBank = foodBank;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
