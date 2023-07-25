<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.assignment.utils.SessionUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<!-- vendor css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/remixicon/fonts/remixicon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/boxicons/css/boxicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/aos/css/aos.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/swiper/css/swiper-bundle.min.css" />
<!-- main css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css" />
</head>

<body>
	<div class="container">

		<!-- include nav -->
		<%@ include file="layer/nav.jsp"%>

		<!-- include banner -->
		<%@ include file="layer/banner.jsp"%>

		<!-- include category-movie -->
		<%@ include file="doashboad/category_movie.jsp"%>

		<!-- include new-releases -->
		<%@ include file="doashboad/new_releases.jsp"%>

		<!-- include new-releases -->
		<%@ include file="doashboad/sports.jsp"%>

		<!-- include new-releases -->
		<%@ include file="doashboad/anime.jsp"%>

		<!-- include persional-channel -->
		<%@ include file="doashboad/personal_channels.jsp"%>

		<!-- include persional-channel -->
		<%@ include file="doashboad/in_theaters.jsp"%>

		<!-- include persional-channel -->
		<%@ include file="doashboad/podcast.jsp"%>

		<!-- include persional-channel -->
		<%@ include file="layer/footer.jsp"%>
	</div>
</body>
<!-- Thêm thư viện jQuery, Bootstrap và SwiperJS -->
<script
	src="${pageContext.request.contextPath}/assets/vendor/jquery/js/jquery.js"></script>
<!-- vendor js -->
<script
	src="${pageContext.request.contextPath}/assets/vendor/swiper/js/swiper-bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/vendor/aos/js/aos.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/vendor/sweetalert2/js/sweetalert2.all.min.js"></script>

<!-- main js -->
<script src="${pageContext.request.contextPath}/assets/js/alert.js"></script>
<script
	src="${pageContext.request.contextPath}/assets/js/SwiperAnimation.js">
</script>

</html>