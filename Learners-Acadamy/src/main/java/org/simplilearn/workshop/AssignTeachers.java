package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assign")
public class AssignTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC Driver loaded");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Assign Teachers</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		out.println("<BR><H2>Fill in the details inorder to assign</H2><BR><BR>");
		out.println("</CENTER>");
		out.println("<FORM METHOD=POST>");
		out.println("Name of the Teacher : <INPUT TYPE=TEXT NAME=teacher><BR>");
		out.println("Subject 			 : <INPUT TYPE=TEXT NAME=subject><BR>");
		out.println("Class(enter 1 to 10): <INPUT TYPE=TEXT NAME=class><BR><INPUT TYPE=SUBMIT>");
		out.println("<BR>");
		out.println("<BR>");
		out.println("</FORM>");
		
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String teacher=request.getParameter("teacher");
		String subject=request.getParameter("subject");
		String num=request.getParameter("class");
		
		String sql="INSERT INTO CLASSES VALUES('class-"+num+"','"+teacher+"','"+subject+"')";
		try {
			String url="jdbc:mysql://localhost:3306/teksystem?useSSL=false";
			String user="root";
			String pass="anshula";

			//step-2 obtain a connection
			Connection connection=DriverManager.getConnection(url, user, pass);
			System.out.println("got connection");
			
			Statement s=connection.createStatement();
			int rs=s.executeUpdate(sql);
			if(rs==1)
			out.println("Assignment Successfull");
			else
			out.println("Not Inserted");
			s.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
		
	}

}
