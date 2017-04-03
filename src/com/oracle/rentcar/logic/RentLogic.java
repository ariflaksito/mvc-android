package com.oracle.rentcar.logic;

import java.util.ArrayList;
import java.util.Date;

import com.oracle.rentcar.model.Car;
import com.oracle.rentcar.model.Rent;

public class RentLogic implements RentInterface {
	
	ArrayList<Rent> rent;

	public RentLogic() {
		// TODO Auto-generated constructor stub
		rent = new ArrayList<Rent>();
	}
	
	@Override
	public void pinjam(Rent r) {
		// TODO Auto-generated method stub
		Car c = r.getCar();
		c.setAvailable(false);
		r.setCar(c);
						
		rent.add(r);
	}

	@Override
	public void kembali(int i) {
		// TODO Auto-generated method stub
		Rent r = rent.get(i);
		Car c = r.getCar();
		c.setAvailable(true);
		r.setActual(new Date() );
		r.setCar(c);
		
		rent.set(i, r);
	}

	@Override
	public Rent getRent(int id) {
		// TODO Auto-generated method stub
		Rent r = null;
		try {
			r = rent.get(id);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("Error, Data Rent tidak ditemukan");
		}

		return r;
	}

	@Override
	public ArrayList<Rent> getListRent() {
		// TODO Auto-generated method stub
		return rent;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = "";
		for(int i=0; i<rent.size(); i++){
			Rent r = rent.get(i);
			out+= out+r+"\n";
		}
		
		return out;
	}

}
