<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Đăng nhập</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	</head>
	<!-- vendor css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
	<!-- main css -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/sign-up.css" />
	</head>

	<body>
		<section id="login">
			<div class="opacity"></div>
			<div class="container">
				<div class="form">
					<form action="sign-up" method="post">
						<h2 class="text-center mb-4">Đăng kí</h2>
						<div class="mb-3">
							<div class="row align-items-center g-2">
								<div class="col">
									<input type="text" class="form-control" id="exampleInputText1"
										aria-describedby="textHelp" name="lastname" placeholder="Họ">
								</div>
								<div class="col">
									<input type="text" class="form-control" id="exampleInputText1"
										aria-describedby="textHelp" name="fristname" placeholder="Tên">
								</div>
								<div id="textHelp" class="form-text text-danger">${ errorFullname }</div>
							</div>

						</div>
						<div class="mb-3">
							<input type="text" class="form-control" id="exampleInputText1" aria-describedby="textHelp"
								name="email" placeholder="name@example.com">
							<div id="textHelp" class="form-text text-danger">${ errorEmail }</div>
						</div>
						<div class="mb-3">
							<input type="password" placeholder="Mật khẩu" class="form-control"
								id="exampleInputPassword1" aria-describedby="passwordHelp" name="password">
							<div id="passwordHelp" class="form-text text-danger">${ errorPassword }</div>
						</div>
						<div class="mb-3">
							<input type="password" placeholder="Nhập lại mật khẩu" class="form-control"
								id="exampleInputPassword1" aria-describedby="passwordHelp" name="repeatPassword">
							<div id="passwordHelp" class="form-text text-danger">${ errorRepeatPassword }</div>
						</div>
						<div class="mb-3">
							<div class="d-flex justify-content-between align-items-center">
								<div class="text-center text-center w-100">
									<label class="form-check-label text-center w-100" for="">Bằng
										việc bấm đăng kí, bạn đã xem, hiểu và đồng ý với </label>
									<p class="text-center w-100">
										<a class="sign-up sign-up" href="https://docs.google.com/document/d/1jFMEn9Z-32OPlRYgxD7h0MrWaEc2taEV7Gi2YMH9wOk/edit?usp=sharing
								">Điều
											khoản và điều kiện sử dụng FPL Play</a>
									</p>
								</div>
							</div>
						</div>
						<div class="mb-3 text-center w-100">
							<button class="btn-login btn text-white" type="submit" style="color: #aaa;">Đăng kí</button>
						</div>
						<div class="mb-3 text-center">Hoặc đăng nhập bằng</div>
						<div class="mb-3 text-center">
							<div class="google ">
								<a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:13505/Anntpc04830_SOF3011_Assignment/LoginServlet&response_type=code
    &client_id=34049186802-dfv88igd2olkpauj0lsravs01tiqlq9e.apps.googleusercontent.com&approval_prompt=force"
									class="p-3"> <img
										src="${pageContext.request.contextPath}/assets/img/icon/google-icon.png" alt=""
										style="width: 30px;">
								</a>
							</div>
						</div>
						<div class="mb-3 text-center">
							<p>
								Đã có tài khoản? <a class="sign-up" href="sign-up">Đăng nhập</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</section>

	</body>
	<!-- vendor js -->
	<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
	src="${pageContext.request.contextPath}/assets/vendor/jquery/js/jquery.js"></script>
	<script
	src="${pageContext.request.contextPath}/assets/vendor/sweetalert2/js/sweetalert2.all.min.js"></script>

	</html>