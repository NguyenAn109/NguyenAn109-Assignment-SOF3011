package com.assignment.utils;

import javax.mail.*;
import javax.mail.internet.*;

import jakarta.servlet.ServletContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;

public class SendEmailUtils {

	/**
	 * Phương thức gửi gmail
	 * @param toEmail email người nhận
	 * @param content nội dung của email
	 */
	public static void sendActivationEmail(String toEmail, String content) {
		// Cấu hình thông tin email
		String fromEmail = "anntpc04830@fpt.edu.vn";
		String host = "smtp.gmail.com";
		String port = "587";
		
		String username = "anntpc04830@fpt.edu.vn";
		String password = "dwohkswmwqkvbazj";

		// Tạo đối tượng Properties và cấu hình thông tin email
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		// Tạo đối tượng Session để gửi email
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Tạo đối tượng MimeMessage và cấu hình thông tin email
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("Xác thực tài khoản");

			// Thiết lập nội dung email là mã HTML từ activationAccountContent
			message.setContent(content, "text/html; charset=utf-8");

			// Gửi email
			Transport.send(message);

			System.out.println("Gửi email thành công!");
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Gửi email thất bại!");
		}
	}

	/**
	 * Phương thức đọc jsp sang String
	 * @param filePath đường dẫn dẫn tới file jsp
	 * @return trả về dữ liệu đã được chuyển đổi
	 */
	public static String readJspFileToString(String filePath) {
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringBuilder.toString();
	}

	

}
