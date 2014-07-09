package de.tuc.emla.geoerde;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class StatisticsFragment extends Fragment implements OnClickListener
{
	DatabaseController db;
	LinearLayout llayout;
	ListView resultsView;
	
	public StatisticsFragment()
    {
    }
	
	// logging output
	private static final String LOGCAT = "GeoErde-FragmentStatistic";
	private static final boolean D = true;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		db = ((MainActivity)getActivity()).db;
		
		View view = inflater.inflate(R.layout.fragment_statistics, container, false);
				
		llayout = (LinearLayout) view.findViewById(R.id.layout_statistics);
		llayout.setOnClickListener(this);
		
		resultsView = (ListView) view.findViewById(R.id.listViewResults);
        
        return view;
	}
	
	/**
     * A method to read the results from the local database and display them in a listView
     */
	public void showResults()
	{
		// read the results from the database
		Cursor resultCursor = db.getGeneralResult();
		if(resultCursor != null)
		{
			resultCursor.moveToFirst();
			
			while(!resultCursor.isAfterLast())
			{
				// TODO: insert result into resultsView
				resultCursor.moveToNext();
			}
		}
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
