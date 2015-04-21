package com.example.cxxhz;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity implements HttpDataListener,OnClickListener{

	private HttpData httpData;//声明异步请求对象
	private List<ListData> lists;
	private ListView lv;
	private EditText getEditText;
	private Button send;
	
	private String contentString;
	private TextAdapter textAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        
    }

    private void initView(){//初始化View
    	
    	lv=(ListView)findViewById(R.id.lv);
        getEditText=(EditText)findViewById(R.id.et);
        send=(Button) findViewById(R.id.send_button);
    	send.setOnClickListener(this);
        
    	lists=new ArrayList<ListData>();//实例化lists
    	textAdapter=new TextAdapter(lists, this);
    	lv.setAdapter(textAdapter);
    }
    
    
    
	@Override
	public void getDataUrl(String data) {
		// TODO Auto-generated method stub
		parseText(data);//传参数
	}

public void parseText(String str){//解析json
	try {
		
		JSONObject jo=new JSONObject(str);
		ListData listData;//使用我们的封装类
		listData=new ListData(jo.getString("text"),ListData.RCEIVER);//使用jsonobject的getString方法，得到“text”数据
		lists.add(listData);//添加到集合当中
		textAdapter.notifyDataSetChanged();//进行重新适配
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	contentString=getEditText.getText().toString();
	ListData listData;
	listData=new ListData(contentString, ListData.SEND);
	lists.add(listData);
	textAdapter.notifyDataSetChanged();
	httpData=(HttpData)new HttpData("http://www.tuling123.com/openapi/api?key=2870df09929e61e0317d1ccc2daac214&info="+contentString,
    		this).execute();
	getEditText.setText("");
}
}
