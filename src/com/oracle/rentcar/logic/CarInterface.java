package com.oracle.rentcar.logic;

import java.util.HashMap;

import com.oracle.rentcar.model.Car;

public interface CarInterface {
	
	void addCar(String key, Car c);
	void updateCar(String key, Car c);
	void removeCar(String key);
	Car getCar(String key);
	HashMap<String, Car> getCar();
	
}
