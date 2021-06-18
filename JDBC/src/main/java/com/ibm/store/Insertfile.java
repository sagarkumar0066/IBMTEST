package com.ibm.store;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insertfile 
{
   public static void main(String[] args) 
   {
	
	   try
	   {
		   String url = "jdbc:mysql://localhost:3306/jdbc_example";
	       String uname = "root";
	       String pass = "XAEA-12@mysql";
	       Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Connected to Database... ");
          Connection con = DriverManager.getConnection(url, uname, pass);
          
          PreparedStatement ps = con.prepareStatement("insert into filedb values(?,?)");
          File f = new File("C:\\Users\\91950\\eclipse-workspace\\JDBC\\src\\main\\resources\\textfile.txt");
          FileReader fr = new FileReader(f);
          
          ps.setInt(1, 102);
          ps.setCharacterStream(2, fr,(int)f.length());
          
          int i = ps.executeUpdate();
          System.out.println(i+"rows updated");
          con.close();
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	   
   }
}
