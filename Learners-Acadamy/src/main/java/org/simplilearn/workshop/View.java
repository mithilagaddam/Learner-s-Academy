package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/report")
public class View extends HttpServlet {
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
		sendClass(response);
	}


	private void sendClass(HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Class Report</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		out.println("<BR>Enter Class from 1 to 10 inorder to view the report<BR><BR>");
		out.println("<FORM METHOD=POST>");
		out.println("<INPUT TYPE=TEXT NAME=class>	<INPUT TYPE=SUBMIT>");
		out.println("<BR>");
		out.println("<BR>");
		out.println("</FORM>");
		out.println("</CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String num=request.getParameter("class");
		PrintWriter out=response.getWriter();
		String sql1="SELECT student FROM STUDENTCLASS WHERE CLASS='class-"+num+"'";
		String sql2="SELECT teacher,subject FROM CLASSES WHERE CLASS='class-"+num+"'";
		try {
			String url="jdbc:mysql://localhost:3306/teksystem?useSSL=false";
			String user="root";
			String pass="anshula";

			//step-2 obtain a connection
			Connection connection=DriverManager.getConnection(url, user, pass);
			System.out.println("got connection");
			
			Statement s=connection.createStatement();
			ResultSet rs=s.executeQuery(sql1);
			out.println("<B>Student List of Class-"+num+"</B><BR>");
			while(rs.next()) {
				out.println("<TR>"+rs.getString(1)+"</TR><BR>");	
			}
			rs=s.executeQuery(sql2);
			out.println("<BR><B>Teachers along with their Subjects in Class-"+num+"</B><BR>");
			//out.println("<TR>Teacher	Subject</TR><BR>");
			while(rs.next()) {
				out.println("<TR>"+rs.getString(1)+" ---> "+rs.getNString(2)+"</TR><BR>");	
				
			}
			rs.close();
			s.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
