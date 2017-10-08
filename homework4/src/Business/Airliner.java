/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author zhaoxiaohan
 */
public class Airliner {
    private ArrayList<Airplane> fleet;
    private ArrayList<Flight> flschedule;
    private String airlinerName;
    private String airlinerAddress;
   
    public Airliner()
    {
        this.fleet = new ArrayList<Airplane>();
        this.flschedule = new ArrayList<Flight>();
    }
    
    public Airliner(String airlinerName)
    {
        this.fleet = new ArrayList<Airplane>();
        this.flschedule = new ArrayList<Flight>();
        this.airlinerName = airlinerName;
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

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public String getAirlinerAddress() {
        return airlinerAddress;
    }

    public void setAirlinerAddress(String airlinerAddress) {
        this.airlinerAddress = airlinerAddress;
    }



    @Override
    public String toString(){
        return airlinerName;
    }
}
