package de.tuc.emla.geoerde;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends ActionBarActivity
{

	// logging output
	private static final String LOGCAT = "GeoErde-MainActivity";
	private static final boolean D = true;
	
	// the database (incl. instanciation)
	DatabaseController db = new DatabaseController(this);
		
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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
//        if (id == R.id.action_settings)
//        {
//            return true;
//        }
        if (id == R.id.action_about)
        {
        	// Display the fragment as the main content.
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new AboutFragment());
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
    	
    	
    }
}
