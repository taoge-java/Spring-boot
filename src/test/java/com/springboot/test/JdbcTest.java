package com.springboot.test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;
import com.springboot.util.TransactionService;

public class JdbcTest {

	
	@Test
	public void test() throws SQLException {
		Connection conn=null;
		TransactionService service=new TransactionService();
		try {
			conn= service.startTransaction();
			PreparedStatement p= conn.prepareStatement("update user set name='hello121'"+"where id="+11);
			p.execute();
			System.out.println(conn.getAutoCommit());
			System.out.println(conn.getTransactionIsolation());
			PreparedStatement p2= conn.prepareStatement("update user set name='php1212'"+"where id="+12);
			p2.execute();
		} catch (SQLException e) {
			service.roolback();
			e.printStackTrace();
		}finally {
			service.close();
		}
	}

}
