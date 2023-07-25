package com.assignment.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class SessionUtils {
	/**
	 * Lưu thông tin và session
	 * @param request Yêu cầu từ người dùng
	 * @param attributeName Tên session
	 * @param attributeValue email người dùng
	 */
    public static void setAttribute(HttpServletRequest request, String attributeName, Object attributeValue) {
        HttpSession session = request.getSession();
        session.setAttribute(attributeName, attributeValue);
    }

    /**
     * Lấy thông tin từ session
     * @param request
     * @param attributeName
     * @return trả về tên người dùng
     */
    public static Object getAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession();
        return session.getAttribute(attributeName);
    }

    /**
     * Cập nhật thông tin session
     * @param request 
     * @param attributeName (tên session)
     * @param attributeValue
     */
    public static void updateAttribute(HttpServletRequest request, String attributeName, Object attributeValue) {
        HttpSession session = request.getSession();
        session.setAttribute(attributeName, attributeValue);
    }

    /**
     * Xóa thông tin của session
     * @param request
     * @param attributeName
     */
    public static void removeAttribute(HttpServletRequest request, String attributeName) {
        HttpSession session = request.getSession();
        session.removeAttribute(attributeName);
    }

    /**
     * Xóa toàn bộ dữ liệu trong session
     * @param request
     */
    public static void invalidateSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
}
