package com.hm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hm.bean.Customer;
import com.hm.dao.CustomerDao;
import com.hm.util.DataBaseUtil;

public class CustomerDaoImpl implements CustomerDao {

	DataBaseUtil dbutil=null;
	public CustomerDaoImpl() {
		dbutil=new DataBaseUtil();
	}
	
	public Customer selectCustomer(int id) {
		Customer customer=null;
		Connection conn=dbutil.getConnection();
		PreparedStatement pstat=null;
		ResultSet rs=null;
		String sql="select * from customer where id=?";
		try{
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1, id);
			rs=pstat.executeQuery();
			if(rs.next()) {
				customer=new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setSex(rs.getString("sex"));
				customer.setAge(rs.getInt("age"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			dbutil.closeConnection(conn, pstat, rs);
		}
		return customer;
	}

}
