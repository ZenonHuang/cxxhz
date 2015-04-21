package com.example.cxxhz;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextAdapter extends BaseAdapter{

	private List<ListData> lists;
	private Context mContext;
	private RelativeLayout layout;
	
	public TextAdapter(List<ListData> lists,Context mContext){
		this.lists=lists;
		this.mContext=mContext;
	}
	
	
	public int getCount() {
		return lists.size();
	}

	public Object getItem(int arg0) {
		return lists.get(arg0);
	}

	public long getItemId(int arg0) {
		return arg0;
	}


	public View getView(int arg0, View arg1, ViewGroup arg2) {//最重要的方法getView
		 LayoutInflater inflater=LayoutInflater.from(mContext);
		 //决定加载哪个布局
		if(lists.get(arg0).getFlag()==ListData.RCEIVER){
			layout=(RelativeLayout)inflater.inflate(R.layout.leftitem_layout, null);
		}
		if(lists.get(arg0).getFlag()==ListData.SEND){
			layout=(RelativeLayout)inflater.inflate(R.layout.rightitem_layout, null);
		}
		TextView tv=(TextView)layout.findViewById(R.id.leftT);
		tv.setText(lists.get(arg0).getContent());
		return layout;
	}

}
