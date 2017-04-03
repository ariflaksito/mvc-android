package com.oracle.rentcar.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Rent {
	
	private String name;
	private Date start;
	private Date end;
	private Date actual;
	private Car car;
	private Double cost;
	
	public Rent(){}
	
	public Rent(String name, Date start, Date end, Date actual, Car car) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.actual = actual;
		this.car = car;		
		this.cost = getCost(car);
	}
	
	public Double getCost(Car car) {

		if (getActual() == null) {
			long diffEnd = (getEnd().getTime() - getStart().getTime());
			long lama = TimeUnit.MILLISECONDS.toDays(diffEnd);
			cost = (lama+1) * car.getBiaya();
		} else {
			long diffEnd = (getActual().getTime() - getStart().getTime());
			long lama = TimeUnit.MILLISECONDS.toDays(diffEnd);
			cost = (lama+1) * car.getBiaya();
		}
		return cost;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getActual() {
		return actual;
	}

	public void setActual(Date actual) {
		this.actual = actual;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
				
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String s = (getStart()!= null)?formatter.format(getStart()):"";
		String e = (getEnd()!= null)?formatter.format(getEnd()):"";
		String a = (getActual()!= null)?formatter.format(getActual()):"";
		
		return getName()+","+s+","+e+","+a+","+getCar();
	}
}
