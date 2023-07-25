package com.assignment.utils;

import com.assignment.model.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtils {
	
	/**
	 * Phương thức lưu Cookied
	 * @param request 
	 * @param response
	 * @param nameCookie nhập vào tên của cookied
	 * @param email 
	 * @param password
	 * @param hours nhập thời gian cookied sống
	 */
	public static void setLoginCookie(HttpServletRequest request, HttpServletResponse response, String nameCookie,
			String email, String password, int hours) {
		// Tạo đối tượng cookie
		Cookie loginCookie = new Cookie(nameCookie, email + ":" + password);
		// Đặt thời gian sống của cookie
		loginCookie.setMaxAge(hours);
		// Thêm cookie vào response
		response.addCookie(loginCookie);
	}

	/**
	 * Lấy thông tin Cookied
	 * @param request
	 * @param nameCookie
	 * @return trả về thông tin cookied
	 */
	public static String[] getLoginCookie(HttpServletRequest request, String nameCookie) {
		String[] loginInfo = null;
		// Lấy danh sách cookie từ request
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(nameCookie)) {
					// Tách email và password từ giá trị của cookie
					String value = cookie.getValue();
					loginInfo = value.split(":");
					break;
				}
			}
		}
		return loginInfo;
	}

	/**
	 * Xóa thông tin Cookied
	 * @param response
	 * @param nameCookie
	 */
	public static void removeLoginCookie(HttpServletResponse response, String nameCookie) {
		// Tạo cookie mới với cùng tên và thời gian sống = 0 để xóa cookie cũ
		Cookie loginCookie = new Cookie(nameCookie, null);
		loginCookie.setMaxAge(0);
		response.addCookie(loginCookie);

	}
}
