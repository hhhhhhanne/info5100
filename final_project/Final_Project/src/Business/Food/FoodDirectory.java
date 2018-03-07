/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Food;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class FoodDirectory {
    private ArrayList<FoodInventory> foodDirectory;

    public FoodDirectory() {
        foodDirectory = new ArrayList<FoodInventory>();
    }
    

    public ArrayList<FoodInventory> getFoodDirectory() {
        return foodDirectory;
    }

    public void setFoodDirectory(ArrayList<FoodInventory> foodDirectory) {
        this.foodDirectory = foodDirectory;
    }
    
    public FoodInventory addFoodInventory(FoodInventory fi){
        foodDirectory.add(fi);
        return fi;
    }
    public void removeFoodInventory(FoodInventory fi){
        foodDirectory.remove(fi);
    }
}
