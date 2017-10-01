/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airway;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class FlSchedule {
    private ArrayList<Flight> flschedule;

    public FlSchedule() {
        flschedule = new ArrayList<Flight>();
    }
    

    public ArrayList<Flight> getFlschedule() {
        return flschedule;
    }

    public void setFlschedule(ArrayList<Flight> flschedule) {
        this.flschedule = flschedule;
    }
    
    public void addFlight(Flight flight){
        this.flschedule.add(flight);
    }
}
