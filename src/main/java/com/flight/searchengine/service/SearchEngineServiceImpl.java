package com.flight.searchengine.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.flight.searchengine.entity.FlightDetails;
import com.flight.searchengine.repository.SearchEngineRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SearchEngineServiceImpl implements SearchEngineService{

	@Autowired
	private SearchEngineRepository repo;
	
	@Override
	public void insertDataToDB(FlightDetails e) {
	
	}
	
	SimpleDateFormat ft = 
		      new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	
	String line="";
	
	@Override
	public void insertDataFromCsv(){
		FlightDetails e= new FlightDetails();
		try{
			BufferedReader br=new BufferedReader(new FileReader("src/main/resources/flightdetails6.csv"));
			while((line=br.readLine())!=null){
				System.out.println("Line"+line);
				String [] data=line.split(",");
				e.setFlightName(data[0]);
	e.setSource(data[1]);
	e.setDestination(data[2]);
	
	 
	   Timestamp timestampdep = Timestamp.valueOf(data[3]);
			
		  e.setDeparture(timestampdep);
		 
		 Timestamp timestamparr = Timestamp.valueOf(data[4]);

		e.setArrival(timestamparr);
		e.setOffercode(data[5]);
		e.setId(Integer.parseInt(data[6]));
				repo.save(e);
			}
		}catch(IOException exp){
			
			exp.printStackTrace();
		}
	}

	@Override
	public void fetchFlightDataFlightDetails(FlightDetails details) {
		LocalDateTime departure = details.getDeparture().toLocalDateTime();
		LocalDateTime arrival = details.getArrival().toLocalDateTime();
		repo.getAvailableFlights(departure, arrival);
	
		
	}

}
