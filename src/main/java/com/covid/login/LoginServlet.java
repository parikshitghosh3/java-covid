package com.covid.login;

//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		// request.setAttribute("email", request.getParameter("email"));
		// request.setAttribute("password", request.getParameter("password"));

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String email = request.getParameter("email");
		String passw = request.getParameter("password");
		request.setAttribute("email", email);
		request.setAttribute("password", passw);

		JDBC_connect.add(email, passw);
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
	}
}
