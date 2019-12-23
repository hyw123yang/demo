package com.hm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {
	private Connection conn=null;
	private Statement stat=null;
	private PreparedStatement pstat=null;
	private ResultSet rs=null;

	//改动处-1
	//private String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private String url="jdbc:mysql://localhost:3306/jsp1?useUnicode=true&characterEncoding=UTF8";
	private String user="root";
	private String password="123";
	
	
	static{
		try{
			//改动处-2
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//获得连接对象
	public Connection getConnection() {
		try{
			conn=DriverManager.getConnection(url, user, password);
		}catch(SQLException e){
			return null;
		}
		return conn;
	}
	
	//关闭连接对象
	public void closeConnection(Connection conn) {
		try{
			close(conn);
		}catch(SQLException e){ }
	}
	public void closeConnection(Connection conn, PreparedStatement pstat) {
		try{
			close(pstat);
		}catch(SQLException e){ }finally {
			try{
				close(conn);
			}catch(SQLException e){ }
		}
	}
	public void closeConnection(Connection conn, Statement stat) {
		try{
			close(stat);
		}catch(SQLException e){ }finally {
			try{
				close(conn);
			}catch(SQLException e){ }
		}
	}
	public void closeConnection(Connection conn, PreparedStatement pstat, ResultSet rs) {
		try{
			close(rs);
		}catch(SQLException e){ }finally {
			try{
				close(pstat);
			}catch(SQLException e){ }finally {
				try{
					close(conn);
				}catch(SQLException e){ }
			}
		}
	}
	public void closeConnection(Connection conn, Statement stat, ResultSet rs) {
		try{
			close(rs);
		}catch(SQLException e){ }finally {
			try{
				close(stat);
			}catch(SQLException e){ }finally {
				try{
					close(conn);
				}catch(SQLException e){ }
			}
		}
	}
	
	private void close(Connection conn) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
	}
	private void close(PreparedStatement pstat) throws SQLException {
		if(pstat!=null) {
			pstat.close();
		}
	}
	private void close(Statement stat) throws SQLException {
		if(stat!=null) {
			stat.close();
		}
	}
	private void close(ResultSet rs) throws SQLException {
		if(rs!=null) {
			rs.close();
		}
	}
}
