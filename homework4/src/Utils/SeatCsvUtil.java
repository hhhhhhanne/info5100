package Utils;

import Business.Seat;
import java.util.ArrayList;
import java.util.List;



public class SeatCsvUtil {
	private CSVUtil csvUtil = new CSVUtil();
	
	
	public CSVUtil getCsvUtil() {
		return csvUtil;
	}


	public void setCsvUtil(CSVUtil csvUtil) {
		this.csvUtil = csvUtil;
	}


	public Seat getSeatByCsv(long row){
		
		Seat seat = new Seat();
		csvUtil.setCsvFilePath("csvseat.csv");
		String[] strings = csvUtil.getRowData(row);
		
		if (strings.length == 5) {
			 seat.setRow(Integer.valueOf(strings[0]));
			 seat.setColumn(Integer.valueOf(strings[1]));
			 seat.setPrice(Float.valueOf(strings[2]));
			 seat.setCustomerID(strings[3]);
			 seat.setFlightID(strings[4]);
			 
			 return seat;
			 
		}else
		{
			
			System.out.println("read err2");
		}
		return null;
		
	}
	/*
	 * 读取一个航班的整个座位
	 */
	public List<Seat> getOneAirplaneSeats(int flightID){
		List<Seat> seats = new ArrayList<>();
		
		int startId = (flightID-1)*150+1;
		for(int i=0;i<150;i++){
			Seat seat = new Seat();
			seat=this.getSeatByCsv((long)(startId+i));
			seats.add(seat);
		}
		
		return seats;
	}

} 
