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

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		String n=request.getParameter("name");
		String ph=request.getParameter("phone");
		String mail=request.getParameter("email");
		String pw=request.getParameter("pass");
		
		out.print("<h1> Name: "+n+"</h1>");
		out.print("<h1> Phone: "+ph+"</h1>");
		out.print("<h1> Email: "+mail+"</h1>");
		out.print("<h1> Password: "+pw+"</h1>");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/form","root","12345");  
			Statement stmt=con.createStatement();  
			PreparedStatement ps=con.prepareStatement("insert into register values('"+n+"','"+ph+"','"+mail+"','"+pw+"');");
			ps.executeUpdate();
			out.print("<h1>Input stored");
		} catch (Exception e) {
			out.print("Something went wrong");
		}
finally {
	out.println("<p>Already registered?<a href='login.jsp'>Login here</a></p>");
}
		
	}

}
