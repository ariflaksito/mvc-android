package com.oracle.rentcar.logic;

import java.util.ArrayList;

import com.oracle.rentcar.model.Rent;

public interface RentInterface {
	
	void pinjam(Rent r);
	void kembali(int i);	
	Rent getRent(int id);
	ArrayList<Rent> getListRent();
	
}
