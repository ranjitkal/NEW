/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tws.Dao;

/**
 *
 * @author nitin
 */
import java.sql.*;
import java.util.*;
public class DaoConnectionJdbc
{
    static Connection con=null;
    Scanner s=new Scanner(System.in);
    static  Connection setConnection()
    {
        try
        {
            if(con==null)
            {
             System.out.println("Connection Class One time executed");
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_bus_booking?useSSL=false","root",""); 
            }
            
        } 
        catch (Exception ex) 
        {
        	 ex.getStackTrace();
          System.out.println("Error hai ");
         
        }
        return con;
    }
   
    
}
