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

@WebServlet("/subjects")
public class SetSubjects extends HttpServlet {
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
		out.println("<TITLE>Display Subjects</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		out.println("<BR><H2>Displaying Subjects</H2>");
		out.println("<BR>");
		out.println("<BR>");
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("</TR>");
		String sql="SELECT DISTINCT subject FROM classes";
		try {
			String url="jdbc:mysql://localhost:3306/teksystem?useSSL=false";
			String user="root";
			String pass="anshula";

			//step-2 obtain a connection
			Connection connection=DriverManager.getConnection(url, user, pass);
			System.out.println("got connection");
			
			Statement s=connection.createStatement();
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()) {
				out.println("<BR><TR>"+rs.getString(1)+"</TR>");
				
			}
			rs.close();
			s.close();
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		out.println("</TABLE>");
		out.println("</CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
