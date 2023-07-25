package com.assignment.utils.validation;


import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.EmailValidator;

public class ValidationFormLoginUtils {
	String errorMessenger = null;
	
	/**
	 * Phương thức kiểm tra email rỗng
	 * @param email
	 * @return 
	 */
    public static String checkEmptyEmailFields(String email) {
    	if(email.isEmpty()) {
    		return "Không được bỏ trống tài khoản";
    	}else {
    		return null;
    	} 
    }
    
    /**
     * Phương thức khiểm tra password rỗng
     * @param password
     * @return
     */
    public static String checkEmptyPasswordFields( String password) {
    	if(password.isEmpty()) {
    		return "Không được bỏ trống mật khẩu";
    	}else {
    		return null;
    	}
    }

    /**
     * Phương thức kiểm tra email có hợp lệ không
     * @param email
     * @return
     */
    public static String checkInvalidEmailCharacters(String email) {
    	if(!EmailValidator.getInstance().isValid(email)) {
    		return "Email không hợp lệ";
    	}else {
    		return null;
    	}
    }
    
    /**
     * Phương thức kiểm tra mật khẩu có hợp lệ không
     * @param password
     * @return
     */
    public static String checkInvalidPasswordCharacters(String password) {
    	// Kiểm tra mật khẩu có đủ dài (tối thiểu 8 ký tự) không
        boolean isLengthValid = GenericValidator.minLength(password, 8);

        // Kiểm tra mật khẩu có chứa ít nhất một chữ cái và một chữ số không
        boolean isAlphaNumeric = GenericValidator.matchRegexp(password, "^(?=.*[a-zA-Z])(?=.*\\d).+$");
        
        if (!isLengthValid) {
            return "Mật khẩu phải dài tối thiêu 8 kí tự";
        } else if(!isAlphaNumeric){
        	return "Mật khẩu phải chứa ít nhất một chữ cái và số";
        } else {
        	return null;
        }
    }

    /**
     * Phương thức kiểm tra tài khoản có tồn tại không
     * @param username
     * @param password
     * @param usernameData
     * @param passworData
     * @return
     */
    public static String checkAccountDoesNotExist(String username, String password, String usernameData, String passworData) {
        // Kiểm tra trong cơ sở dữ liệu nếu tài khoản tồn tại
    	if(!username.equals(usernameData) || !password.equals(passworData)) {
    		return "Email hoặc mật khẩu không khớp vui lòng kiểm tra lại";
    	} else {
    		return null;
    	}
    }
    
    /**
     * Phương thức kiểm tra trạng thái tài khoản đã được kích hoạt chưa
     * @param status trạng thái tài khoản vừa đăng nhập
     * @return
     */
    public static String checkActiveAccount(boolean status) {
    	if(!status) {
    		return "Tài khoản chưa được kích hoạt";
    	}else {
    		return null;
    	}
    }
}
