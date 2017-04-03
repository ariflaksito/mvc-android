package com.oracle.rentcarmobile;

import java.util.ArrayList;
import java.util.List;

import com.oracle.rentcar.logic.CarLogic;
import com.oracle.rentcar.model.Bus;
import com.oracle.rentcar.model.Car;
import com.oracle.rentcar.model.Shuttle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class AddCarActivity extends ActionBarActivity{
	
	private Spinner sType;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_car);
		
		
		
		addItemsOnSpinner();
		
		final EditText nopol = (EditText) findViewById(R.id.inputNopol);
		final EditText key = (EditText) findViewById(R.id.inputKey);
		Button btn = (Button) findViewById(R.id.btnAdd);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String tk = String.valueOf(sType.getSelectedItem());
				String no = nopol.getText().toString();
				String k = key.getText().toString();
				CarLogic car = new SplashActivity().getCar();
				
				if(tk.equalsIgnoreCase("Bus")) {
					final Car bus = new Bus(no);
					car.addCar(k, bus);
				}else if(tk.equalsIgnoreCase("Shuttle")){
					final Car shuttle = new Shuttle(no);
					car.addCar(k, shuttle);					
				}

				Toast.makeText(getApplicationContext(),
						"Penambahan Data Kendaraan Berhasil", Toast.LENGTH_LONG)
						.show();
				finish();
			}
		});
		
	}
	
	public void addItemsOnSpinner() {

		sType = (Spinner) findViewById(R.id.spintype);
		List<String> list = new ArrayList<String>();
		list.add("Bus");
		list.add("Shuttle");

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		sType.setAdapter(dataAdapter);

	}
	
}
