package com.oracle.rentcarmobile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.oracle.rentcar.logic.RentLogic;
import com.oracle.rentcar.model.Rent;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
@SuppressLint("SimpleDateFormat")
public class KembaliActivity extends ActionBarActivity {

	private ListView list;
	private RentLogic r;

	public KembaliActivity() {
		// TODO Auto-generated constructor stub
		r = new SplashActivity().getRent();
	}

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
			String s = (rr.getActual()!=null)?"*":"";
			String e = new SimpleDateFormat("yyyy-MM-dd").format(rr.getEnd());			
				out[i] = rr.getName() + "\n" + rr.getCar().getNopol()+" "+s
						+ "\nTgl Kembali: " + e +"\nBiaya " +"Rp "+rr.getCost();							
		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, out);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				// TODO Auto-generated method stub

				Rent re = rent.get(position);
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						KembaliActivity.this);

				alertDialogBuilder.setTitle("Konfirmasi Pengembalian");
				alertDialogBuilder
						.setMessage(
								"Apakah anda akan set data: " + re.getName()
										+ " - " + re.getCar().getNopol()
										+ " telah mengembalikan?")
						.setCancelable(false)
						.setPositiveButton("Ya",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										
										r.kembali(position);
										Toast.makeText(getApplicationContext(),
												"Pengembalian Berhasil di Set", Toast.LENGTH_LONG)
												.show();
										KembaliActivity.this.finish();
									}
								})
						.setNegativeButton("Tidak",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.cancel();
									}
								});

				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();
			}
		});

	}

}
