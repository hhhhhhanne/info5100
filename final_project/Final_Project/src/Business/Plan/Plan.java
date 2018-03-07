/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Plan;

/**
 *
 * @author Chance
 */
public class Plan {
    private String name;
    private float incomelimit;
    private float benefit;
    
    public Plan(String name, float benefit, float incomelimit) {
        this.name = name;
        this.benefit = benefit;
        this.incomelimit = incomelimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBenefit() {
        return benefit;
    }

    public void setBenefit(float benefit) {
        this.benefit = benefit;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    public float getIncomelimit() {
        return incomelimit;
    }

    public void setIncomelimit(float incomelimit) {
        this.incomelimit = incomelimit;
    }
    
}
