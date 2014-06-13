package de.tuc.emla.geoerde;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class AboutFragment extends Fragment implements OnClickListener
{
	public AboutFragment()
    {
    }
	
	// logging output
	private static final String LOGCAT = "GeoErde-FragmentAbout";
	private static final boolean D = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		Button btn;
		
		container.removeAllViews();
		
		View view = inflater.inflate(R.layout.fragment_about, container, false);
				
		btn = (Button) view.findViewById(R.id.buttonAbout);
        btn.setOnClickListener(this);
        
        return view;
	}
	
	/**
     * The eventHandler for the statistics-button
     * @param view the view of the main activity
     */
	@Override
    public void onClick(View v)
	{
		if(D) Log.d(LOGCAT, "Exit button pressed...");
		FragmentManager fm = getFragmentManager();
	    if (fm.getBackStackEntryCount() > 0)
	    {
	    	if(D) Log.i(LOGCAT, "popping backstack");
	        fm.popBackStack();
	    }
    }
}
