package com.electronics;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@SuppressWarnings("serial")
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Mobile</a>");  
        out.println("<h1>Mobiles List</h1>");  
          
        List<Mobile> list=MobileDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Date</th><th>Notes</th><th>Assignment Status</th>"
        		+ "<th>Edit</th><th>Delete</th></tr>");  
        for(Mobile m:list){  
         out.print("<tr><td>"+m.getId()+"</td><td>"+m.getName()+"</td><td>"+m.getDate()+"</td>"
         		+ "<td>"+m.getNotes()+"</td><td>"+m.getStatus()+"</td><td><a href='EditServlet?id="+m.getId()+"'>edit</a></td>"
         				+ "<td><a href='DeleteServlet?id="+m.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}