package com.oracle.rentcar.model;

public abstract class Car {
	
	private int capacity;
	private String nopol;
	private boolean available;
	private double biaya;
	
	public Car(){}
	
	public Car(int capacity, String nopol, boolean available,double biaya) {
		super();
		this.capacity = capacity;
		this.nopol = nopol;
		this.available = available;
		this.biaya = biaya;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getNopol() {
		return nopol;
	}
	public void setNopol(String nopol) {
		this.nopol = nopol;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}	
	public boolean getAvailable(){
		return this.available;
	}	
	public double getBiaya() {
		return biaya;
	}
	public void setBiaya(double biaya) {
		this.biaya = biaya;
	}

	public abstract void desc();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNopol()+","+getCapacity()+","+getAvailable()+","+getBiaya();
	}
	
	
}
