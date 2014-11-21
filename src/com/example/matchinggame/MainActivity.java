package com.example.matchinggame;

//Below are the necessary imports
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends Activity{

FragmentManager fragmentManager = getFragmentManager();
	
Fragment fragment = fragmentManager.findFragmentByTag("FragmentGrid");
Fragment fragment2 = fragmentManager.findFragmentByTag("fragmentStart");
// Insert the fragment by replacing any existing fragment


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		final Button button = (Button) findViewById(R.id.bStart);
        	button.setOnClickListener(new View.OnClickListener() {
            	public void onClick(View v) {
                	fragmentManager.beginTransaction().replace(R.id.fragmentStart, fragment).commit();    
            	}
		});
        	
        	final Button button2 = (Button) findViewById(R.id.bQuit);
        	button2.setOnClickListener(new View.OnClickListener() {
            	public void onClick(View v) {
                	fragmentManager.beginTransaction().replace(R.id.FragmentGrid, fragment2).commit();    
            	}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
