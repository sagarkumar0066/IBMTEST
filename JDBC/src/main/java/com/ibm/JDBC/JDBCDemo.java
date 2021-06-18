package com.ibm.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo 
{
	static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
	static final String DB_Url = "jdbc:mysql://localhost:3306/world";
	
	static final String USER_NAME="root";
	static final String USER_PASS = "XAEA-12@mysql";
	
	
   public static void main(String args[]) throws SQLException
   {
	   JDBCDemo jdbcDemo = new JDBCDemo();
	   jdbcDemo.getCityInformation();
   }
   private void getCityInformation() throws SQLException
   {
	   Connection connection = null;
	   Statement statement = null;
	   
	   try
	   {
		   Class.forName(JDBC_Driver);
		   System.out.println("Connecting to database");
		   
		   connection = DriverManager.getConnection(DB_Url, USER_NAME, USER_PASS);
		   statement = connection.createStatement();
		   
		                // ID,Name,CountryCode,District,Population
		   String sql = "select * from city where id<21";
		   
		   ResultSet rs = statement.executeQuery(sql);
		   
		   while(rs.next())
		   {
			   int id = rs.getInt("ID");
			   String name = rs.getString("Name");
			   String countryCode = rs.getString("CountryCode");
			   String district = rs.getString("District");
			   int population = rs.getInt("Population");
			   
			   
			   System.out.print("ID : "+id);
			   System.out.print(", Name : "+name);
			   System.out.print(", Country Code : "+countryCode);
			   System.out.print(",District : "+district);
			   System.out.println(",Population : "+population);
		   }
		   connection.close();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   finally
	   {
		   connection.close();
	   }
	   
   }
}
