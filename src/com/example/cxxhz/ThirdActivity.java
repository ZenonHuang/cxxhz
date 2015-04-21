package com.example.cxxhz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.third_layout);
		Button button5=(Button)findViewById(R.id.button_5);
		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:18275792202"));
				startActivity(intent);
			}
		});
		Button button6=(Button)findViewById(R.id.button_6);
		button6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:18673556610"));
				startActivity(intent);
			}
		});
}
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
