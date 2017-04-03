package com.oracle.rentcarmobile;

import com.oracle.rentcar.logic.CarLogic;
import com.oracle.rentcar.logic.RentLogic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity{
	
	private static CarLogic car = new CarLogic();
	private static RentLogic rent = new RentLogic();
	
	public SplashActivity() { }
	
	public CarLogic getCar(){
		return car;
	}
	
	public RentLogic getRent(){
		return rent;
	}
	
	private static int SPLASH_TIME_OUT = 3000;
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, MainActivity.class);              
                startActivity(i);
 
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
	
}
