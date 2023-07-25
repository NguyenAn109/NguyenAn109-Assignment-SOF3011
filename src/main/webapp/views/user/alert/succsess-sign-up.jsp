<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css">
<!-- main css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/alert.css" />
<script
	src="${pageContext.request.contextPath}/assets/vendor/sweetalert2/js/sweetalert2.all.min.js"></script>
</head>
<body>
	<script>
	function handleOkeButton() {
		// Lấy dữ liệu cần post lên servlet
		var data = isStatusNotiffication: true
      // Thêm các dữ liệu cần post lên servlet vào đây
    };

    // Gửi dữ liệu lên servlet bằng AJAX
    var ajaxLibrary = jQuery.noConflict();

ajaxLibrary.ajax({
    type: "POST",
    url: "sign-up", // Thay bằng URL của servlet của bạn
    data: data,
    // Thêm các thiết lập ajax khác nếu cần
});

	Swal.fire({
		  icon: 'success',
		  title: 'Đăng kí thành công!',
		  text: 'Vui lòng kiểm tra gmail để xác thực tài khoản',
		}).then((result) => {
		    // Xử lý khi nhấn nút "oke"
		    if (result.isConfirmed) {
		      handleOkeButton();
		    }
		
	</script>
</body>
<script
	src="${pageContext.request.contextPath}/assets/vendor/jquery/js/jquery.js"></script>
</html>