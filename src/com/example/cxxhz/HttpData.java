package com.example.cxxhz;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import android.os.AsyncTask;

public class HttpData extends AsyncTask<String, Void , String>{

	private HttpClient mHttpClient;
	private HttpGet mHttpGet;//http的get方式获取数据
	private HttpResponse mHttpResponse;//通过response发送数据
	private HttpEntity mEntity;//创建http实体
	private InputStream in;
	
	private HttpDataListener listener;
	private String url;
	public HttpData(String url,HttpDataListener listener){//提高代码复用性，使用构造方法
		this.url=url;
		this.listener=listener;
	}
	
	
	@Override
	protected String doInBackground(String... arg0) {
		// TODO Auto-generated method stub
		try {//获取数据
			mHttpClient=new DefaultHttpClient();//实例化http客户端
			mHttpGet=new HttpGet(url);//传递是一个url
			mHttpResponse=mHttpClient.execute(mHttpGet);//通过客户端，发送数据
			mEntity=mHttpResponse.getEntity();//通过response得到http实体
			in=mEntity.getContent();//输入流获得http实体传递的数据
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			String line=null;
			StringBuffer sb=new StringBuffer();
			while((line=br.readLine())!=null){//假如读取的数据不为空
				sb.append(line);//向stringbuffer对象，添加数据
				
			}
			return sb.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	protected void onPostExecute(String result) {//复写方法
		// TODO Auto-generated method stub
		listener.getDataUrl(result);
		super.onPostExecute(result);
	}
	
}
