package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<CENTER>");
		out.println("<BR><H2>Select any operation to do below</H2><BR>");
		out.println("<A HREF='http://localhost:8081/Learners-Acadamy/subjects'>List of Subjects</A><BR>");
		out.println("<A HREF='http://localhost:8081/Learners-Acadamy/teachers'>List of Teachers</A><BR>");
		out.println("<A HREF='http://localhost:8081/Learners-Acadamy/classes'>List of Classes</A><BR>");
		out.println("<A HREF='http://localhost:8081/Learners-Acadamy/assign'>Assign subjects, teachers to classes</A><BR>");
		out.println("<A HREF='http://localhost:8081/Learners-Acadamy/students'>Get list of students</A><BR>");
		out.println("<A HREF='http://localhost:8081/Learners-Acadamy/report'>View Class Report</A>");
		out.println("</CENTER>");
        out.println("</HTML>");
		out.println("</BODY>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
