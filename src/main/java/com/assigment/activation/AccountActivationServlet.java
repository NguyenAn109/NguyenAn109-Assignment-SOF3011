package com.assigment.activation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.assignment.model.User;
import com.assignment.utils.SessionUtils;

/**
 * Servlet implementation class AccountActivationServlet
 */
@WebServlet("/activation-account")
public class AccountActivationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountActivationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Servlet implementation class ActivationConfirmServlet
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) SessionUtils.getAttribute(request, "userSession");
		
		// Lấy thông tin từ URL (user và token đã mã hóa)
		String encodedUserId = request.getParameter("user");
		String encodedToken = request.getParameter("token");

		// Giải mã thông tin người dùng và token từ Base64
		String userId = new String(Base64.getUrlDecoder().decode(encodedUserId), StandardCharsets.UTF_8);
		String token = new String(Base64.getUrlDecoder().decode(encodedToken), StandardCharsets.UTF_8);

		// Nếu thông tin hợp lệ và token đúng, cập nhật trạng thái tài khoản thành true
		if (isValidToken(userId, token, user.getId())) {

			// Thực hiện cập nhật trạng thái tài khoản
			System.out.println(user.isStatus());
			user.setStatus(true);
			System.out.println(user.isStatus());

			// Gửi thông báo kích hoạt thành công

			System.out.println("Active thành công");
			response.sendRedirect("index");
		} else {
			// Gửi thông báo lỗi nếu token không hợp lệ
			System.out.println("Active thất bại, Đường dẫn không hợp lệ");
			request.getRequestDispatcher("views/user/gmail/activateAccount.jsp").forward(request, response);
		}


	}

	private boolean isValidToken(String userId, String token, String id) {
		return id.equals(userId) && token.equals(token);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
