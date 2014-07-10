package de.tuc.emla.geoerde;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnItemSelectedListener
{

	// logging output
	private static final String LOGCAT = "GeoErde-MainActivity";
	private static final boolean D = true;
	
	private static Spinner spinnerLecture;
	
	// the database (incl. instanciation)
	DatabaseController db = new DatabaseController(this);
		
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        if (savedInstanceState == null)
        {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    protected void onResume(Bundle savedInstanceState)
    {
    	if(D) Log.d(LOGCAT, "onResume...");
    }
    
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
    {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    	
    	/*FragmentTransaction transaction = getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new LessonsFragment(parent.getItemAtPosition(pos)));
        */
    	if(pos > 0)
    	{
    		FragmentTransaction transaction = getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new StatisticsFragment());
            transaction.addToBackStack(null);
            transaction.commit();
    	}
    }

    public void onNothingSelected(AdapterView<?> parent)
    {
        // Another interface callback
    }

    
    @Override
    public void onBackPressed()
    {
    	if(D) Log.d(LOGCAT, "Back pressed...");
		FragmentManager fm = getFragmentManager();
		if (fm.getBackStackEntryCount() > 0)
	    {
	    	if(D) Log.i(LOGCAT, "popping backstack");
	        fm.popBackStack();	        
	    }
		else
		{
			super.onBackPressed();
		}
	    return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        FragmentTransaction transaction;
//		FragmentManager.enableDebugLogging(D);
        switch (id)
        {
        case R.id.action_settings:
        	// Start a new activity for the preferences
			Intent intent = new Intent(this, PreferencesActivity.class);
			startActivity(intent);
        	break;

        case R.id.action_about:
        	// Display the fragment as the main content.
            transaction = getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new AboutFragment());
            transaction.addToBackStack(null);
            transaction.commit();
            break;
            
        default:
        	super.onOptionsItemSelected(item);
            break;
        }
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment
    {

        public PlaceholderFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            
            spinnerLecture = (Spinner) rootView.findViewById(R.id.spinnerContent);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                    R.array.lessons_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinnerLecture.setAdapter(adapter);
            spinnerLecture.setOnItemSelectedListener((MainActivity)this.getActivity());
            
            return rootView;
        }
    }

    /**
     * The eventHandler for the quiz-button
     * @param view the view of the main activity
     */
    public void buttonQuiz(View view)
    {
    	if(D) Log.d(LOGCAT, "Quiz button pressed...");
    	
    	// open the SendActivity with its own view
//		Intent intent = new Intent(this, QuizActivity.class);
//		startActivity(intent);
    }
    
    /**
     * The eventHandler for the statistics-button
     * @param view the view of the main activity
     */
    public void buttonStatistics(View view)
    {
    	if(D) Log.d(LOGCAT, "Statistics button pressed...");
    	// Display the fragment as the main content.
    	FragmentTransaction transaction = getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new StatisticsFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
