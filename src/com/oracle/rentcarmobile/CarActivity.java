package com.oracle.rentcarmobile;

import java.util.Map;

import com.oracle.rentcar.logic.CarLogic;
import com.oracle.rentcar.model.Bus;
import com.oracle.rentcar.model.Car;
import com.oracle.rentcar.model.Shuttle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressWarnings("deprecation")
public class CarActivity extends ActionBarActivity {

	private ListView list;
	private CarLogic c;

	public CarActivity() {
		// TODO Auto-generated constructor stub
		c = new SplashActivity().getCar();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car);

		list = (ListView) findViewById(R.id.list_car);
		String[] out = new String[c.getCar().size()];

		int i = 0;
		for (Map.Entry<String, Car> entry : c.getCar().entrySet()) {
			Car a = entry.getValue();
			String info = "";
			if (a instanceof Bus)
				info = "Bus";
			else if (a instanceof Shuttle)
				info = "Shuttle";
			String s = (a.getAvailable())?"Tersedia":"Tidak Tersedia";
			out[i] = a.getNopol() + "\nStatus: "
					+ s + "\nJenis: " + info +" ("+a.getCapacity()+")";
			i++;
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, out);
		list.setAdapter(adapter);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_add) {
			
			Intent i = new Intent(CarActivity.this, AddCarActivity.class);              
            startActivity(i);

            // close this activity
            finish();
			

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
