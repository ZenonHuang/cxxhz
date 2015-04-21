package com.example.cxxhz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.second_layout);
	Button button3=(Button)findViewById(R.id.button_3);
	button3.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://www.cxxhz.com"));
			startActivity(intent);
		}
	});
	Button button4=(Button)findViewById(R.id.button_4);
	button4.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://blog.sina.com.cn/u/3836820968"));
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
