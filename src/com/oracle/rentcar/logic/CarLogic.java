package com.oracle.rentcar.logic;

import java.util.HashMap;
import java.util.Map;

import com.oracle.rentcar.model.Bus;
import com.oracle.rentcar.model.Car;
import com.oracle.rentcar.model.Shuttle;

public class CarLogic implements CarInterface {
	
	HashMap<String, Car> car;

	public CarLogic() {
		// TODO Auto-generated constructor stub
		car = new HashMap<>();
	}

	public void addCar(String key, Car c) {
		// TODO Auto-generated method stub
		car.put(key, c);
	}

	public void updateCar(String key, Car c) {
		// TODO Auto-generated method stub
		if(car.containsKey(key)){
			car.remove(key);
			car.put(key, c);
		}
	}

	public void removeCar(String key) {
		// TODO Auto-generated method stub
		car.remove(key);
	}

	public Car getCar(String key) {
		// TODO Auto-generated method stub
		Car cc = null;
		try {
			cc = car.get(key);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Error, Data Car tidak ditemukan");
		}

		return cc;
	}
	
	public HashMap<String, Car> getCar(){
		return car;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = "";		
		for(Map.Entry<String, Car> entry: car.entrySet()){
			Car a = entry.getValue();
			String info = "";
			if (a instanceof Bus)
				info = "Bus";
			else if (a instanceof Shuttle)
				info = "Shuttle";
			out += a.getNopol() + "," + a.getCapacity() + ","
					+ a.getAvailable() + "," + a.getBiaya() + "," + info + "\n";
		}
		
		return out;
	}	

}
