package com.yc.tomcat.core;

public class TomcatConstants {
	public static final String REQUEST_METHOD_GET="GET";//get请求
	
	public static final String REQUEST_METHOD_POST="POST";//post请求
	
	public static final long SESSION_TIMEOUT= 60 * 1000;//session的过期时间
	
	public static final int CLEAR_SESSION_CYCLE = 120 * 1000;//清除session的周期，定义为2分钟
	
	public static final String REQUEST_JSESSION="JSESSIONID";//Cookie的JSESSIONID的名称 
	
	public static final String BASE_PATH= ReadConfig.getInstance().getProperty("path");//基址路径
	
	public static final String DEFAULT_RESOURCE = ReadConfig.getInstance().getProperty("default");//默认资源

}
