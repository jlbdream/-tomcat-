package com.yc.servelt;

import com.yc.web.core.HttpServlet;
import com.yc.web.core.ServletRequest;
import com.yc.web.core.ServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	public void doGet(ServletRequest request, ServletResponse response) {
		doPost(request, response);
	}
	
	@Override
	public void doPost(ServletRequest request, ServletResponse response) {
		System.out.println(" pwd = " + request.getParameter("pwd"));;
		System.out.println(" name= " + request.getParameter("name"));;
		
		response.sendRedirect("index.html");
	}

}
