package com.cts.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.model.Passengers;
import com.cts.service.PassengersService;

@Controller
public class PassengersController {

	@Autowired
	PassengersService passengersService;
	
	@GetMapping("/allPassenger")
	public ResponseEntity<?>stickList()
	{
		return new ResponseEntity<List<Passengers>>(passengersService.allPassenger(),HttpStatus.OK);
	}
	
	@GetMapping("/topFivePassenger")
	public ResponseEntity<?>topFivePassenger()
	{
		return new ResponseEntity<List<Passengers>>(passengersService.topFivePassenger(),HttpStatus.OK);
	}
	

	@GetMapping("/searchPassengersById/{id}")
	public ResponseEntity<?>searchPassengersById(@PathVariable("id")int id)
	{
		Passengers p = passengersService.searchPassengersById(id);
		if(p==null) {
			return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);	
		}
	return new ResponseEntity<Passengers>(p,HttpStatus.OK);
	}

	@GetMapping("/searchPassengersByName/{name}")
	public ResponseEntity<?>searchPassengersByName(@PathVariable("name")String name)
	{
		Passengers p = passengersService.searchPassengersByName(name);
		if(p==null) {
			return new ResponseEntity<String>("not found",HttpStatus.NOT_FOUND);	
		}
	return new ResponseEntity<Passengers>(p,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchPassengersByPrice/{startPrice}/{endPrice}")
	public ResponseEntity<?> searchPassengersByPrice(@PathVariable("startPrice") Double startPrice, @PathVariable("endPrice") Double endPrice )
	{
		List<Passengers> p = passengersService.searchPassengersByPrice(startPrice,endPrice);
		if(p.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Passengers>>(p,HttpStatus.OK);
	}
	
	@GetMapping(value="/searchPassengerByDate/{startDate}/{endDate}")
	public ResponseEntity<?> searchPassengerByDate(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate )
	{
		List<Passengers> p= passengersService.searchPassengerByDate(startDate,endDate);
		if(p.size()==0){
			return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Passengers>>(p,HttpStatus.OK);
	}
	
	
	
}
