package ita.framework.controller;

public class NextPage {
	public static final int DISPATCH = 0; 
	public static final int REDIRECT = 1;
	
	private String url;
	private int method = DISPATCH;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public int getMethod() {
		return method;
	}
	
	public void setMethod(int method) {
		this.method = method;
	}
	
	public NextPage(String url) {
		this(url, DISPATCH);
	}

	public NextPage(String url, int method) {
		this.url = url;
		this.method = method;
	}
}
