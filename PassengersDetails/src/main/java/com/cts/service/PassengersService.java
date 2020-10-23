package com.cts.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Passengers;
import com.cts.repository.PassengerRepo;

@Service
public class PassengersService {

	@Autowired
	PassengerRepo passengerRepo;
	
	public List<Passengers>allPassenger(){
		return (List<Passengers>)passengerRepo.findAll();
		}
	
	public List<Passengers>topFivePassenger(){
		return(List<Passengers>)passengerRepo.findTopPassengers();
	}
	
	public Passengers searchPassengersById(int id) {
		Optional<Passengers> p = passengerRepo.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
	
	public Passengers searchPassengersByName(String name) {
		Optional<Passengers> p = passengerRepo.findByPassengersName(name);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
	
	public List<Passengers> searchPassengersByPrice(Double startPrice, Double endPrice){
		return(List<Passengers>)passengerRepo.findByPriceBetween(startPrice, endPrice);
		}
	
	public List<Passengers> searchPassengerByDate(Date startDate, Date endDate){
		return(List<Passengers>)passengerRepo.findByDateBetween(startDate, endDate);
	}
	
	
}
