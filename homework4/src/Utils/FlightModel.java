package Utils;

import Business.Flight;
import Business.Seat;
import java.util.ArrayList;



public class FlightModel {
	FlightCsvUtil flightCsvUtil = new FlightCsvUtil();
	SeatCsvUtil seatCsvUtil = new SeatCsvUtil();
	AirPlaneCsvUtil airPlaneCsvUtil = new AirPlaneCsvUtil();
	
	public Flight getOneFlight(int row){
		Flight flight = new Flight();
		
		flight = flightCsvUtil.getFlightByCsv(row);
		flight.setSeatls((ArrayList<Seat>) seatCsvUtil.getOneAirplaneSeats(Integer.valueOf(flight.getFlightID())));
		
		
		//seatCsvUtil.getOneAirplaneSeats(Integer.valueOf(flight.getFlightID()));
		
		
		flight.setAirplane(airPlaneCsvUtil.getAirplaneBySerialNumber(flight.getSerialNumber()));

		return flight;
	}
	

}
