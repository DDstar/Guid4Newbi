package com.mine.testmodel;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setGuidResID(new int[]{R.drawable.guid_admin_1});
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
	
	@Override
	protected void postClick() {
		// TODO Auto-generated method stub
		super.postClick();
		startActivity(new Intent(this, SecondActivity.class));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void go2SecondAct(View view) {
		// TODO Auto-generated method stub
		startActivity(new Intent(this, SecondActivity.class));
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
}
