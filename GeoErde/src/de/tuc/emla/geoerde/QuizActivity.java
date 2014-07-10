package de.tuc.emla.geoerde;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
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

public class QuizActivity extends Activity 
{	
	final Context context = this;
	private Button button;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// define the layout to use - a blank screen
    	setContentView(R.layout.fragment_quiz);  
    	
    	// Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new QuizFragment())
                .commit();
    	
//    	button = (Button) findViewById(R.id.btnResult);
//    	 
//		// add button listener
//		button.setOnClickListener(new OnClickListener() {
// 
//		@Override
//		public void onClick(View arg0) {
// 
//			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//				context);
// 
//			// set title
//			alertDialogBuilder.setTitle("Your Title");
// 
//			// set dialog message
//			alertDialogBuilder
//				.setMessage("Click yes to exit!")
//				.setCancelable(false)
//				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog,int id) {
//						// if this button is clicked, close
//						// current activity
//						QuizActivity.this.finish();
//					}
//				  })
//				.setNegativeButton("No",new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog,int id) {
//						// if this button is clicked, just close
//						// the dialog box and do nothing
//						dialog.cancel();
//					}
//				});
// 
//				// create alert dialog
//				AlertDialog alertDialog = alertDialogBuilder.create();
// 
//				// show it
//				alertDialog.show();
//			}
//		});
	}
    	
   
	  	public void QuizUkraine(View v) {
			
			FragmentTransaction transaction = getFragmentManager().beginTransaction()
	                .replace(android.R.id.content, new QuizUkraineFragment());
	        transaction.addToBackStack(null);
	        transaction.commit();
		}
	  	
	public void QuizGermany(View v) {
			
			FragmentTransaction transaction = getFragmentManager().beginTransaction()
	                .replace(android.R.id.content, new QuizGermanyFragment());
	        transaction.addToBackStack(null);
	        transaction.commit();
		}
	
	public void QuizFrance(View v) {
		
		FragmentTransaction transaction = getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new QuizFranceFragment());
        transaction.addToBackStack(null);
        transaction.commit();
	}
			public void onClick(View v) {
				
				FragmentTransaction transaction = getFragmentManager().beginTransaction()
		                .replace(android.R.id.content, new StatisticsFragment());
		        transaction.addToBackStack(null);
		        transaction.commit();
			}
}
