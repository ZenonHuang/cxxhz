package com.example.cxxhz;
//用这个类封装数据
public class ListData {
	
	public static final int SEND=1;
	public static final int RCEIVER=2;
	private int flag;
	
private String content;

public ListData(String content,int flag){
	setContent(content);
	setFlag(flag);
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public int getFlag() {
	return flag;
}

public void setFlag(int flag) {
	this.flag = flag;
}

}
