package com.hm.service.impl;

import com.hm.bean.Customer;
import com.hm.dao.CustomerDao;
import com.hm.dao.impl.CustomerDaoImpl;
import com.hm.service.ICustomerSerivce;

public class CustomerSerivce implements ICustomerSerivce {
	CustomerDao customerDao=null;
	
	public CustomerSerivce(){
		customerDao=new CustomerDaoImpl();
	}
	public Customer getCustomer(int id) {
		return customerDao.selectCustomer(id);
	}

}
