/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaoxiaohan
 */
public class MsSchedule {
    private ArrayList<Flight> msschedule;

    public MsSchedule() {
        msschedule = new ArrayList<Flight>();
    }
    public ArrayList<Flight> getMsschedule() {
        return msschedule;
    }

    public void setMsschedule(ArrayList<Flight> msschedule) {
        this.msschedule = msschedule;
    }
    
    public ArrayList<Flight> addMsSchedule(ArrayList<Flight> flschedule){
        this.msschedule.addAll(flschedule);
        return this.msschedule;
    }
    
    //新增客户搜索用方法  将客户搜到的结果存入
    public Flight addFlights(Flight flight){
        this.msschedule.add(flight);
        return flight;
    }
    
    public void deleteFlight(String flightID){
        List<Flight> tmp = new ArrayList<Flight>();
        for(Flight flight:this.msschedule){
            if(flight.getFlightID().equals(flightID))
                tmp.add(flight);
        }
        this.msschedule.removeAll(tmp);
    }
}
