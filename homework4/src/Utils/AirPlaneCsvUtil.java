package Utils;

import Business.Airplane;



public class AirPlaneCsvUtil {
	private static CSVUtil csvUtil = new CSVUtil();
	
	static {
            csvUtil.setCsvFilePath("csvairplane.csv");
        }
		
	public Airplane getAirplaneByCsv(long row){
		Airplane airplane = new Airplane();
		
		String[] strings = csvUtil.getRowData(row);
		
		if (strings.length == 6) {
			//serialNumber,modelNumber,manufacturer,manufacturedYear,seatnum,airliner
			airplane.setSerialNumber(strings[0]);
			airplane.setModelNumber(Integer.valueOf(strings[1]));
			airplane.setManufacturer(strings[2]);
			airplane.setManufacturedYear(Integer.valueOf(strings[3]));
			airplane.setSeatnum(Integer.valueOf(strings[4]));
			airplane.setAirlinerName(strings[5]);
			 
			 return airplane;
			 
		}else
		{
			
			System.out.println("read err3");
		}
		return null;
		
	}


	public Airplane getAirplaneBySerialNumber(String serialNumber){
		
		Airplane airplane = new Airplane();
		long num = csvUtil.getAllNum();
		for(int i=1;i<num;i++){
			airplane = getAirplaneByCsv(i);
			if (airplane.getSerialNumber().equals(serialNumber)) {
				return airplane;
			}
		}
		return null;
	}
}
