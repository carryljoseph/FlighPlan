package com.flight.searchengine.service;

import org.springframework.stereotype.Service;

import com.flight.searchengine.entity.FlightDetails;

@Service
public interface SearchEngineService{

	public void insertDataToDB(FlightDetails e);

	public void insertDataFromCsv();
	
	public void fetchFlightDataFlightDetails(FlightDetails details);
	
}
