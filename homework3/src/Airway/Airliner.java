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
public class Airliner {
    private ArrayList<Airplane> fleet;
    private ArrayList<Flight> flschedule;
    private String airliner;  //name of an airliner
   
    public Airliner()
    {
        this.fleet = new ArrayList<Airplane>();
        this.flschedule = new ArrayList<Flight>();
    }
    
    public Airliner(String airliner)
    {
        this.fleet = new ArrayList<Airplane>();
        this.flschedule = new ArrayList<Flight>();
        this.airliner = airliner;
    }

    public ArrayList<Airplane> getFleet() {
        return fleet;
    }

    public void setFleet(ArrayList<Airplane> fleet) {
        this.fleet = fleet;
    }

    public ArrayList<Flight> getFlschedule() {
        return flschedule;
    }

    public void setFlschedule(ArrayList<Flight> flschedule) {
        this.flschedule = flschedule;
    }
    
    public Airplane addAirplane(Airplane ap) {
        fleet.add(ap);
        return ap;
    }

    public String getAirliner() {
        return airliner;
    }

    public void setAirliner(String airliner) {
        this.airliner = airliner;
    }

    
}
