package com.assignment.utils;

public class ConvertBooleanUtils {
	/**
	 * phương thức chuyển đổi giá trị nam nữ
	 * @param isMale
	 * @return
	 */
	public static String convertBooleanToGender(boolean isMale) {
		return isMale ? "Nam" : "Nữ";
	}
}
