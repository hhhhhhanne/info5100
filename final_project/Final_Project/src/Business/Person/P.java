/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Region.Region;

/**
 *
 * @author zhaoxiaohan
 */
public abstract class P {
    private static int count = 0;
    private String name;
    private int id;
    //private String type;
    private Region.StateName state;
    public P(String name) {
        this.count++;
        this.name = name;
        this.id = count;
    }
    public P(String name,Region.StateName state) {
        this.count++;
        this.name = name;
        this.id = count;
        this.state=state;
    }
    
    public Region.StateName getState() {
        return state;
    }

    public void setState(Region.StateName state) {
        this.state = state;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String toString() {
        return this.name;
    }
}
