package com.tws.Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nitin
 */
import com.tws.Dao.DaoConnectionJdbc;
import com.tws.Dao.EmpDaoStudent;
import com.tws.Bean.StudentBean;
import java.util.*;
import java.sql.*;
public class EmpDaoStudent
{
    
    public static Connection getconnection()
    {
      Connection con=null;    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/croudexample","root","");
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Errror in mysql");
        }
        return con;
    }
    
    public static int save(StudentBean s)
    {
        int status=0;
        try
        {
            Connection con=EmpDaoStudent.getconnection();
            PreparedStatement ps=con.prepareStatement("insert into student(fname,lname,address)values(?,?,?)");
            ps.setString(1,s.getFname());
            ps.setString(2,s.getLname());
            ps.setString(3, s.getAddress());
            status=ps.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
           System.out.println("Errror in save"); 
        }
        
        return status;
    }
    
    public static int update(StudentBean s)
    {
        int status=0;
        try
         {
             Connection con=EmpDaoStudent.getconnection();
             PreparedStatement ps=con.prepareStatement("update student where set lname=?, address=? where id=?");
             ps.setString(1,s.getFname());
             ps.setString(2,s.getLname());
             ps.setString(3, s.getAddress());
             status=ps.executeUpdate();
             
         }catch(Exception e)
          {
              e.printStackTrace();
              System.out.println("Errror in upadet");
          }
        return status;
    }
    public static int delete(StudentBean s)
    {
        int status=0;
        try
         {
             Connection con=EmpDaoStudent.getconnection();
             PreparedStatement ps=con.prepareStatement("delete from student where id=?");
             ps.setString(1,"fname");
             status=ps.executeUpdate();
             con.close();
             
         }catch(Exception e)
         {
             e.printStackTrace();
             System.out.println("Error in delete");
         }
        return status;
    }
    public static List<StudentBean> getAllStudent()
    {
        List<StudentBean> list=new ArrayList<StudentBean>();
        try
        {
            Connection con=EmpDaoStudent.getconnection();
            PreparedStatement ps=con.prepareStatement("Select * fro student");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                StudentBean s=new StudentBean();
                s.setFname(rs.getString(1));
                s.setLname(rs.getString(2));
                s.setAddress(rs.getString(3));
                list.add(s);
                
            }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Eror in list student");
        }
        return list;
    }
}
