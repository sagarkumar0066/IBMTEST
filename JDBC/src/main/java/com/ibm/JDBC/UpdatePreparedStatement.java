package com.ibm.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePreparedStatement 
{
    public static void main(String[] args) throws SQLException 
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
	           
	          // PreparedStatement ps = con.prepareStatement("update emp set name =? where id=?");
	           
//	           ps.setString(1, "prakash");
//	           ps.setInt(2, 567);
	           
	           PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
	           ps.setInt(1, 567);
	           
	           int i = ps.executeUpdate();
	           System.out.println(i+"rows updated");
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }
	     finally
	     {
	    	 con.close();
	     }
	       
    }
}
