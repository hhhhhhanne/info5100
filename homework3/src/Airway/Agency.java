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
public class Agency {
    private Airliner airliner;
    private ArrayList<Airliner> airway;
    private Customerdir customerdir;
    private MsSchedule msschedule;

    public Agency(Airliner airliner, Customerdir customerdir, MsSchedule msschedule) {
        this.airliner = airliner;
        this.customerdir = customerdir;
        this.msschedule = msschedule;
        airway = new ArrayList<Airliner>();
    }

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    public Customerdir getCustomerdir() {
        return customerdir;
    }

    public void setCustomerdir(Customerdir customerdir) {
        this.customerdir = customerdir;
    }

    public MsSchedule getMsschedule() {
        return msschedule;
    }

    public void setMsschedule(MsSchedule msschedule) {
        this.msschedule = msschedule;
    }

    public ArrayList<Airliner> getAirway() {
        return airway;
    }

    public void setAirway(ArrayList<Airliner> airway) {
        this.airway = airway;
    }
    
}
