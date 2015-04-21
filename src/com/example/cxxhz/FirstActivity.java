package com.example.cxxhz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.first_layout);
	
	Button button1=(Button)findViewById(R.id.button_1);
	button1.setOnClickListener(
			  new OnClickListener() {
		        public void onClick(View v) {
			Toast.makeText(FirstActivity.this, "进入Blog", Toast.LENGTH_LONG).show();
			//显式intent
			Intent intent= new Intent(FirstActivity.this,SecondActivity.class);
			startActivity(intent);
		}
	});
	
	Button button2=(Button)findViewById(R.id.button_2);
	button2.setOnClickListener(
			  new OnClickListener() {
		        public void onClick(View v) {
			Toast.makeText(FirstActivity.this, "爱ta就要告诉ta", Toast.LENGTH_LONG).show();
			//显式intent
			Intent intent= new Intent(FirstActivity.this,ThirdActivity.class);
			startActivity(intent);
		}
	});
	
	Button button=(Button)findViewById(R.id.test);
	button.setOnClickListener(
			  new OnClickListener() {
		        public void onClick(View v) {
			Toast.makeText(FirstActivity.this, "和木木木木木木聊天咯~", Toast.LENGTH_LONG).show();
			//显式intent
			Intent intent= new Intent(FirstActivity.this,MainActivity.class);
			startActivity(intent);
		}
	});
}







@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
	getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	}
@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
switch(item.getItemId()){
case R.id.quit:
	finish();
	break;
default:
}
return true;
}

}
