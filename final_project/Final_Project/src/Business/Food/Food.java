/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Food;

import Business.Enterprise.Supplier;


/**
 *
 * @author zhaoxiaohan
 */
public class Food {
    private String name;
    private float price;

    public Food(String name, float price) {
        this.name = name;
        this.price = price;
    }
    public Food(){
        
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }





    @Override
    public String toString(){
        return name;
    }
}
