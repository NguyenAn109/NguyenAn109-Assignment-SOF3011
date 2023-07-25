<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Kích hoạt tài khoản</title>
</head>
<body>
	<h2>Xin chào,</h2>
	<form action="active-account" method="post">
		<p>Cảm ơn bạn đã đăng ký tài khoản. Để hoàn tất quá trình đăng ký,
			vui lòng nhấp vào nút bên dưới để kích hoạt tài khoản của bạn:</p>

		<!-- Điền đường dẫn tới file JSP kích hoạt tài khoản vào thuộc tính "href" của thẻ "a" -->
		<button><a href="${ activationLink }"
			style="background-color: #4CAF50; color: white; padding: 14px 20px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer;">Kích
			hoạt tài khoản</a></button>

		<p>Nếu bạn không yêu cầu kích hoạt tài khoản này, vui lòng bỏ qua
			email này.</p>
		<p>Trân trọng,</p>
		<p>Đội ngũ hỗ trợ của chúng tôi</p>
	</form>
</body>
</html>