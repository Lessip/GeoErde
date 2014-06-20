package de.tuc.emla.geoerde;

import android.app.Activity;
import android.os.Bundle;

public class PreferencesActivity extends Activity
{	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// define the layout to use - a blank screen
    	setContentView(R.layout.activity_preferences);
    	
    	// Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
	}
}
