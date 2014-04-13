package com.essachu.emc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button choice, alea;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		choice = (Button) findViewById(R.id.menu_choice);
		alea = (Button) findViewById(R.id.menu_alea);
		
		choice.setOnClickListener(this);
		alea.setOnClickListener(this);
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

	
	public void onClick (View v){
		if (v == choice){
			Intent iChoice = new Intent(this,ChoixMenu.class);
			startActivity(iChoice);
		}
		
		if(v == alea){
			Intent iAlea = new Intent(this,ChoixAlea.class);
			startActivity(iAlea);
		}
	}

}
