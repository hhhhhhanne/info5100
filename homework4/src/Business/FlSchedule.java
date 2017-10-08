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
    
    public Flight addFlight(){
        Flight flight = new Flight();
        this.flschedule.add(flight);
        return flight;
    }
    
    public void deleteFlight(String flightID){
        List<Flight> tmp = new ArrayList<Flight>();
        for(Flight flight:this.flschedule){
            if(flight.getFlightID().equals(flightID))
                tmp.add(flight);
        }
        this.flschedule.removeAll(tmp);
    }

   //此处以为前后设计不统一，需要设计一个由arraylist转化为FlSchedule的方法
//	public void addAllFlight(ArrayList<Flight> flschedule2) {
//		for(Flight fl : flschedule2){
//			this.flschedule.add(fl);
//		}	
//	}
}
