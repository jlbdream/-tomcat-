package com.yc.HuaShuo;

import java.io.PrintWriter;

import org.omg.CORBA.Request;

import com.yc.web.core.HttpServlet;
import com.yc.web.core.ServletRequest;
import com.yc.web.core.ServletResponse;

public class AdeminServlet extends HttpServlet {
	@Override
	public void doGet(ServletRequest request, ServletResponse response) {
		doPost(request, response);
	}
	
	@Override
	public void doPost(ServletRequest request, ServletResponse response) {
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		
		PrintWriter out = null;
		
		try {
			out =response.getWriter();
			out.print("name="+ name + "pwd="+pwd);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out !=null) {
				out.close();
			}
		}
		
	}
}
