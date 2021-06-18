package com.ibm.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App 
{
	public static void main( String[] args )
    {
        String url = "jdbc:mysql://localhost:3306/jdbc_example";
        String uname = "root";
        String pass = "XAEA-12@mysql";
        
        Connection con = null;
        
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database... ");
            
            con = DriverManager.getConnection(url, uname, pass);
            
            PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
            ps.setInt(1, 548);
            ps.setString(2, "sharath goud");
            ps.setString(3, "20,000");
            
            ps.executeUpdate();
            
            System.out.println("Data Inserted");
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
