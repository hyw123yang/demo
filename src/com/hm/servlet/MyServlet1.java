package com.hm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyServlet1() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String like=request.getParameter("like");
		name="С-"+name;
		like="ϲ��-"+like;
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/text");
		response.getWriter().println(name+" | "+like);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
