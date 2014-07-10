package de.tuc.emla.geoerde;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class FranceFragment extends Fragment implements OnClickListener
{
	public FranceFragment()
    {
    }
	
	// logging output
	private static final String LOGCAT = "GeoErde-FragmentFrance";
	private static final boolean D = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		
		View view = inflater.inflate(R.layout.fragment_france, container, false);
        return view;
	}
	
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
