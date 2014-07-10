package de.tuc.emla.geoerde;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class UkraineFragment extends Fragment implements OnClickListener
{
	public UkraineFragment()
    {
    }
	
	// logging output
	private static final String LOGCAT = "GeoErde-FragmentUkraine";
	private static final boolean D = true;
	
	 private EditText edittext;
	 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
//		addKeyListener();
		View view = inflater.inflate(R.layout.fragment_ukraine, container, false);
        return view;
	}
	
	
//	public void addKeyListener() {
//		 
//		// get edittext component
//		edittext = (EditText) findViewById(R.id.quiz_editUkraine);
//	 
//		// add a keylistener to keep track user input
//		edittext.setOnKeyListener(new OnKeyListener() {
//		public boolean onKey(View v, int keyCode, KeyEvent event) {
//	 
//			// if keydown and "enter" is pressed
//			if ((event.getAction() == KeyEvent.ACTION_DOWN)
//				&& (keyCode == KeyEvent.KEYCODE_ENTER)) {
//	 
//				// display a floating message
//				Toast.makeText(QuizActivity.this,
//					edittext.getText(), Toast.LENGTH_LONG).show();
//				return true;
//	 
//			} else if ((event.getAction() == KeyEvent.ACTION_DOWN)
//				&& (keyCode == KeyEvent.KEYCODE_9)) {
//	 
//				// display a floating message
//				Toast.makeText(QuizActivity.this,
//					"Number 9 is pressed!", Toast.LENGTH_LONG).show();
//				return true;
//			}
//	 
//			return false;
//		}
//	 });
//	}
	
	/**
     * The eventHandler for the fragment screen
     * @param view the view of the main activity
     */
	@Override
    public void onClick(View v)
	{
		if(D) Log.d(LOGCAT, "Exit pressed...");
		FragmentManager fm = getFragmentManager();
		if (fm.getBackStackEntryCount() > 0)
	    {
	    	if(D) Log.i(LOGCAT, "popping backstack");
	        fm.popBackStack();	        
	    }
	    return;
    }
}
