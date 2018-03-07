/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Plan;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chance
 */
public class PlanList {
    private ArrayList<Plan> planList;
    
    public PlanList() {
        this.planList = new ArrayList<>();
    }
    
    public void addPlan(String name, float benefit, float incomelimit) {
        if(name.equals("") || benefit == 0) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
        }
        Plan newplan = new Plan(name, benefit, incomelimit);
        this.planList.add(newplan);
    }

    public ArrayList<Plan> getPlanList() {
        return planList;
    }
}
