/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Food;

/**
 *
 * @author zhaoxiaohan
 */
public class FoodInventory {
    private Food food;
    private int quantity;

    public FoodInventory(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }
    
    public FoodInventory(){
        
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
    @Override
    public String toString(){
        return food.getName();
    }
}
