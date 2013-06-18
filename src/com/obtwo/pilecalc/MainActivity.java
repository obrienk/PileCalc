package com.obtwo.pilecalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String toDisplay;
	double resistance=0;
	private TextView answer;
	private EditText weightOfRamInput,secondInput,thirdInput;
	private Spinner dmSpinner,ptSpinner,spinner3,spinner4;
	private Button bCalc;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeFields();	
		addListenerOnSpinner1();	//configures design method spinners to launch new activities
		addListenerOnButton();		//adds listener to calculate button
	}
	
	public void addListenerOnSpinner1(){
		dmSpinner = (Spinner) findViewById(R.id.spinner1);
		dmSpinner.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override	//change variables when different design methods are selected
			public void onItemSelected(AdapterView<?> parent, View view, int pos,long id){				
				if(pos == 0){
					;
				}
				else if(pos==1){
					Intent intent = new Intent(view.getContext(),SecondActivity.class);
					startActivityForResult(intent,0);
					finish();
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
			
	public void initializeFields(){
		ptSpinner = (Spinner) findViewById(R.id.spinner2); //pile types
		spinner3 = (Spinner) findViewById(R.id.spinner3); 
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		answer = (TextView)findViewById(R.id.textView4);
		weightOfRamInput = (EditText)findViewById(R.id.editText1);
		secondInput = (EditText)findViewById(R.id.editText2);
		thirdInput = (EditText)findViewById(R.id.editText3);
	}
	public void addListenerOnButton(){
		bCalc = (Button) findViewById(R.id.buttonCalc);
		
		bCalc.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this,"Calculating for : "+
												  "\nDesign Method : "+ String.valueOf(dmSpinner.getSelectedItem())+
												  "\nPile Type : " + String.valueOf(ptSpinner.getSelectedItem()),
												  Toast.LENGTH_SHORT).show();
				double rn = calculate();
				toDisplay = Double.toString(rn);
				answer.setText(toDisplay);
			}
		});//end button listener
	}
	public double calculate(){
		double A,B,C;
		A = valueOfA();
		B = valueOfB();
		C = valueOfC(); 
		return 20 * Math.sqrt((A*B)/1000) * Math.log10(10.0/C);
	}
	public double valueOfA(){
		double toReturn=0;
		String num1=weightOfRamInput.getText().toString();
		toReturn=Double.parseDouble(num1);
		return toReturn;
	}
	public double valueOfB(){
		double toReturn=0;
		String num=secondInput.getText().toString();
		toReturn=Double.parseDouble(num);
		String itemSelected = spinner3.getSelectedItem().toString();
		if(itemSelected.equals("Time(11 Blows)"))
			toReturn=.04*(Math.pow(toReturn,2))-.3;
		return toReturn;
	}
	public double valueOfC(){
		double toReturn=0;
		String num=thirdInput.getText().toString();
		toReturn=Double.parseDouble(num);
		String itemSelected = spinner4.getSelectedItem().toString();
		if(itemSelected.equals("Blows per Foot"))
			toReturn=12/toReturn;
		else if (itemSelected.equals("Inches per 10 Blows"))
			toReturn = toReturn/10;
		return toReturn;
	}



}
