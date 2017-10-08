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
public class Flight {
    private String takeofftime;
    private String takeoffdate;
    private Airplane airplane;
    private String takeoffairport;
    private String arriveairport;
    private String flightID;
    private String serialNumber;
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
        //≥ı ºªØseat
        for(int i=1;i<=6;i++){
        	for(int j=1 ;j<=25;j++){
        		Seat seat = new Seat();
        		seat.setColumn(j);
        		seat.setFlightID(flightID);
        		seat.setPrice(Float.parseFloat("100.0"));
        		seat.setRow(i);
        		addSeat(seat);
        	}
        }
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTakeoffdate() {
        return takeoffdate;
    }

    public void setTakeoffdate(String takeoffdate) {
        this.takeoffdate = takeoffdate;
    }
    
    @Override
    public String toString(){
        return this.flightID;
    }
    
}
