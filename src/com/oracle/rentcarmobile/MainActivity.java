package com.oracle.rentcarmobile;

import com.oracle.rentcar.logic.CarLogic;
import com.oracle.rentcar.model.Bus;
import com.oracle.rentcar.model.Car;
import com.oracle.rentcar.model.Shuttle;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {
	
	Button btnBus;
	Button btnPinjam;
	Button btnKembali;
	Button btnReport;
	private CarLogic car;
	
	
	public MainActivity() {
		// TODO Auto-generated constructor stub			
		car = new SplashActivity().getCar();		
		
		Car b1 = new Bus("B 123 DX");				
		Car s1 = new Shuttle("B 890 FR");
				
		car.addCar("b1",b1);		
		car.addCar("s1",s1);
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnBus = (Button) findViewById(R.id.btn_car);
		btnKembali = (Button) findViewById(R.id.btn_kembali);
		btnPinjam = (Button) findViewById(R.id.btn_pinjam);
		btnReport = (Button) findViewById(R.id.btn_report);

		btnBus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this, CarActivity.class);
				startActivity(in);
			}
		});
		
		btnPinjam.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this, PinjamActivity.class);
				startActivity(in);
			}
		});
		
		btnKembali.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this, KembaliActivity.class);
				startActivity(in);
			}
		});
		
		btnReport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(MainActivity.this, ReportActivity.class);
				startActivity(in);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {

			Dialog dialog = new Dialog(this);
			dialog.setContentView(R.layout.activity_info);
			dialog.setTitle("RentCar Mobile Apps");
			dialog.setCancelable(true);
			dialog.show();

			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
