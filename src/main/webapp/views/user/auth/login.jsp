<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Đăng kí</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<!-- vendor css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
<!-- main css -->
<link rel="stylesheet"
	href="/Anntpc04830_SOF3011_Assignment/assets/css/login.css" />
</head>

<body>
	<section id="login">
		<div class="opacity"></div>
		<div class="container">
			<div class="form">
				<form action="login" method="post">
					<h2 class="text-center mb-5">Đăng nhập</h2>
					<div class="mb-3">
						<input type="text" class="form-control" id="exampleInputText1"
							aria-describedby="textHelp" name="email"
							placeholder="name@example.com">
						<div id="textHelp" class="form-text text-danger">${ errorEmail }</div>
					</div>
					<div class="mb-3">
						<input type="password" placeholder="********" class="form-control"
							id="exampleInputPassword1" aria-describedby="passwordHelp"
							name="password">
						<div id="passwordHelp" class="form-text text-danger">${ errorPassword }</div>
					</div>
					<div class="mb-3">
						<div class="d-flex justify-content-between align-items-center">
							<div class="form-check float-start">
								<input class="form-check-input" type="checkbox" value="true"
									id=""> <label class="form-check-label" for=""
									name=chkRememberme"> Nhớ tài khoản </label>
							</div>
							<div class="reset-password float-end">
								<a class="btn text-white" href="reset-password">Quên mật
									khẩu</a>
							</div>
						</div>
					</div>
					<div class="mb-3 text-center w-100">
						<button class="btn-login btn text-white" type="submit"
							style="color: #aaa;">Đăng nhập</button>
					</div>
					<div class="mb-3 text-center">Hoặc đăng nhập bằng</div>
					<div class="mb-3 text-center">
						<div class="google ">
							<a
								href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:13505/Anntpc04830_SOF3011_Assignment/LoginServlet&response_type=code
    &client_id=34049186802-dfv88igd2olkpauj0lsravs01tiqlq9e.apps.googleusercontent.com&approval_prompt=force"
								class="p-3"> <img
								src="${pageContext.request.contextPath}/assets/img/icon/google-icon.png"
								alt="" style="width: 30px;">
							</a>
						</div>
					</div>
					<div class="mb-3 text-center">
						<p>
							Chưa có tài khoản? <a class="sign-up" href="sign-up">Đăng kí
								miễn phí</a>
						</p>
					</div>
				</form>
			</div>
		</div>

	</section>
</body>
<!-- vendor js -->
<script
	src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</html>