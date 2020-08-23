package com.yc.tomcat.core;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

public class ParseUrlPattern {
	private String basePath = TomcatConstants.BASE_PATH;//获取基址路径
	private static Map<String, String> urlPattern = new HashMap<String, String>();//解析后的映射
	
	public ParseUrlPattern() {
		parse();
	}

	private void parse() {

		//获取服务中部署的所有项目
		File[] files = new File(basePath).listFiles();
		if(files == null || files.length <= 0) {
			return;
		}
		String projectName = null;
		File chaildFile = null;
		
		for(File fl : files) {
			projectName=fl.getName();
			
			
			if(!fl.isDirectory()) {
				continue;
			}
			
			//获取这个项目下的web。xml文件
			chaildFile =new File(fl,"web.xml");
			if(!chaildFile.exists()) {
				continue;
			}
			ParseXml(projectName,chaildFile);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void ParseXml(String projectName, File chaildFile) {
		SAXReader read = new SAXReader();
		Document doc =null;
		
		try {
			doc = read.read(chaildFile);
			
			
			List<Element> mimes = doc.selectNodes("//servlet");
			
			//循环解析
			for( Element el : mimes) {
				urlPattern.put("/" + projectName + el.selectSingleNode("url-pattren").getText().trim(), el.selectSingleNode("servlet-class").getText().trim());
			}
			
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		
	}
	public static String getClass(String url) {
		return urlPattern.getOrDefault(url, null);
		
	}
	
	public Map<String, String> getUrlPattern(){
		return urlPattern;
		
	}
	
}
