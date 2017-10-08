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
public class TravelAgency {
    private Airliner airliner;
    private ArrayList<Airliner> airway;
    private CustomerDirectory customerdir;
    private MsSchedule msschedule;

    public TravelAgency() {
        airliner = new Airliner();
        customerdir = new CustomerDirectory();
        msschedule = new MsSchedule();
        airway = new ArrayList<Airliner>();
    }

    public Airliner getAirliner() {
        return airliner;
    }

    public void setAirliner(Airliner airliner) {
        this.airliner = airliner;
    }

    public CustomerDirectory getCustomerdir() {
        return customerdir;
    }

    public void setCustomerdir(CustomerDirectory customerdir) {
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
