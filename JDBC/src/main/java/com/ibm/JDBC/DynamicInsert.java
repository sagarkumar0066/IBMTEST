package com.ibm.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInsert 
{
	public static void main(String args[])
	   {
		   String url = "jdbc:mysql://localhost:3306/jdbc_example";
	       String uname = "root";
	       String pass = "XAEA-12@mysql";
	       
	       Connection con = null;
	       
	       try
	       {
	    	   Class.forName("com.mysql.cj.jdbc.Driver");
	           System.out.println("Connected to Database... ");
	           
	           con = DriverManager.getConnection(url, uname, pass);
	           
	           PreparedStatement ps = con.prepareStatement("insert into emp(name,salary) values(?,?)");
	           
	           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	          
	           
	           System.out.println("Enter emp name : ");
	           String name = br.readLine();
	           
	           System.out.println("Enter emp salary : ");
	           String salary = br.readLine();
	           
	           ps.setString(1, name);
	           ps.setString(2, salary);
	           
	           ps.executeUpdate();
	           
	           System.out.println("Data inserted..");
	           
	       }
	       catch(Exception e)
	       {
	       	System.out.println(e);
	       }
	       finally
	       {
	       	try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       }
	   }
}
