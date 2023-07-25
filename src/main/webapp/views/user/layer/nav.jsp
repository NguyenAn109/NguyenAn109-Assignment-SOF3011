<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<nav id="nav">
			<div class="container w-100">
				<nav class="navbar navbar-expand-xxl">
					<div class="container-fluid">
						<a class="navbar-brand" href="index"><img
								src="${pageContext.request.contextPath}/assets/img/logo/logo.png" class="img-fluid w-80"
								alt="..."> </a>
						<button class="navbar-toggler text-white" type="button" data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
							aria-expanded="false" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon" style="color: #fff;"><i
									class='fs-3 bx bx-menu'></i></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item"><a class="nav-link active text-white" aria-current="page"
										href="#">Trang chủ</a></li>
								<li class="nav-item"><a class="nav-link text-white" href="#">Truyền
										hình</a></li>
								<li class="nav-item"><a class="nav-link text-white" href="#">Phim
										hot</a></li>
								<li class="nav-item"><a class="nav-link text-white" href="#">Thể
										thao</a></li>
								<li class="nav-item"><a class="nav-link text-white" href="#">Giải
										trí</a></li>
								<li>
									<div class="dropdown text-white" style="z-index: 100;">
										<button class="btn dropdown-toggle text-white" type="button"
											data-bs-toggle="dropdown" aria-expanded="false">Xem
											thêm</button>
										<ul class="dropdown-menu dropdown-menu-dark">
											<li><a class="dropdown-item text-white" href="#">Trực
													tiếp</a></li>
											<li><a class="dropdown-item text-white" href="#">Anime</a></li>
											<li><a class="dropdown-item text-white" href="#">Âm
													nhạc</a></li>
											<li><a class="dropdown-item text-white" href="#">Phim
													lẻ</a></li>
											<li><a class="dropdown-item text-white" href="#">Học
													tập</a></li>
											<li><a class="dropdown-item text-white" href="#">Giải
													trí</a></li>
										</ul>
									</div>
								</li>
							</ul>
							<form class="d-flex" role="search">
								<input type="text" class="form-control text-black" name="" placeholder="Tìm kiếm phim">
								<button type="submit" class="btn">
									<i class='bx bx-search text-white'></i>
								</button>
							</form>
							<form action="index" method="post">
								<div class="dropdown">
									<c:choose>
										<c:when test="${loggedIn == true}">
											<div class="dropdown">
												<button class="btn dropdown-toggle text-white" type="button"
													data-bs-toggle="dropdown" aria-expanded="false">
													<i class='bx bx-user'></i>
												</button>
												<ul class="dropdown-menu">
													<li><a class="dropdown-item" href="my-info">Thông
															tin của tôi</a></li>
													<li><button class="dropdown-item" value="true" type="submit"
															name="logout">Đăng xuất</button></li>
												</ul>
											</div>
										</c:when>
										<c:otherwise>
											<a href="login" class="btn text-white">Đăng nhập</a>
										</c:otherwise>
									</c:choose>
								</div>
							</form>
						</div>
					</div>
				</nav>
			</div>
		</nav>

		