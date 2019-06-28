package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class Exercise1Java7 {

	private static final int NO_TIME_OUT = 1;
	
	@Test
	public void open_jdbc_connection() {
		
		try(Connection conn = DriverManager.getConnection("jdbc:h2:mem:exercise_db;DB_CLOSE_DELAY=-1")){
			System.out.println("Are weconnected to Database "+conn.isValid(NO_TIME_OUT));
			conn.createStatement().execute("create table bids (id idenity,use VARCHAR,time "
					+ "TIMESTAMP,amount NUMBER,currency VARCHAR)");
			conn.createStatement().execute("create table items (id identity,name VARCHAR)");
			System.out.println("Tables created");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
