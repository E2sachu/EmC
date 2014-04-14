package com.essachu.emc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class ChoixMenu extends Activity implements OnItemClickListener,
		OnItemSelectedListener {

	Spinner spin_lait, spin_fruit, spin_cereal;
	int array_calorie[];
	TextView totalCalories;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choix_menu);

		spin_lait = (Spinner) findViewById(R.id.spinner_lait);
		spin_fruit = (Spinner) findViewById(R.id.spinner_fruit);
		spin_cereal = (Spinner) findViewById(R.id.spinner_cereal);

		// On met le string-array calorie dans un tableau pour récupé l'item en
		// fonction de la position du spinner
		array_calorie = getResources().getIntArray(R.array.array_calories);
		Log.i("array_calorie", "" + array_calorie[1]);

		totalCalories = (TextView) findViewById(R.id.textView2);

		// Mise en place des spinners

		ArrayAdapter<CharSequence> adapter_lait = ArrayAdapter
				.createFromResource(this, R.array.array_lait,
						android.R.layout.simple_spinner_item);
		adapter_lait
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin_lait.setAdapter(adapter_lait);

		ArrayAdapter<CharSequence> adapter_fruit = ArrayAdapter
				.createFromResource(this, R.array.array_fruit,
						android.R.layout.simple_spinner_item);
		adapter_lait
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin_fruit.setAdapter(adapter_fruit);

		ArrayAdapter<CharSequence> adapter_cereal = ArrayAdapter
				.createFromResource(this, R.array.array_cereal,
						android.R.layout.simple_spinner_item);
		adapter_lait
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin_cereal.setAdapter(adapter_cereal);

		spin_lait.setOnItemSelectedListener(this);
		spin_fruit.setOnItemSelectedListener(this);
		spin_cereal.setOnItemSelectedListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choix_menu, menu);
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

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {

		// on récupère la valeur numérique du spinner
		int cereal_pos = spin_cereal.getSelectedItemPosition();
		int fruit_pos = spin_fruit.getSelectedItemPosition();
		int lait_pos = spin_lait.getSelectedItemPosition();
//		Log.i("Posion du spin_cereal", "" + cereal_pos);

		int calorie_cereal = array_calorie[cereal_pos];
		int calorie_fruit = array_calorie[lait_pos];
		int calorie_lait= array_calorie[fruit_pos];
//		Log.i("Valeur Calorie", "" + calorie_cereal);
		
		//Addition des calorie au total
		int totalK = calorie_cereal+calorie_fruit+calorie_lait;
		
		// 
		if (totalK <= 1) {
			totalCalories.setText(totalK + " Calorie");
		} else {
			totalCalories.setText(totalK + " Calories");
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
