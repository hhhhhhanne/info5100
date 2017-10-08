package Utils;

import Business.Flight;



public class FlightCsvUtil {
	private CSVUtil csvUtil = new CSVUtil();
	
	
	public CSVUtil getCsvUtil() {
		return csvUtil;
	}


	public void setCsvUtil(CSVUtil csvUtil) {
		this.csvUtil = csvUtil;
	}


	public Flight getFlightByCsv(long row){
		
		Flight flight = new Flight();
		csvUtil.setCsvFilePath("csvflight.csv");
		String[] strings = csvUtil.getRowData(row);
		
		if (strings.length == 5) {
			//flightID,takeofftime,takeoffairport,arriveairport,serialNumber
			flight.setFlightID(strings[0]);
			flight.setTakeofftime(strings[1]);
			flight.setTakeoffairport(strings[2]);
			flight.setArriveairport(strings[3]);
			flight.setSerialNumber(strings[4]);

			 return flight;
			 
		}else
		{
			
			System.out.println("read err1");
		}
		return null;
		
	}

}
