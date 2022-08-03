package kr.co.start.test;

import java.sql.Connection;

import kr.co.start.util.DBConnector;

public class DBConnectionTest {

	public static void main(String[] args) {
		
		try {
			Connection con = DBConnector.getConnection();
			System.out.println(con != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
