package com.cts.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passengers {

	private int passengerId;
	private String passengerName;
	private Date date;
	private double price;
	
	
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Passengers(int passengerId, String passengerName, Date date, double price) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.date = date;
		this.price = price;
	}
	public Passengers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
