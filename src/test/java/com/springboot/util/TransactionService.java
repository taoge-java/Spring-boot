package com.springboot.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionService {

	private Connection conn;
	
	private Boolean autoCommit=null;
	
	public Connection startTransaction(){
		if(conn==null){
			conn=JdbcUtil.getConnection();
			try {
				autoCommit=conn.getAutoCommit();
				conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
				conn.setAutoCommit(false);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void commit(){
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void roolback(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() throws SQLException{
		if(conn!=null){
			System.out.println(autoCommit);
			if(autoCommit!=null){
				conn.setAutoCommit(autoCommit);
			}
			conn.close();
		}
	}
}
