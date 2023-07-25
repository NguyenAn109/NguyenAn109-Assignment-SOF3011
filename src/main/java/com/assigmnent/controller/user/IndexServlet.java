package com.assigmnent.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.assignment.utils.SecurityUtils;
import com.assignment.utils.SessionUtils;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("views/user/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nameSession = "loggedInUser";

		// Nếu người dùng nhấn logout
		boolean logout = false;
		logout = Boolean.valueOf(SecurityUtils.cleanInput(request.getParameter("logout")));
		if (logout) {
			SessionUtils.removeAttribute(request, nameSession);
			request.getRequestDispatcher("views/user/index.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("views/user/index.jsp").forward(request, response);
	}

}
