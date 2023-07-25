package com.assignment.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.EmailValidator;

public class ValidationFormSignUpUtils {
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
     * Phương thức kiểm tra trường họ và tên rỗng
     * @param fristname
     * @param lastname
     * @return
     */
    public static String checkEmptyNameFields( String fristname, String lastname) {
    	if(fristname.isEmpty() || lastname.isEmpty()) {
    		return "Họ và tên không được bỏ trống";
    	}else {
    		return null;
    	}
    }
    
    /**
     * Phương thức kiểm tra trường nhập lại mật khẩu rỗng
     * @param password
     * @return
     */
    public static String checkEmptyReplacePasswordFields( String password) {
    	if(password.isEmpty()) {
    		return "Vui lòng nhập lại mật khẩu";
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
     * Kiểm tra email có bị trùng lặp hay không
     * @param email
     * @param password
     * @param emailData
     * @param passworData
     * @return
     */
    public static String checkEmailAlreadyExists(String email, String emailData) {
        // Kiểm tra trong cơ sở dữ liệu nếu tài khoản tồn tại
    	if(email.equals(emailData)) {
    		return "Email đã tồn tại";
    	} else {
    		return null;
    	}
    }
    
    /**
     * Phương thức kiểm tra họ hợp lệ
     * @param lastName
     * @return
     */
    public static String checkValidLastName(String lastName) {
        String regex = "^[\\p{L}][\\p{L}\\p{Pd}'\\s]*$";
        Pattern pattern = Pattern.compile(regex);
        
        // Kiểm tra xem họ có khớp với pattern hay không
        Matcher matcher = pattern.matcher(lastName);
        
        if(!matcher.matches()) {
        	return "Họ và tên không hợp lệ";
        }else {
        	return null;
        }
        
    }

    /**
     * Phương thức kiểm tra tên lợp lệ
     * @param firstName
     * @return
     */
    public static String checkValidFirstName(String firstName) {
        // Định nghĩa pattern cho trường tên theo chuẩn Việt Nam
        String regex = "^[\\p{L}][\\p{L}'\\s]*$";
        Pattern pattern = Pattern.compile(regex);
        
        // Kiểm tra xem tên có khớp với pattern hay không
        Matcher matcher = pattern.matcher(firstName);
        
        if(!matcher.matches()) {
        	return "Họ và tên không hợp lệ";
        }else {
        	return null;
        }
    }
    
    /**
     * Phương thức kiểm tra mật khẩu được nhập lại có khớp hay không
     * @param password
     * @param confirmPassword
     * @return
     */
    public static String checkPasswordMatch(String password, String confirmPassword) {
        // Kiểm tra xem mật khẩu và nhập lại mật khẩu có khớp nhau hay không
    	if(!password.equals(confirmPassword)) {
        	return "Mật khẩu nhập lại không khớp";
        }else {
        	return null;
        }
    }
}
