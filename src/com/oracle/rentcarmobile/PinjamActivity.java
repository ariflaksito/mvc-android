package com.oracle.rentcarmobile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.oracle.rentcar.logic.CarLogic;
import com.oracle.rentcar.logic.RentLogic;
import com.oracle.rentcar.model.Bus;
import com.oracle.rentcar.model.Car;
import com.oracle.rentcar.model.Rent;
import com.oracle.rentcar.model.Shuttle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class PinjamActivity extends ActionBarActivity {

	private CarLogic c;
	private RentLogic r;
	private Spinner sCar;

	public PinjamActivity() {
		// TODO Auto-generated constructor stub
		c = new SplashActivity().getCar();
		r = new SplashActivity().getRent();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pinjam);

		addItemsOnSpinner();

		final EditText name = (EditText) findViewById(R.id.inputName);
		final DatePicker start = (DatePicker) findViewById(R.id.inputStat);
		final DatePicker end = (DatePicker) findViewById(R.id.inputEnd);
		final Button btn = (Button) findViewById(R.id.btnPinjam);

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Date s = new Date(start.getYear() - 1900, start.getMonth(),
						start.getDayOfMonth());
				Date e = new Date(end.getYear() - 1900, end.getMonth(), end
						.getDayOfMonth());

				String tk = String.valueOf(sCar.getSelectedItem());

				Rent rn = new Rent();
				rn = new Rent(name.getText().toString(), s, e, null, c
						.getCar(tk.substring(0, 2)));
				r.pinjam(rn);

				Toast.makeText(getApplicationContext(),
						"Data Peminjaman Berhasil Disimpan", Toast.LENGTH_LONG)
						.show();
				finish();
			}
		});

	}

	public void addItemsOnSpinner() {

		sCar = (Spinner) findViewById(R.id.spincar);
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, Car> entry : c.getCar().entrySet()) {
			Car a = entry.getValue();

			String info = "";
			if (a instanceof Bus)
				info = "Bus";
			else if (a instanceof Shuttle)
				info = "Shuttle";

			if (a.getAvailable())
				list.add(entry.getKey() + ": " + a.getNopol() + " - " + info +" ("+a.getCapacity()+")");

		}

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		sCar.setAdapter(dataAdapter);

	}

}
