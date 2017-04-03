package com.oracle.rentcarmobile;

import java.util.ArrayList;

import com.oracle.rentcar.logic.RentLogic;
import com.oracle.rentcar.model.Rent;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressWarnings("deprecation")
public class ReportActivity extends ActionBarActivity {

	private ListView list;
	private RentLogic r;

	public ReportActivity() {
		// TODO Auto-generated constructor stub
		r = new SplashActivity().getRent();
	}

	@SuppressLint("SimpleDateFormat")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car);

		list = (ListView) findViewById(R.id.list_car);
		final ArrayList<Rent> rent = r.getListRent();

		String[] out = new String[rent.size()];
		
		for (int i = 0; i < rent.size(); i++) {
			Rent rr = rent.get(i);			

			String s = (rr.getActual()!=null)?"Kembali":"Belum Kembali";
			out[i] = rr.getName() + "\n" + rr.getCar().getNopol()
					+ "\nStatus: " + s;			

		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, out);
		list.setAdapter(adapter);

	}

}
