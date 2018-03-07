/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Food.Food;
import Business.Food.FoodInventory;
import Business.Role.Role;
import Business.Role.ServiceRole;
import java.util.ArrayList;

/**
 *
 * @author Chance
 */
public class ServiceOrganization extends Organization{

    private ArrayList<FoodInventory> inventoryList;
    public ServiceOrganization(String name) {
        super(name);
        inventoryList = new ArrayList<FoodInventory>();
    }

    public ArrayList<FoodInventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList<FoodInventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
    public FoodInventory addInventory(FoodInventory foodInventory){
        inventoryList.add(foodInventory);
        return foodInventory;
    }
    public FoodInventory searchInventory(Food food){
        for(FoodInventory in : inventoryList){
            if (in.getFood().equals(food)) {
                return in;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ServiceRole());
        return roles;
    }
    
}
