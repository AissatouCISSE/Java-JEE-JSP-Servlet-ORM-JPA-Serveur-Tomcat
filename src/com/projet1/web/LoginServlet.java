package com.projet1.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet1.dao.IUser;
import com.projet1.dao.UserImpl;
import com.projet1.entities.User;



/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUser iuser;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		iuser = new UserImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
				
		User user = iuser.getLogin(email,password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("prenom", user.getPrenom());
			session.setAttribute("id", user.getId());
			/*
			 * response.sendRedirect("index.jsp"); doGet(request, response);
			 */
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
		else {
			
			response.sendRedirect("login");
		}
	}

}