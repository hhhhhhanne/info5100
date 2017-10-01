/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Airway;

import com.csvreader.CsvReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 *
 * @author zhaoxiaohan
 */
public class homework3 {
	public static void main(String[] args) {
		List<Float> perflightRevenues = new ArrayList<Float>();
		ArrayList<String[]> csvFileList = new ArrayList<String[]>();
		Flight flight = new Flight();
		int j =0;
		String seatcsvPath = "csvseat.csv";
		try {
			CsvReader reader = new CsvReader(seatcsvPath, ',', Charset.forName("UTF-8"));
			reader.readHeaders();// ignore table header;
			while (reader.readRecord()) {
				csvFileList.add(reader.getValues());
			}
			reader.close();
			
			for (int row = 0; row < csvFileList.size(); row++) {
				//j++;
				Seat seat = new Seat();
				seat.setRow(Integer.parseInt(csvFileList.get(row)[0]));
				seat.setColumn(Integer.parseInt(csvFileList.get(row)[1]));
				seat.setPrice(Float.parseFloat(csvFileList.get(row)[2]));
				seat.setPersonID(csvFileList.get(row)[3]);
				seat.setFlightID(csvFileList.get(row)[4]);
				flight.addSeat(seat);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			Logger.getLogger(homework3.class.getName()).log(Level.SEVERE, null, ex);
		}

		csvFileList.clear();
		String airplanecsvPath = "csvairplane.csv";
		Map<String,Airliner> Airliners = new HashMap<String,Airliner>();//airliners
		try {
			CsvReader reader = new CsvReader(airplanecsvPath, ',', Charset.forName("UTF-8"));
			reader.readHeaders();// ignore table header;
			while (reader.readRecord()) {
				csvFileList.add(reader.getValues());
			}
			reader.close();
			for (int row = 0; row < csvFileList.size(); row++) {
				Airplane air = new Airplane();
				air.setSerialNumber(csvFileList.get(row)[0]);
				air.setModelNumber(Integer.parseInt(csvFileList.get(row)[1]));
				air.setManufacturer(csvFileList.get(row)[2]);
				air.setManufacturedYear(Integer.parseInt(csvFileList.get(row)[3]));
				air.setSeatnum(Integer.parseInt(csvFileList.get(row)[4]));
				air.setAirliner(csvFileList.get(row)[5]);
				/* 若航空公司集合中有该飞机的所属航空公司，则把该飞机set到该航空公司对象中；
				否则新建该航空公司后把该飞机set到该航空公司对象中，并添加航空公司到航空公司集合中*/
				if(Airliners.get(air.getAirliner())!=null && !"".equals(Airliners.get(air.getAirliner()))){
					Airliners.get(air.getAirliner()).addAirplane(air);
				}else{
					Airliner airliner = new Airliner(air.getAirliner());
					airliner.addAirplane(air);
					Airliners.put(air.getAirliner(),airliner );
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			Logger.getLogger(homework3.class.getName()).log(Level.SEVERE, null, ex);
		}

		csvFileList.clear();
		String flightcsvPath = "csvflight.csv";

		Map<String,Float> perAirlinerRevenues = new HashMap<String,Float>();//航空公司 - 航空公司收入
		float perAirlinerRevenue = 0;
		 
		try {
			CsvReader reader = new CsvReader(flightcsvPath, ',', Charset.forName("UTF-8"));
			reader.readHeaders();// ignore table header;
			while (reader.readRecord()) {
				csvFileList.add(reader.getValues());
			}
			reader.close();
			for (int row = 0; row < csvFileList.size(); row++) {
				//初始化
				float perflightRevenue = 0;
				
				Flight fl = new Flight();

				fl.setFlightID(csvFileList.get(row)[0]);
				fl.setTakeofftime(csvFileList.get(row)[1]);
				fl.setTakeoffairport(csvFileList.get(row)[2]);
				fl.setArriveairport(csvFileList.get(row)[3]);
				
				//遍历所有航空公司中的fleet集合中的airplane
				for (String airliner:Airliners.keySet()) {
					for(Airplane air:Airliners.get(airliner).getFleet()){
						if ((csvFileList.get(row)[4]).equals(air.getSerialNumber())) {
							fl.setAirplane(air);
							//tmp.put(fleet.get(i).getAirliner(),Integer.decode(csvFileList.get(row)[4]));
						}
					}
					
					if(perAirlinerRevenues.get(airliner)==null || "".equals(perAirlinerRevenues.get(airliner)))  
						perAirlinerRevenues.put(airliner,Float.valueOf(0));//初始化（航空公司 - 航空公司收入）键值对
				}

				for (int i = 0; i < flight.getSeatls().size(); i++) {
					Seat s = flight.getSeatls().get(i);
					if (s.getFlightID().equals(fl.getFlightID())) {
						fl.addSeat(s);
						if (!"".equals(s.getPersonID()) && s.getPersonID() != null) {
							//计算航班收入
							perflightRevenue += s.getPrice();
							//计算航空公司收入
							String airliner1 = fl.getAirplane().getAirliner();
							perAirlinerRevenues.put(airliner1,perAirlinerRevenues.get(airliner1)+s.getPrice());
							j++;
						}
					}
				}
				perflightRevenues.add(perflightRevenue);
				System.out.println("No." + fl.getFlightID() + " flight's revenue: " + perflightRevenue+"$");
			}
			float totalRevenues = 0;
			for(String key : perAirlinerRevenues.keySet()){
				System.out.println("Airliner "+key+"'s revenue: "+perAirlinerRevenues.get(key)+"$");
				totalRevenues += perAirlinerRevenues.get(key);
			}
			System.out.println("Airliners's total revenue: "+totalRevenues+"$");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			Logger.getLogger(homework3.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}












