package com.assignment.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.owasp.encoder.Encode;

public class SecurityUtils {
	private static String Token = "";
	/**
	 * Phương thức mã hóa dữ liệu
	 * 
	 * @param plainPassword
	 * @return trả về đoạn dữ liệu đã được mã hóa
	 */
	public static String hashPassword(String plainPassword) {
		String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
		return hashedPassword;
	}

	/**
	 * Phương thức kiểm tra dữ liệu mã hnóa có khớp không
	 * 
	 * @param plainPassword
	 * @param hashedPassword
	 * @return
	 */
	public static boolean verifyPassword(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}

	/**
	 * Làm sạch dữ liệu, kiểm tra lỗi bảo mật XSS
	 * 
	 * @param input
	 * @return (Dữ liệu đã được làm sạch)
	 */
	public static String cleanInput(String input) {
		return Encode.forHtml(input);
	}

	/**
	 * Tạo đường dẫn kích hoạt tài khoản
	 * @param userId
	 * @return trả về đường dẫn chưa token và userId đã được mã hóa
	 */
	public static String generateActivationLink(String userId) {
		// Tạo một chuỗi ngẫu nhiên để mã hóa vào URL
		String activationToken = UUID.randomUUID().toString();
		Token = activationToken;
		// Mã hóa userId và activationToken vào URL-safe Base64
		String encodedUserId = Base64.getUrlEncoder().encodeToString(userId.getBytes(StandardCharsets.UTF_8));
		String encodedToken = Base64.getUrlEncoder().encodeToString(activationToken.getBytes(StandardCharsets.UTF_8));

		// Xây dựng URL kích hoạt tài khoản
		String activationLink = "http://localhost:13505/Anntpc04830_SOF3011_Assignment/AccountActivationServlet?user=" + encodedUserId + "&token=" + encodedToken;

		return activationLink;
	}
	
	/**
	 * Phương thức mã hóa dữ liệu
	 * @param data
	 * @return
	 */
	public static String encode(String data) {
        byte[] encodedBytes = Base64.getEncoder().encode(data.getBytes(StandardCharsets.UTF_8));
        return new String(encodedBytes, StandardCharsets.UTF_8);
    }

	/**
	 * Phương thức giải mã dữ liệu
	 * @param encodedData
	 * @return
	 */
    public static String decode(String encodedData) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedData.getBytes(StandardCharsets.UTF_8));
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
	

}
