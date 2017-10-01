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
public class Flight {
    private String takeofftime;
    private Airplane airplane;
    private String takeoffairport;
    private String arriveairport;
    private String flightID;
    private ArrayList<Seat> seatls;

    public Flight() {
        airplane = new Airplane();
        seatls = new ArrayList();
    }

    public String getTakeofftime() {
        return takeofftime;
    }

    public void setTakeofftime(String takeofftime) {
        this.takeofftime = takeofftime;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getTakeoffairport() {
        return takeoffairport;
    }

    public void setTakeoffairport(String takeoffairport) {
        this.takeoffairport = takeoffairport;
    }

    public String getArriveairport() {
        return arriveairport;
    }

    public void setArriveairport(String arriveairport) {
        this.arriveairport = arriveairport;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public ArrayList<Seat> getSeatls() {
        return seatls;
    }

    public void setSeatls(ArrayList<Seat> seatls) {
        this.seatls = seatls;
    }
    
    public void addSeat(Seat seat){
        this.seatls.add(seat);
    }
    
}
