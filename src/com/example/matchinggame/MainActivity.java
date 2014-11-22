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
private MatchGrid grid = new MatchGrid();
private Button b00, b01, b02, b03, b10, b11, b12, b13, b20, b21, b22, b23, b30, b31, b32, b33;
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
		
		b00 = (Button) findViewById(R.id.b00);
		b00.setTag(0,grid.getTile(0,0));
		b01 = (Button) findViewById(R.id.b01);
		b01.setTag(0,grid.getTile(0,1));
		b02 = (Button) findViewById(R.id.b02);
		b02.setTag(0,grid.getTile(0,2));
		b03 = (Button) findViewById(R.id.b03);
		b03.setTag(0,grid.getTile(0,3));
		b10 = (Button) findViewById(R.id.b10);
		b10.setTag(0,grid.getTile(1,0));
		b11 = (Button) findViewById(R.id.b11);
		b11.setTag(0,grid.getTile(1,1));
		b12 = (Button) findViewById(R.id.b12);
		b12.setTag(0,grid.getTile(1,2));
		b13 = (Button) findViewById(R.id.b13);
		b13.setTag(0,grid.getTile(1,3));
		b20 = (Button) findViewById(R.id.b20);
		b20.setTag(0,grid.getTile(2,0));
		b21 = (Button) findViewById(R.id.b21);
		b21.setTag(0,grid.getTile(2,1));
		b22 = (Button) findViewById(R.id.b22);
		b22.setTag(0,grid.getTile(2,2));
		b23 = (Button) findViewById(R.id.b23);
		b23.setTag(0,grid.getTile(2,3));
		b30 = (Button) findViewById(R.id.b30);
		b30.setTag(0,grid.getTile(3,0));
		b31 = (Button) findViewById(R.id.b31);
		b31.setTag(0,grid.getTile(3,1));
		b32 = (Button) findViewById(R.id.b32);
		b32.setTag(0,grid.getTile(3,2));
		b33 = (Button) findViewById(R.id.b33);
		b33.setTag(0,grid.getTile(3,3));
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
