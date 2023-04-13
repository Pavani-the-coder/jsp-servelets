package com.loginreg.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServelet")
public class loginServelet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String n=request.getParameter("name");
		String pw=request.getParameter("pass");
		
		
		//out.print("<h1> Name: "+n+"</h1>");
		//out.print("<h1> Name: "+pw+"</h1>");
		String tp="";
		int status=0;
		String un="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","12345");  
			Statement stmt=con.createStatement();  
			String sql ="SELECT name,email,password FROM register where email='"+n+"';";

			
            ResultSet rs= stmt.executeQuery(sql);

			while (rs.next()) {
                tp+=rs.getString("password").toString();
                un+=rs.getString("name").toString();
                if(pw.equals(tp)) {
    				status=1;
    			}   
            }
			//out.println("<h1>"+tp+"</h1>");
			
			 if(status==1) {
				 out.print("<script>alert('Logged in successfully')</script>");
				 out.print("<h1>Welcome "+un+"</h1>");
			 }
			 else {
				 out.print("<script>alert('Please check your password')</script>");
			 }
		} 
		  
		
		catch (Exception e) {
			out.print("Something went wrong");
		}
		
		

		
	}

}
