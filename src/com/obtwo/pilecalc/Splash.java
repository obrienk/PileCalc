package com.obtwo.pilecalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity{

	@Override
	protected void onCreate(Bundle startUpScreen) {
		// TODO Auto-generated method stub
		super.onCreate(startUpScreen);
		setContentView(R.layout.splash);
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1000); //sleep for 3 secs
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity= new Intent ("com.obtwo.pilecalc.MAINACTIVITY");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
