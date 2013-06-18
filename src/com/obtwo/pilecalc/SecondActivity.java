package com.obtwo.pilecalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SecondActivity extends Activity {
	private TextView weightOfPile,weightOfCap,answer;
	private EditText weightOfPileInput,weightOfCapInput;
	private Spinner dmSpinner,ptSpinner,spinner3,spinner4;
	private Button bCalc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		addListenerOnSpinner1();
		initializeFields();
		addListenerOnButton();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	public void initializeFields(){
		answer = (TextView)findViewById(R.id.textView4);
		ptSpinner = (Spinner) findViewById(R.id.spinner2);
		weightOfPile = (TextView)findViewById(R.id.textView5);
		weightOfPile = (TextView)findViewById(R.id.textView6);
		weightOfPileInput = (EditText)findViewById(R.id.editText4);
		weightOfPileInput = (EditText)findViewById(R.id.editText5);
	}
	public void addListenerOnSpinner1(){
		dmSpinner = (Spinner) findViewById(R.id.spinner1);
		dmSpinner.setSelection(1, true);
		dmSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
			
			@Override	
			public void onItemSelected(AdapterView<?> parent, View view, int pos,long id){				
				if(pos == 0){
					Intent intent = new Intent(view.getContext(),MainActivity.class);
					startActivityForResult(intent,0);
					finish();
				}
				else if(pos==1){
					;
				}
				else if(pos==2){
					Intent intent = new Intent(view.getContext(),ThirdActivity.class);
					startActivityForResult(intent,0);
					finish();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});//end onItemSelectedListener
	}
	public void addListenerOnButton(){
		bCalc = (Button) findViewById(R.id.buttonCalc);
		
		bCalc.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast.makeText(SecondActivity.this,"Calculating for : "+
												  "\nDesign Method : "+ String.valueOf(dmSpinner.getSelectedItem())+
												  "\nPile Type : " + String.valueOf(ptSpinner.getSelectedItem()),
												  Toast.LENGTH_SHORT).show();
				answer.setText("answer will go here");
			}
		});//end setOnClickListener
	}

}
