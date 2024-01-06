package com.ecom.app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.ecom.app.constant.Constant;

@Component
public class DateUtil {

	public static Date getFromDate(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateFrom = cal.getTime();
		// dateFrom = addMinutesToJavaUtilDate(dateFrom,
		// -(Constant.IST_OFFSET_IN_MINUTES));
		return dateFrom;
	}

	public static Date getFromDateLong(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		return dateFrom;
	}
	
	public static Date getFromDateLongUTC(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, -(Constant.IST_OFFSET_IN_MINUTES));
		return dateFrom;
	}

	public static Date getFromDateWithTime(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, -(Constant.IST_OFFSET_IN_MINUTES));
		SimpleDateFormat isoFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			dateFrom = isoFormat.parse(dateFrom.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFrom;
	}

	public static String getFromDateSqlFormat(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, -(Constant.IST_OFFSET_IN_MINUTES));
		SimpleDateFormat isoFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			dateFrom = isoFormat.parse(dateFrom.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD);
		return df.format(dateFrom);
	}

	public static Date getFromDateInUTCISTTime(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, -(Constant.IST_OFFSET_IN_MINUTES));
		SimpleDateFormat isoFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			dateFrom = isoFormat.parse(dateFrom.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFrom;
	}

	public static Date getToDateWithTime(Long toDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date dateTo = calendar.getTime();
		dateTo = addMinutesToJavaUtilDate(dateTo, -(Constant.IST_OFFSET_IN_MINUTES));
		SimpleDateFormat isoFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			dateTo = isoFormat.parse(dateTo.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTo;
	}

	public static Date getToDateWithTimeV2(Long toDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date dateTo = calendar.getTime();
		dateTo = addMinutesToJavaUtilDate(dateTo, -(Constant.IST_OFFSET_IN_MINUTES));
		SimpleDateFormat isoFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			dateTo = isoFormat.parse(dateTo.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTo;
	}

	public static Date getToDateWithCurrentTime(Long toDate) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date dateTo = null;
		if (calendar.getTime().getDate() == date.getDate()) {
			dateTo = calendar.getTime();
		} else {
			dateTo = calendar.getTime();
			dateTo = addMinutesToJavaUtilDate(dateTo, -(Constant.IST_OFFSET_IN_MINUTES));
		}
		SimpleDateFormat isoFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			dateTo = isoFormat.parse(dateTo.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateTo;
	}

	public static Date getToDate(Long toDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		Date dateTo = calendar.getTime();
		// dateTo = addMinutesToJavaUtilDate(dateTo, -(Constant.IST_OFFSET_IN_MINUTES));
		return dateTo;
	}

	public static Date getToDateLong(Long toDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date dateTo = calendar.getTime();
		return dateTo;
	}

	public static Date convertStringToDate(String stringDate, String format) {
		Date date = null;
		try {
			date = new SimpleDateFormat(format).parse(stringDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date getDateFromLong(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		return dateFrom;
	}

	public static String localDateTimeToStringInFormatYYYYMMDD$HHMMSS(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
		return formatter.format(date);
	}

	public static String localDateTimeToStringInFormatYYYYMMDD(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD);
		return formatter.format(date);
	}

	public static String localDateTimeToStringInFormat(Date date, String format) {
		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static String getFromDateWithFromat(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 1);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, Constant.IST_OFFSET_IN_MINUTES);
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateFrom);
	}

	// DATE WILL BE IN UTC WITH TIME
	public static String getFuelFromDate(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, -Constant.IST_OFFSET_IN_MINUTES);
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateFrom);
	}

	public static String getFromDateWithTimeFromat(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, -Constant.IST_OFFSET_IN_MINUTES);
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateFrom);
	}

	public static String getFromDateWithOutAddTimeFromat(Long fromDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateFrom);
	}

	public static String getToDateWithFromat(Long toDate) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date dateTo = null;
		if (calendar.getTime().getDate() == date.getDate()) {
			calendar.set(Calendar.HOUR_OF_DAY, date.getHours());
			calendar.set(Calendar.MINUTE, date.getMinutes());
			calendar.set(Calendar.SECOND, date.getSeconds());
			calendar.set(Calendar.MILLISECOND, 999);
			dateTo = calendar.getTime();
		} else {
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 999);
			dateTo = calendar.getTime();
			dateTo = addMinutesToJavaUtilDate(dateTo, Constant.IST_OFFSET_IN_MINUTES);
		}
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateTo);
	}

	public static String getFuelToDate(Long toDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date dateTo = null;
		dateTo = calendar.getTime();
		dateTo = addMinutesToJavaUtilDate(dateTo, -Constant.IST_OFFSET_IN_MINUTES);
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateTo);
	}

	public static Date getISTDateWithTime(Long toDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date date = calendar.getTime();
		date = addMinutesToJavaUtilDate(date, (Constant.IST_OFFSET_IN_MINUTES));
		SimpleDateFormat isoFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		isoFormat.setTimeZone(TimeZone.getTimeZone("IST"));
		try {
			date = isoFormat.parse(date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Long convertMilliToMin(Long milli) {
		if (milli == null) {
			return 0l;
		}
		return TimeUnit.MILLISECONDS.toMinutes(milli);
	}

	public static float diffDateInMinutes(Date from, Date to) {
		Long dateDiff = Math.abs(from.getTime() - to.getTime());
		return (float) dateDiff / (60 * 1000);
	}

	public static Date addMinutesToJavaUtilDate(Date date, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}

	public static String getFuelToDatePlusMinutes(Long fromDate, Long minutesToAdd) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(fromDate));
		Date dateFrom = cal.getTime();
		dateFrom = addMinutesToJavaUtilDate(dateFrom, -Constant.IST_OFFSET_IN_MINUTES);
		dateFrom = addMinutesToJavaUtilDate(dateFrom, minutesToAdd.intValue());
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateFrom);

	}

	public static String getFuelToDateMinusMinutes(Long toDate, Long minutesToMinus) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		Date dateTo = null;
		if (calendar.getTime().getDate() == date.getDate()) {
			calendar.set(Calendar.HOUR_OF_DAY, date.getHours());
			calendar.set(Calendar.MINUTE, date.getMinutes());
			calendar.set(Calendar.SECOND, date.getSeconds());
			calendar.set(Calendar.MILLISECOND, 999);
			dateTo = calendar.getTime();
		} else {
			dateTo = calendar.getTime();
			dateTo = addMinutesToJavaUtilDate(dateTo, -Constant.IST_OFFSET_IN_MINUTES);
			dateTo = addMinutesToJavaUtilDate(dateTo, -minutesToMinus.intValue());
		}
		DateFormat df = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD_T_HH_MM_SS_Z);
		return df.format(dateTo);
	}

	public static Boolean checkDateTodayDate(Long toDate) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date(toDate));
		if (calendar.getTime().getDate() == date.getDate()) {
			return true;
		} else {
			return false;
		}
	}

	public static Date dateFormatter(Long Date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(Date));
		Date date = cal.getTime();
		date = cal.getTime();
		SimpleDateFormat isoFormat = new SimpleDateFormat(Constant.DATE_FORMAT_YYYY_MM_DD);
		try {
			date = isoFormat.parse(date.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static LocalDate convertToLocalDate(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalDate firstDayOfPreviousMonth(LocalDate date) {
        return date.minusMonths(1).withDayOfMonth(1);
    }
	
	public static LocalDate lastDayOfCurrentMonth(LocalDate date) {
		return date.plusDays(date.lengthOfMonth()-1);
	}
	
	public static LocalDate lastDayOfPreviousMonth(LocalDate date) {
        return date.withDayOfMonth(1).minusDays(1);
    }
	
	public static Date convertLocalDateToDate(LocalDate date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
	}
	
	public static Integer getYear(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		return year;
		//Add one to month {0 - 11}
//		int month = calendar.get(Calendar.MONTH) + 1;
//		int day = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Boolean checkDateForSameMonthYear(Date startDate,Date endDate) {
		try {
			System.out.println(getYear(startDate) + " " + getYear(endDate) + " " + startDate.getMonth() + " " + endDate.getMonth());
			if(getYear(startDate).intValue() == getYear(endDate).intValue() &&  startDate.getMonth() == endDate.getMonth()) {
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static long convertDateInLong(Date date) {
	    long msec = date.getTime();
	    return msec;
	}
}
