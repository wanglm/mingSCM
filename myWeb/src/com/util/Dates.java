package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**日期转换类
 * Long-String or String - Long
 * @author ming
 *
 */
public class Dates {
	private final static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	private final static String dateTimePattern2 = "yyyy/MM/dd HH:mm:ss";
	private final static String dateTimePattern3 = "yyyyMMddHHmmss";
	private final static String dateTimePattern4 = "yyyy-MM-dd HH:mm";
	private final static String datePattern = "yyyy-MM-dd";
	private final static String datePattern2 = "yyyy/MM/dd";
	private final static String datePattern3 = "yyyy-MM";
	private final static String timePattern = "HH:mm:ss";
	private final static String stimePattern = "HH:mm";

	public static Date parse(String text) {
		try {
			if (text.length() == dateTimePattern.length()) {
				if (text.charAt(4) == '-' && text.charAt(7) == '-') {
					return new SimpleDateFormat(dateTimePattern).parse(text);
				}
				if (text.charAt(4) == '/' && text.charAt(7) == '/') {
					if (text.charAt(13) == ':' && text.charAt(16) == ':') {
						return new SimpleDateFormat(dateTimePattern2)
								.parse(text);
					}
				}
			} else if (text.length() == dateTimePattern3.length()) {
				return new SimpleDateFormat(dateTimePattern3).parse(text);
			} else if (text.length() == datePattern3.length()) {
				return new SimpleDateFormat(datePattern3).parse(text);
			} else if (text.length() == datePattern.length()) {
				if (text.charAt(4) == '-' && text.charAt(7) == '-') {
					return new SimpleDateFormat(datePattern).parse(text);
				}
				if (text.charAt(4) == '/' && text.charAt(7) == '/') {
					return new SimpleDateFormat(datePattern2).parse(text);
				}
			} else if (text.length() == timePattern.length()) {
				if (text.charAt(2) == ':' && text.charAt(5) == ':') {
					return new SimpleDateFormat(timePattern).parse(text);
				}
			} else if (text.length() == stimePattern.length()) {
				if (text.charAt(2) == ':') {
					return new SimpleDateFormat(stimePattern).parse(text);
				}
			} else if (text.length() == dateTimePattern4.length()) {
				return new SimpleDateFormat(dateTimePattern4).parse(text);
			}
			return new Date(Long.parseLong(text));
		} catch (Exception e) {
			return null;
		}
	}

	public static Date changeType(Date date, Class<?> targetType) {
		if (date == null) {
			return date;
		}
		if (java.sql.Date.class == targetType) {
			date = new java.sql.Date(date.getTime());
		} else if (java.sql.Time.class == targetType) {
			date = new java.sql.Time(date.getTime());
		} else if (java.sql.Timestamp.class == targetType) {
			date = new java.sql.Timestamp(date.getTime());
		}
		return date;
	}

	/**
	 * 判断给定日期是否为当天， 距离当前时间七天之内的日期，和七天之外的日期
	 * 
	 * @param dt
	 * @param type
	 *            0--当天 1--7天之内的 2--7天之外的
	 */
	public static boolean getDayDiffFromToday(Long dt, int type) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		long diff = c.getTimeInMillis() - dt;
		if (diff < 0)
			diff = 0;
		long days = diff / (1000 * 60 * 60 * 24);
		if (type == 0 && days == 0)
			return true;
		if (type == 1 && days > 0 && days <= 7)
			return true;
		if (type == 2 && days > 7)
			return true;
		return false;
	}

	public static String format(Date date, DateFormat format) {
		DateFormat dateFormat = (format != null ? format
				: new SimpleDateFormat("yyyyMMdd"));
		try {
			return dateFormat.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/** 获取今天启始日期 */
	public static Long getToday() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	/** 获取昨天启始日期 */
	public static Long getYesterday() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动
		return cal.getTimeInMillis();
	}

	/** 获取今天日期 */
	public static Long getToday(int hour) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	/** 获取明天启始日期 */
	public static Long getTomorrow() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		return cal.getTimeInMillis();
	}

	/** 获取本周的星期一 */
	public static Date getThisMonday() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}

	/** 获取本周的星期日 */
	public static Date getThisSunday() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTime();
	}

	/** 根据第几周获取此周的星期day */
	public static Long getWeeklyDay(Integer weekly, int day) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		cal.set(Calendar.WEEK_OF_YEAR, weekly);
		cal.set(Calendar.DAY_OF_WEEK, day);
		return cal.getTimeInMillis();
	}

	public static Integer getWeekly() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	public static Long Year(String year) {
		try {
			return Year(new SimpleDateFormat("yyyy").parse(year));
		} catch (ParseException e) {
			return 0l;
		}
	}

	public static Long Year(Date date) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(date);
		cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	public static Long LastYear(Long time) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTimeInMillis(time);
		cal.add(Calendar.YEAR, 1);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	public static Long YearMonth(String year, String f) {
		try {
			return YearMonth(new SimpleDateFormat(f).parse(year));
		} catch (ParseException e) {
			return 0l;
		}
	}

	public static Long YearMonth(Date date) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	public static Long LastYearMonth(Long time) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTimeInMillis(time);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTimeInMillis();
	}

	/** 获取本周的星期一 */
	public static Long getMonday(Long time) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTimeInMillis(time);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTimeInMillis();
	}

	/** 返回指定日期所在的星期日 */
	public static Long getSunday(long time) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTimeInMillis(time);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return cal.getTimeInMillis();
	}

	/** 返回当前年月日 */
	public static String Today() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/** 返回当前年月 */
	public static String getThisYearMonth() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		return new SimpleDateFormat("yyyy-MM").format(cal.getTime());
	}

	/** 返回当前年 */
	public static String getThisYear() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		return new SimpleDateFormat("yyyy").format(cal.get(Calendar.YEAR));
	}

	/** 返回当前年第一天 */
	public static String getDayOfYear() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.DAY_OF_YEAR, 1);// 本年第一天
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/** 返回当前月最后一天 */
	public static String getLastDayOfMonth() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.DATE, 1);
		cal.roll(Calendar.DATE, -1);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/** 返回当前月最后一天 */
	public static String getFirstDayOfMonth() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	/**
	 * 获取日期所在周。
	 * 
	 * @param time
	 * 
	 * @return
	 */
	public static Integer getWeekly(long time) {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.setTimeInMillis(time);
		cal.setFirstDayOfWeek(Calendar.MONDAY); // 以周1为首日
		return cal.get(Calendar.WEEK_OF_YEAR);
	}

	/** 返回前一天日期 */
	public static String getYestodayStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();// 此时打印它获取的是系统当前时间
		cal.add(Calendar.DATE, -1); // 得到前一天
		return sdf.format(cal.getTime());
	}

	/** 返回当前年第一个月 */
	public static String getFirstMonthOfYear() {
		Calendar cal = Calendar.getInstance(Locale.CHINA);
		cal.set(Calendar.DAY_OF_YEAR, 1);// 本年第一个月
		return new SimpleDateFormat("yyyy-MM").format(cal.getTime());
	}

	public static void main(String... args) {
		Long time = System.currentTimeMillis();
		System.out.println(new Date(time));
		System.out.println(Dates.getThisMonday());
		System.out.println(new Date(Dates.getMonday(time)));
		System.out.println(Dates.getThisSunday());
		System.out.println(new Date(Dates.getSunday(time)));
		System.out.println("------");
		Integer weekly = Dates.getWeekly(time);
		for (int i = 2; i <= 8; i++) {
			System.out.println(new Date(Dates.getWeeklyDay(weekly, i)));
		}
	}
}
