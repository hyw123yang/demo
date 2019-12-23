package com.hm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hm.bean.Customer;
import com.hm.service.ICustomerSerivce;
import com.hm.service.impl.CustomerSerivce;

public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICustomerSerivce customerSerivce=null;
	
    public MyServlet2() {
        super();
    }
    public void init() throws ServletException {
    	customerSerivce=new CustomerSerivce();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		
		Customer customer=customerSerivce.getCustomer(id);
		String customerInfo="<p>编号："+customer.getId()+"<p>姓名："+customer.getName()
			+"<p>性别："+customer.getSex()+"<p>年龄："+customer.getAge();

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/text");
		response.getWriter().println(customerInfo);
	}

}
