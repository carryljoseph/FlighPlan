package com.flight.searchengine.repository;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.searchengine.entity.FlightDetails;

@Repository
public interface SearchEngineRepository extends CrudRepository<FlightDetails, Integer> {

	FlightDetails save(FlightDetails e);
	
	
}
