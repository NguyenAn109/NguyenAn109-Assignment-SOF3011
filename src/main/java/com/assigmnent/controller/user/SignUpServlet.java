package com.assigmnent.controller.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.assignment.assessgoogle.common.GooglePojo;
import com.assignment.model.User;
import com.assignment.utils.CookieUtils;
import com.assignment.utils.GoogleUtils;
import com.assignment.utils.SecurityUtils;
import com.assignment.utils.SendEmailUtils;
import com.assignment.utils.SessionUtils;
import com.assignment.utils.validation.ValidationFormSignUpUtils;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user = new User();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
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
			RequestDispatcher dis = request.getRequestDispatcher("views/user/auth/sign-up.jsp");
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
		String userIdData = "KH000001";
		String emailData = "Ann1131909@gmail.com";

		String fristname = SecurityUtils.cleanInput(request.getParameter("fristname"));
		String lastname = SecurityUtils.cleanInput(request.getParameter("lastname"));
		String fullname = SecurityUtils.cleanInput(lastname + " " + fristname);
		String email = SecurityUtils.cleanInput(request.getParameter("email"));
		String password = SecurityUtils.cleanInput(request.getParameter("password"));
		String repeatPassword = SecurityUtils.cleanInput(request.getParameter("repeatPassword"));

		String chkRememberme = request.getParameter("chkRememberme");
		String nameCookie = "loginCookie";
		String userSession = "userSession";
		// Validate form nhập
		if (!hasValidationFullnameFrom(request, fristname, lastname) && !hasValidationEmailForm(email, request)
				&& !hasValidationPasswordForm(email, password, request)
				&& !hasValidationRepacePasswordFrom(request, password, repeatPassword, email, "Ann1131909@gmail")) {

			// Mã hóa thông tin email và mật khẩu
			String checkhedEmail = SecurityUtils.hashPassword(email);
			String checkhedPassword = SecurityUtils.hashPassword(password);

			// Nếu người dùng lưu mật khẩu
			if (chkRememberme != null && chkRememberme.equals("true")) {

				// Lưu checkhedPassword vào Cookie
				CookieUtils.setLoginCookie(request, response, nameCookie, checkhedEmail, checkhedPassword, 60);

			}
			// Nếu tạo tài khoản thành công thì gán dữ liệu vào entity
			String encodePassword = SecurityUtils.encode(password);
			User user = new User(userIdData, fristname, email, encodePassword, false, "", "", "");

			// Thêm user vào session
			SessionUtils.setAttribute(request, userSession, user);

			System.out.println(user.getFullname() + " " + user.getEmail() + " " + user.getPassword() + " "
					+ user.isStatus() + " " + user.getId());

			// Gửi gmail kích hoạt tài khoản

			// Nội dung gmail
			String name = "Xác thực tài khoản";
			String subject = "Xác thực tài khoản";
			String recipientEmail = user.getEmail();

			// Tạo đường dẫn kích hoạt tài khoản
			String activationLink = SecurityUtils.generateActivationLink(userIdData);
			System.out.println(activationLink);
			request.setAttribute("activationLink", activationLink);

			// Gửi email chứa mã xác thực tới địa chỉ email của người dùng
			SendEmailUtils.sendActivationEmail(user.getEmail(), activeAcountContent(activationLink));

			// Chuyển hướng người dùng đến trang thông báo thành công
			response.sendRedirect("index");
		} else {
			hasValidationFullnameFrom(request, fristname, lastname);
			hasValidationEmailForm(email, request);
			hasValidationPasswordForm(email, password, request);
			hasValidationRepacePasswordFrom(request, password, repeatPassword, email, "Ann1131909@gmail");
			request.getRequestDispatcher("views/user/auth/sign-up.jsp").forward(request, response);
		}
	}

	/**
	 * Phương thức bắt lỗi tên
	 * 
	 * @param request
	 * @param fristname
	 * @param lastname
	 * @return
	 */
	private boolean hasValidationFullnameFrom(HttpServletRequest request, String fristname, String lastname) {
		if (ValidationFormSignUpUtils.checkEmptyNameFields(fristname, lastname) != null) {
			request.setAttribute("errorFullname", ValidationFormSignUpUtils.checkEmptyNameFields(fristname, lastname));
			return true;
		} else if (ValidationFormSignUpUtils.checkValidLastName(lastname) != null) {
			request.setAttribute("errorFullname", ValidationFormSignUpUtils.checkValidLastName(lastname));
			return true;
		} else if (ValidationFormSignUpUtils.checkValidLastName(fristname) != null) {
			request.setAttribute("errorFullname", ValidationFormSignUpUtils.checkValidLastName(lastname));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Phương thức bắt lỗi email
	 * 
	 * @param email
	 * @param request
	 * @return
	 */
	private boolean hasValidationEmailForm(String email, HttpServletRequest request) {
		if (ValidationFormSignUpUtils.checkEmptyEmailFields(email) != null) {
			request.setAttribute("errorEmail", ValidationFormSignUpUtils.checkEmptyEmailFields(email));
			return true;
		} else if (ValidationFormSignUpUtils.checkInvalidEmailCharacters(email) != null) {
			request.setAttribute("errorEmail", ValidationFormSignUpUtils.checkInvalidEmailCharacters(email));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Phương thức bắt lỗi password
	 * 
	 * @param email
	 * @param password
	 * @param emailData
	 * @param passwordData
	 * @param request
	 * @return
	 */
	private boolean hasValidationPasswordForm(String email, String password, HttpServletRequest request) {
		if (ValidationFormSignUpUtils.checkEmptyPasswordFields(password) != null) {
			request.setAttribute("errorPassword", ValidationFormSignUpUtils.checkEmptyPasswordFields(password));
			return true;
		} else if (ValidationFormSignUpUtils.checkInvalidPasswordCharacters(password) != null) {
			request.setAttribute("errorPassword", ValidationFormSignUpUtils.checkInvalidPasswordCharacters(password));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Phương thức bắt lỗi mật khẩu nhập lại
	 * 
	 * @param request
	 * @param password
	 * @param repeatPassword
	 * @return
	 */
	private boolean hasValidationRepacePasswordFrom(HttpServletRequest request, String password, String repeatPassword,
			String email, String emailData) {
		if (ValidationFormSignUpUtils.checkEmptyReplacePasswordFields(repeatPassword) != null) {
			request.setAttribute("errorRepeatPassword",
					ValidationFormSignUpUtils.checkEmptyReplacePasswordFields(repeatPassword));
			return true;
		} else if (ValidationFormSignUpUtils.checkPasswordMatch(repeatPassword, password) != null) {
			request.setAttribute("errorRepeatPassword",
					ValidationFormSignUpUtils.checkPasswordMatch(repeatPassword, password));
			return true;
		} else if (ValidationFormSignUpUtils.checkEmailAlreadyExists(email, emailData) != null) {
			request.setAttribute("errorRepeatPassword", ValidationFormSignUpUtils.checkEmailAlreadyExists(email, ""));
			return true;
		} else {
			return false;
		}
	}

	private String activeAcountContent(String activationLink) {
		return  "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n"
				+ "<title>Kích hoạt tài khoản</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "	<h2>Xin chào,</h2>\r\n"
				+ "	<form action=\"sign-up\" method=\"post\">\r\n"
				+ "		<p>Cảm ơn bạn đã đăng ký tài khoản. Để hoàn tất quá trình đăng ký,\r\n"
				+ "			vui lòng nhấp vào nút bên dưới để kích hoạt tài khoản của bạn:</p>\r\n" + "\r\n"
				+ "		<!-- Điền đường dẫn tới file JSP kích hoạt tài khoản vào thuộc tính \"href\" của thẻ \"a\" -->\r\n"
				+ "		<button><a href=\"" + activationLink + "\"\r\n"
				+ "			style=\"background-color: #4CAF50; color: white; padding: 14px 20px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer;\">Kích\r\n"
				+ "			hoạt tài khoản</a></button>\r\n" + "\r\n"
				+ "		<p>Nếu bạn không yêu cầu kích hoạt tài khoản này, vui lòng bỏ qua\r\n"
				+ "			email này.</p>\r\n" + "		<p>Trân trọng,</p>\r\n"
				+ "		<p>Đội ngũ hỗ trợ của chúng tôi</p>\r\n" + "	</form>\r\n" + "</body>\r\n" + "</html>";
	}
}
