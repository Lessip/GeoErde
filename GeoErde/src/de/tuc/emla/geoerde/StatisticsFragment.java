package de.tuc.emla.geoerde;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StatisticsFragment extends Fragment implements OnClickListener
{
	DatabaseController db;
	RelativeLayout rlayout;
	TextView textLesson, textResult, textFazit;
	ImageView icon;
	
	private final int medium = 60;
	
	/**
	 * The standard constructor
	 */
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
				
		rlayout = (RelativeLayout) view.findViewById(R.id.layout_statistics);
		rlayout.setOnClickListener(this);
		
		textLesson = (TextView) view.findViewById(R.id.textLesson);
		textResult = (TextView) view.findViewById(R.id.textResult);
		textFazit = (TextView) view.findViewById(R.id.textFazit);
		icon = (ImageView) view.findViewById(R.id.icon);
        
        return view;
	}
	
	/**
     * A method to read the results from the local database and display them in a listView
     */
	public void readResults()
	{
		// read the results from the database
		Cursor resultCursor = db.getGeneralResult();
		if(resultCursor != null)
		{
			resultCursor.moveToFirst();
			
			while(!resultCursor.isAfterLast())
			{
				textLesson.setText(resultCursor.getString(1));
				textResult.setText(resultCursor.getString(2) + " / " + resultCursor.getString(3));
				icon.setImageResource(resultIcon(resultCursor));
				textFazit.setText(fazitText());
				resultCursor.moveToNext();
			}
		}
	}
	
	/**
     * A method to decide which icon (success/ fail) to show
     * @param cursor the cursor to the result from the database query
     */
	private int resultIcon(Cursor cursor)
	{
		if(cursor.getInt(2) < cursor.getInt(3))
		{
			return R.drawable.wrong;
		}
		else return R.drawable.correct;
	}
	
	/**
     * A method to decide which icon (success/ fail) to show
     * @param cursor the cursor to the result from the database query
     */
	private String fazitText()
	{
		int[] queryResult = db.getGeneralMistakes();
		
		// Initialize the string with the username from the preferences or a default value.
		String text = PreferenceManager.getDefaultSharedPreferences(((MainActivity)getActivity())).getString("firstname", "User");
		int result = 100 / queryResult[1] * queryResult[0];
		
		if(result == 100)
		{
			text += getString(R.string.result_text_perfect);
		}
		else if(result >= medium)
		{
			text += getString(R.string.result_text_middle) + queryResult[0];
			if(queryResult[0] == 1)
			{
				text += getString(R.string.result_mistake);
			}
			else
			{
				text += getString(R.string.result_mistakes);
			}
		}
		else
		{
			text += getString(R.string.result_text_bad) + String.valueOf(queryResult[0]) + getString(R.string.result_mistakes);
		}
		return text;
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
