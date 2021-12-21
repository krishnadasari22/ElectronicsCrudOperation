package com.electronics;
import java.util.*;  
import java.sql.*;  
  
public class LaptopDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","abcd");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Laptop m){  
        int status=0;  
        try{  
            Connection con=LaptopDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into mobiles.mob(name,descriptions) values (?,?)");  
            ps.setString(1,m.getName());    
            ps.setString(2,m.getDescription());    
            status=ps.executeUpdate();               
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        	}  
          
        return status;  
    }  
    public static int update(Laptop e){  
        int status=0;  
        try{  
            Connection con=LaptopDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update mobiles.mob set name=?,description=?,where id=?");  
            ps.setString(1,e.getName());    
            ps.setString(2,e.getDescription());   
            ps.setInt(3,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=LaptopDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from mobiles.mob where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Laptop getEmployeeById(int id){  
    	Laptop m=new Laptop();  
          
        try{  
            Connection con=LaptopDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from mobiles.mob where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                m.setId(rs.getInt(1));  
                m.setName(rs.getString(2));   
                m.setDescription(rs.getString(3));   
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return m;  
    }  
    public static List<Laptop> getAllEmployees(){  
        List<Laptop> list=new ArrayList<Laptop>();  
          
        try{  
            Connection con=LaptopDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from mobiles.mob");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
            	Laptop m=new Laptop();  
                m.setId(rs.getInt(1));  
                m.setName(rs.getString(2));    
                m.setDescription(rs.getString(3));  
                list.add(m);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
	}  
}