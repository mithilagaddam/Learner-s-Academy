package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sendLogin(response,false);
	}

	private void sendLogin(HttpServletResponse response, boolean withErrorMessage) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Login</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		if(withErrorMessage) {
			out.println("Login Failed!,Please try again later");
		}
		out.println("<BR>");
		out.println("<BR><H2>Login Page</H2>");
		out.println("<BR>");
		out.println("<BR><FORM METHOD=POST");
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("<TD>User Name : </TD>");
		out.println("<TD><INPUT TYPE=TEXT NAME=userName></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>Password : </TD>");
		out.println("<TD><INPUT TYPE=PASSWORD NAME=password></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD ALIGN=RIGHT COLSPAN=2>");
		out.println("<INPUT TYPE=SUBMIT VALUE=Login></TD>");
		out.println("</TR>");
		out.println("</TABLE>");
		out.println("</FORM>");
		out.println("</CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		//if(login(userName,password)) 
		if(userName.equalsIgnoreCase("Mithila") && password.equalsIgnoreCase("mithila")) {
			 response.sendRedirect("http://localhost:8081/Learners-Acadamy/welcome");
		}else {
			sendLogin(response,true);
		}
	}

}
