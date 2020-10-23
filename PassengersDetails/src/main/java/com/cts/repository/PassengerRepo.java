package com.cts.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Passengers;


@Repository
public interface PassengerRepo extends CrudRepository<Passengers, Integer>{

	@Query(nativeQuery =true, value ="select * from passenger order by price desc limit 5;")

	public List<Passengers>findTopPassengers();
	
	public Optional<Passengers> findByPassengersName(String name);

	public List<Passengers> findByPriceBetween(Double startPrice, Double endPrice);

	public List<Passengers> findByDateBetween(Date startDate, Date endDate);

}
