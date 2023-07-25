package com.assignment.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    /**
     * Phương thức chuyển đổi Ngày thành Chuỗi
     * @param date
     * @param pattern
     * @return trả về đoạn chuỗi đã được chuyển đổi
     */
	public static String convertDateToString(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

	/**
	 * Phương thức chuyển đổi Chuỗi thành Ngày
	 * @param dateString
	 * @param pattern
	 * @return trả về ngày đã được chuyển đổi
	 * @throws ParseException
	 */
    public static Date convertStringToDate(String dateString, String pattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(dateString);
    }
    
    /**
     * Phương thức chuyển đổi định dạng ngày tháng của nước ngoài thành ngày tháng Việt Nam
     * @param dateString
     * @param inputPattern
     * @return trả về định dạng ngày tháng đã được chuyển đổi
     * @throws ParseException
     */
    public static String convertToVietnameseDate(String dateString, String inputPattern) throws ParseException {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputPattern, Locale.US);
        Date date = inputDateFormat.parse(dateString);

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("EEEE, d MMMM yyyy", new Locale("vi", "VN"));
        return outputDateFormat.format(date);
    }
}
