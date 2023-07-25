package com.assigmnent.controller.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.assignment.utils.*;
import com.assignment.utils.validation.ValidationFormLoginUtils;
import com.assignment.assessgoogle.common.*;
import com.assignment.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Kiểm tra người dùng đăng nhập bằng google
		String code = request.getParameter("code");
		if (code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("views/user/auth/login.jsp");
			dis.forward(request, response);
		} else {
			String accessToken = GoogleUtils.getToken(code);
			GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
			request.setAttribute("id", googlePojo.getId());
			request.setAttribute("name", googlePojo.getName());
			request.setAttribute("email", googlePojo.getEmail());
			RequestDispatcher dis = request.getRequestDispatcher("index");
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lấy dữ liệu User từ Session
		User user = (User) SessionUtils.getAttribute(request, "userSession");
		
		System.out.println(user.getEmail() + " " + SecurityUtils.decode(user.getPassword()));
		String email = SecurityUtils.cleanInput(request.getParameter("email"));
		String password = SecurityUtils.cleanInput(request.getParameter("password"));
		String emailData = user.getEmail();
		String passwordData = SecurityUtils.decode(user.getPassword());
		boolean statusData = user.isStatus();
		String chkRememberme = request.getParameter("chkRememberme");
		String nameCookie = "loginCookie";
		String nameSession = "loggedInUser";

		// Kiểm tra các trường dữ liệu có hợp lệ không
		if (!hasValidationEmailForm(email, request)
				&& !hasValidationPasswordForm(email, password, emailData, passwordData, request, statusData)) {

			// Kiểm tra có nhấn lưu mật khẩu không
			if (chkRememberme != null && chkRememberme.equals("true")) {

				// Mã hóa thông tin email và mật khẩu
				String checkhedEmail = SecurityUtils.hashPassword(email);
				String checkhedPassword = SecurityUtils.hashPassword(password);

				// Lưu checkhedPassword vào Cookie
				CookieUtils.setLoginCookie(request, response, nameCookie, checkhedEmail, checkhedPassword, 60);

			}
			// Lưu tên người dùng vào session
			SessionUtils.setAttribute(request, nameSession, "Nguyễn An");

			response.sendRedirect("index");
		} else {
			hasValidationEmailForm(email, request);
			hasValidationPasswordForm(email, password, emailData, passwordData, request, statusData);
			request.getRequestDispatcher("views/user/auth/login.jsp").forward(request, response);
		}
	}

	/**
	 * Phương thức kiểm tra email
	 * 
	 * @param email     (email mà người dùng nhập trên form)
	 * @param emailData (Dữ liệu trong database)
	 * @param request
	 * @return trả về mã lỗi
	 */
	private boolean hasValidationEmailForm(String email, HttpServletRequest request) {
		if (ValidationFormLoginUtils.checkEmptyEmailFields(email) != null) {
			request.setAttribute("errorEmail", ValidationFormLoginUtils.checkEmptyEmailFields(email));
			return true;
		} else if (ValidationFormLoginUtils.checkInvalidEmailCharacters(email) != null) {
			request.setAttribute("errorEmail", ValidationFormLoginUtils.checkInvalidEmailCharacters(email));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Phương thức kiểm tra mật khẩu
	 * 
	 * @param email        (Email mà người dùng nhập trên form)
	 * @param password     (Mật khẩu mà người dùng nhập trên form)
	 * @param emailData    (Dữ liệu email trong database)
	 * @param passwordData (Dữ liệu password trong database)
	 * @param request
	 * @return
	 */
	private boolean hasValidationPasswordForm(String email, String password, String emailData, String passwordData,
			HttpServletRequest request, boolean status) {
		if (ValidationFormLoginUtils.checkEmptyPasswordFields(password) != null) {
			request.setAttribute("errorPassword", ValidationFormLoginUtils.checkEmptyPasswordFields(password));
			return true;
		} else if (ValidationFormLoginUtils.checkInvalidPasswordCharacters(password) != null) {
			request.setAttribute("errorPassword", ValidationFormLoginUtils.checkInvalidPasswordCharacters(password));
			return true;
		}else if (ValidationFormLoginUtils.checkAccountDoesNotExist(email, password, emailData,
				passwordData) != null) {
			request.setAttribute("errorPassword",
					ValidationFormLoginUtils.checkAccountDoesNotExist(email, password, emailData, passwordData));
			return true;
		}  else if (ValidationFormLoginUtils.checkActiveAccount(status) != null) {
			request.setAttribute("errorPassword", ValidationFormLoginUtils.checkActiveAccount(status));
			return true;
		} else {
			return false;
		}
		

	}

}
