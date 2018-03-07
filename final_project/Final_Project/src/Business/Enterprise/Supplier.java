/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Chance
 */
public class Supplier extends Enterprise{
    private ArrayList<FoodInventory> inventoryList;
    public Supplier(String name) {
        super(name, Enterprise.EnterpriseType.Supplier);
        this.inventoryList = new ArrayList<FoodInventory>();
    }

    public ArrayList<FoodInventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<FoodInventory> inventoryList) {
        this.inventoryList = inventoryList;
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
    
    public FoodInventory searchInventoryByName(Food food) {
        for (FoodInventory in : inventoryList) {
            if (in.getFood().getName().equals(food.getName())) {
                return in;
            }
        }
        return null;
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
