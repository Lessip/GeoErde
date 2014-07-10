package de.tuc.emla.geoerde;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class LessonsActivity extends Activity 
{	
	private Spinner spinner;
	private Button btnSubmit;
	private String[] states;
	final Context context = this;
	private ImageView image;
	private TypedArray imgs;
	int check=0;
	
	TextView mTvCountry;
 
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// define the layout to use - a blank screen
    	setContentView(R.layout.fragment_lessons);
    	
//    	addListenerOnB();
// 		addListenerOnSpinnerItemSelection(); 
    	
    	// Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new LessonsFragment())
                .commit();
    } 	

	  	public void Ukraine(View v) {
			
			FragmentTransaction transaction = getFragmentManager().beginTransaction()
	                .replace(android.R.id.content, new UkraineFragment());
	        transaction.addToBackStack(null);
	        transaction.commit(); 
		}
	  	
public void Germany(View v) {
			
			FragmentTransaction transaction = getFragmentManager().beginTransaction()
	                .replace(android.R.id.content, new GermanyFragment());
	        transaction.addToBackStack(null);
	        transaction.commit(); 
		}

public void France(View v) {
	
	FragmentTransaction transaction = getFragmentManager().beginTransaction()
            .replace(android.R.id.content, new FranceFragment());
    transaction.addToBackStack(null);
    transaction.commit(); 
}

			public void onClick(View v) {
				
				FragmentTransaction transaction = getFragmentManager().beginTransaction()
		                .replace(android.R.id.content, new StatisticsFragment());
		        transaction.addToBackStack(null);
		        transaction.commit();  
				
//				 AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        	 builder.setTitle("Message")
//        	     .setNeutralButton("OK", null);
//
//        	 AlertDialog dialog = builder.create();
//        	 dialog.show();
			}

			
			
//			public void onItemSelected(AdapterView<?> parent, View view, int pos,
//					long id) {
//				TextView picked = (TextView)view;
//				if(picked==null) {
//			        //do something;
//			    } else {
//			    	Toast.makeText(parent.getContext(), 
//							"OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
//							Toast.LENGTH_SHORT).show();
//			    }

//				Object item = parent.getItemAtPosition(pos);
//			}
//
//			@Override
//			public void onNothingSelected(AdapterView<?> arg0) {
//				// TODO Auto-generated method stub
//
//			}	
}
