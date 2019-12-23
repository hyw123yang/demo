package com.hm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hm.bean.Employee;
import net.sf.json.JSONArray;

public class MyServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyServlet3() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("deptid");
		System.out.println(id);
		
		List<Employee> emps=new ArrayList<Employee>();
		Employee emp=null;
		
		if(id.equals("1001")) {
			emp=new Employee("A100101", "张三1", "男", "16");
			emps.add(emp);
			emp=new Employee("A100102", "张三2", "男", "17");
			emps.add(emp);
			emp=new Employee("A100103", "张三3", "男", "18");
			emps.add(emp);
		}
		if(id.equals("1002")) {
			emp=new Employee("B100101", "李四1", "男", "16");
			emps.add(emp);
			emp=new Employee("B100102", "李四2", "男", "17");
			emps.add(emp);
		}
		
		JSONArray jsonArr=JSONArray.fromObject(emps);
		String jsonInfo=jsonArr.toString();
		
		response.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("text/text");
		response.getWriter().print(jsonInfo);
	}

}
