package algorithms;

import com.google.common.base.Strings;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期常用方法类
 *
 * @author kgp
 */
public class DateUtil implements Serializable {

    private static final long serialVersionUID = -5493105864666571423L;

    public static final String FORMATMONTH = "yyyy-MM";

    public static final String FORMATDAY = "yyyy-MM-dd";

    public static final String FORMATDATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 防止构造
     */
    private DateUtil() {
    }

    /**
     * 获取指定的日期的Date格式
     *
     * @param year  年
     * @param month 月
     * @param day   日
     * @return Date 指定年月日的日期格式
     */
    public static Date getDate(int year, int month, int day) {

        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day, 0, 0, 0);
        return cal.getTime();
    }

    /**
     * 将日期格式化输出为yyyy-MM-dd HH:mm:ss的String格式
     *
     * @param date
     * @return String
     */
    public static String format(Date date) {
        return format(date, FORMATDATETIME);
    }

    /**
     * 判断时间格式 格式必须为“YYYY-MM-dd”
     * 2004-2-30 是无效的
     * 2003-2-29 是无效的
     *
     * @param str
     * @return
     */
    public static boolean isValidDate(String str) {
        return isValidDate(str, FORMATDAY);
    }

    /**
     * 判断时间格式
     *
     * @param str
     * @return
     */
    public static boolean isValidDate(String str, String format) {
        if (Strings.isNullOrEmpty(str)) return false;
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date date = formatter.parse(str);
            return str.equals(formatter.format(date));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 将日期格式化输出为yyyy-MM-dd HH:mm:ss的String格式
     *
     * @param date
     * @return String
     */
    public static String formatDay(Date date) {
        return format(date, FORMATDAY);
    }

    /**
     * 将日期格式化输出为String格式
     *
     * @param date   日期
     * @param format 日期格式
     * @return String
     */
    public static String format(Date date, String format) {
        return format(date, format, null);
    }

    public static String format(Date date, String format, Locale locale) {
        if (date == null) return "";
        if (locale == null) {
            locale = Locale.getDefault(Locale.Category.FORMAT);
        }
        DateFormat df;
        if (Strings.isNullOrEmpty(format)) {
            df = new SimpleDateFormat(FORMATDATETIME, locale);
        } else {
            df = new SimpleDateFormat(format, locale);
        }
        try {
            return df.format(date);
        } catch (Exception e) {
        }
        return "";
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss的String格式输出为日期格式
     *
     * @param date String日期
     * @return Date 日期格式
     */
    public static Date parseDate(String date) {
        return parseDate(date, FORMATDATETIME);
    }

    /**
     * 将日期格式化输出为日期格式
     *
     * @param date   日期
     * @param format 日期格式
     */
    public static Date parseDate(Date date, String format) {
        String dt = format(date);
        return parseDate(dt, format);
    }

    /**
     * 将String格式输出为日期格式
     *
     * @param date   String日期
     * @param format 格式
     * @return Date 日期 格式
     */
    public static Date parseDate(String date, String format) {
        return parseDate(date, format, true);
    }

    /**
     * 将String格式输出为日期格式
     *
     * @param date    String日期
     * @param format  格式
     * @param needNow 当解析失败是否返回当前时间
     * @return Date 日期 格式
     */
    public static Date parseDate(String date, String format, boolean needNow) {
        if (Strings.isNullOrEmpty(date)) {
            return needNow ? new Date() : null;
        }
        DateFormat df;
        if (Strings.isNullOrEmpty(format)) {
            df = new SimpleDateFormat(FORMATDATETIME);
        } else {
            df = new SimpleDateFormat(format);
        }
        try {
            return df.parse(date);
        } catch (Exception e) {

            return needNow ? new Date() : null;
        }
    }

    /**
     * 根据出生日期获得年龄
     *
     * @param birthday
     * @return
     */
    public static int getAge(Long birthday) {
        int age = 0;
        GregorianCalendar gc = new GregorianCalendar();
        GregorianCalendar now = (GregorianCalendar) gc.clone();
        gc.setTimeInMillis(birthday.longValue());
        age = now.get(Calendar.YEAR) - gc.get(Calendar.YEAR);
        if (age < 0) {
            age = 0;
        }
        return age;
    }

    /**
     * 返回时间long类型
     *
     * @param date 日期
     * @return long 毫秒
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 得到和当前时间指定日期差时间
     *
     * @param amount 相差的天数
     * @return 日期
     */
    public static Date addDays(int amount) {
        return addDays(new Date(), amount);
    }

    /**
     * 得到指定相差天数的日期
     *
     * @param date   日期
     * @param amount 天数
     * @return 返回相加后的日期
     */
    public static Date addDays(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, amount);
        return c.getTime();
    }

    /**
     * 得到指定相差天数的日期
     *
     * @param date   日期
     * @param amount 天数
     * @return 返回相加后的日期
     */
    public static Date addDays(String date, int amount) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMATDAY);
            Date dt = df.parse(date);
            return addDays(dt, amount);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 得到和当前时间指定小时差时间
     *
     * @param amount 相差的天数
     * @return 日期
     */
    public static Date addHours(int amount) {
        return addHours(new Date(), amount);
    }

    /**
     * 得到指定相差小时的日期
     *
     * @param date   日期
     * @param amount 天数
     * @return 返回相加后的日期
     */
    public static Date addHours(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, amount);
        return c.getTime();
    }

    /**
     * 得到指定相差天数的日期
     *
     * @param date   日期
     * @param amount 天数
     * @return 返回相加后的日期
     */
    public static Date addHours(String date, int amount) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMATDATETIME);
            Date dt = df.parse(date);
            return addHours(dt, amount);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 得到和当前时间指定小时差时间
     *
     * @param amount 相差的天数
     * @return 日期
     */
    public static Date addMs(int amount) {
        return addMs(new Date(), amount);
    }

    /**
     * 得到指定相差小时的日期
     *
     * @param date   日期
     * @param amount 天数
     * @return 返回相加后的日期
     */
    public static Date addMs(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, amount);
        return c.getTime();
    }

    /**
     * 得到指定相差天数的日期
     *
     * @param date   日期
     * @param amount 天数
     * @return 返回相加后的日期
     */
    public static Date addMs(String date, int amount) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMATDATETIME);
            Date dt = df.parse(date);
            return addMs(dt, amount);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 得到指定相差月数的日期
     *
     * @param amount 月数
     * @return 返回相加后的日期
     */
    public static Date addMonths(int amount) {
        return addMonths(new Date(), amount);
    }

    /**
     * 得到指定相差月数的日期
     *
     * @param date   日期
     * @param amount 月数
     * @return 返回相加后的日期
     */
    public static Date addMonths(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, amount);
        return c.getTime();
    }

    /**
     * 得到指定相差月数的日期
     *
     * @param date   日期
     * @param amount 月数
     * @return 返回相加后的日期
     */
    public static Date addMonths(String date, int amount) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMATDAY);
            Date dt = df.parse(date);
            return addMonths(dt, amount);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @param amount
     * @return
     */
    public static Date addYears(int amount) {
        return addYears(new Date(), amount);
    }

    /**
     * 得到指定相差年数的日期
     *
     * @param date   日期
     * @param amount 年数
     * @return 返回相加后的日期
     */
    public static Date addYears(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, amount);
        return c.getTime();
    }

    /**
     * 得到指定相差年数的日期
     *
     * @param date   日期
     * @param amount 年数
     * @return 返回相加后的日期
     */
    public static Date addYears(String date, int amount) {
        try {
            SimpleDateFormat df = new SimpleDateFormat(FORMATDAY);
            Date dt = df.parse(date);
            return addYears(dt, amount);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @param fromDate 起始日期（yyyy-MM-dd）
     * @param toDate   结束日期yyyy-MM-dd）
     * @return 获取两个日期之差(天数)
     */
    public static long getDiffDay(String fromDate, String toDate) {
        long day = 0;
        try {
            Date date = parseDate(fromDate, FORMATDAY);
            Date date2 = parseDate(toDate, FORMATDAY);
            day = getMillis(date) - getMillis(date2);
            day = day / 24 / 3600 / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * @param fromDate 起始日期
     * @param toDate   结束日期
     * @return 获取两个日期之差(天数)
     */
    public static long getDiffDay(Date fromDate, Date toDate) {
        long day = 0;
        try {
            Date date = parseDate(fromDate, FORMATDAY);
            Date date2 = parseDate(toDate, FORMATDAY);
            day = getMillis(date) - getMillis(date2);
            day = day / 24 / 3600 / 1000;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return day;
    }

    /**
     * 获取当前时间
     *
     * @return 字符串类型日期时间
     */
    public static String getNowTime() {
        DateFormat formatter = new SimpleDateFormat(FORMATDATETIME);
        Calendar objCalendar = Calendar.getInstance();
        String strReturn = formatter.format(objCalendar.getTime());
        return strReturn;
    }

    /**
     * 获取long型时间的年份
     *
     * @param dateLong
     * @return year
     */
    public static int getYear(long dateLong) {
        Date date = new Date(dateLong);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(1);
    }

    /**
     * 获取当前年份
     *
     * @return 年份
     */
    public static int getYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取指定日期的年份
     *
     * @return 年份
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取当前年份
     *
     * @return 年份
     */
    public static int getYear(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date, FORMATDAY));
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取当前月份
     *
     * @return 月份
     */
    public static int getMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取指定时间的月份
     *
     * @return 月份
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取指定时间的月份
     *
     * @return 月份
     */
    public static int getMonth(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date, FORMATDAY));
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取当前所在月份的日期
     *
     * @return 日期
     */
    public static int getDay() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        return day;
    }

    /**
     * 获取指定时间的是所在月份的第几天
     *
     * @param date
     * @return int 当前月份的第几天
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        return day;
    }

    /**
     * 获取指定时间的是所在月份的第几天
     *
     * @param date
     * @return int 当前月份的第几天
     */
    public static int getDay(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date, FORMATDAY));
        int day = cal.get(Calendar.DATE);
        return day;
    }

    /**
     * 获取当前的小时
     *
     * @return int 当前的小时数（24小时制）
     */
    public static int getHour() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 获取当前的小时
     *
     * @return int 当前的小时数（24小时制）
     */
    public static int getHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 获取当前的小时
     *
     * @return int 当前的小时数（24小时制）
     */
    public static int getHour(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date));
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    /**
     * 获取当前的分钟
     *
     * @return 当前的分钟
     */
    public static int getMinute() {
        Calendar cal = Calendar.getInstance();
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }

    /**
     * 获取指定的分钟
     *
     * @return 分钟
     */
    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }

    /**
     * 获取指定的分钟
     *
     * @return 分钟
     */
    public static int getMinute(String date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(parseDate(date));
        int minute = cal.get(Calendar.MINUTE);
        return minute;
    }

    /**
     * 返回制定年月的最后一天
     *
     * @param seedDate 日期
     * @return String 2005-11-10 返回2005-11-30;
     * @author longjianhui 2005-11-30
     */
    public static String getLastDayOfMonthOfYear(String seedDate) {
        // 这里定义对seedDate的格式化
        DateFormat formatter = new SimpleDateFormat(FORMATDAY);
        String ret = "";
        try {
            formatter.format(formatter.parse(seedDate));
            Calendar tempcl = formatter.getCalendar();
            // 获得制定月份的最大天数
            int MaxDayOfMonthOfYear = tempcl.getActualMaximum(Calendar.DATE);
            // 年月日重新组合
            ret = tempcl.get(Calendar.YEAR) + "-" + (tempcl.get(Calendar.MONTH) + 1) + "-" + MaxDayOfMonthOfYear;
            // 对重新组合的年月日进行yyyy-MM-dd格式化
            ret = formatter.format(formatter.parseObject(ret));
            return ret;
        } catch (Exception ex) {

        }
        return "";
    }

    /**
     * 获取当月的天数
     *
     * @return Integer 天数
     */
    public static int getCurrentMonthDay() {
        Calendar cal = Calendar.getInstance();
        int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDate;
    }

    /**
     * 根据年、月获取对应的月份的天数
     *
     * @param year  年
     * @param month 月
     * @return Integer 天数
     */
    public static int getMonthDay(int year, int month) {

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DATE, 1);
        int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDate;
    }

    /**
     * 根据日期获取日期所在月份的天数
     *
     * @param oneDay
     * @return Integer 天数
     */
    public static int getMonthDay(Date oneDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(oneDay);
        int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        return maxDate;
    }

    /**
     * 根据日期 找到对应日期的 星期
     */
    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat(FORMATDAY);
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            dayOfweek = str;

        } catch (Exception e) {

        }
        return dayOfweek;
    }


    /**
     * 获取当前日期是星期几(0-6：周日-周六)
     *
     * @param source
     * @return
     */
    public static int getWeek(Date source) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(source);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0) {
            week = 0;
        }
        return week;
    }

    /**
     * 根据当前日期，计算是当年第几周
     * 从周日开始计算（周日-周六）
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        int week = cl.get(Calendar.WEEK_OF_YEAR);
        return week;
    }

    /**
     * 获得周一的日期
     *
     * @param date
     * @return
     */
    public static Date getMonday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();

    }

    /**
     * 比较2个字符串时间差
     *
     * @param time1
     * @param time2
     * @return long 时间差
     */
    public static long compare(String time1, String time2) {
        DateFormat formatter = new SimpleDateFormat(FORMATDATETIME);
        try {
            Date dt1 = formatter.parse(time1);
            Date dt2 = formatter.parse(time2);
            return (dt1.getTime() - dt2.getTime());
        } catch (Exception e) {

        }
        return 0;
    }

    public static Long getShortTimestamp() {
        return Long.valueOf((getTimestamp() / 1000) + "");
    }

    public static long getTimestamp() {
        return getTimestamp(getNowTime());
    }

    public static long getTimestamp(String date) {
        return parseDate(date).getTime();
    }

    public static long getTimestamp(String date, String format) {
        return parseDate(date, format).getTime();
    }

    public static String getTimestampString() {
        return parseDate(getNowTime()).getTime() + "";
    }

    public static String getTimestampString(String date) {
        return parseDate(date).getTime() + "";
    }

    /**
     * 比较2个时间的时间差
     *
     * @param time1
     * @param time2
     * @return long 时间差
     */
    public static long compare(Date time1, Date time2) {
        try {
            return (time1.getTime() - time2.getTime());
        } catch (Exception e) {

        }
        return 0;
    }

    /**
     * 比较2个时间的时间差
     *
     * @param time1
     * @param time2
     * @return long 时间差
     */
    public static long compareDay(Date time1, Date time2) {
        try {
            return compare(time1, time2) / 86400000;
        } catch (Exception e) {

        }
        return 0;
    }


    protected static Format format = new SimpleDateFormat(FORMATDATETIME);

    public static void printSysProperties() {
        Properties props = System.getProperties();
        Iterator iter = props.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            System.out.println(key + " = " + props.get(key));
        }
    }

    /**
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     *
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(int timeZoneOffset) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(timeZoneOffset * 60 * 60 * 1000);
        if (ids.length == 0) {
            // if no ids were returned, something is wrong. use default TimeZone
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(timeZoneOffset * 60 * 60 * 1000, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(FORMATDATETIME);
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

    /**
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     *
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(String date, int timeZoneOffset) {
        if (Strings.isNullOrEmpty(date)) {
            date = DateUtil.getNowTime();
        }
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(timeZoneOffset * 60 * 60 * 1000);
        if (ids.length == 0) {
            // if no ids were returned, something is wrong. use default TimeZone
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(timeZoneOffset * 60 * 60 * 1000, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(FORMATDATETIME);
        sdf.setTimeZone(timeZone);
        return sdf.format(date);

    }

    /**
     * timeZoneOffset表示时区，如中国一般使用东八区，因此timeZoneOffset就是8
     *
     * @param timeZoneOffset
     * @return
     */
    public static String getFormatedDateString(Date date, int timeZoneOffset) {
        if (date == null) {
            return "";
        }
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(timeZoneOffset * 60 * 60 * 1000);
        if (ids.length == 0) {
            // if no ids were returned, something is wrong. use default TimeZone
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(timeZoneOffset * 60 * 60 * 1000, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat(FORMATDATETIME);
        sdf.setTimeZone(timeZone);
        return sdf.format(date);
    }

    public static String getFormatedDateString(String _timeZone) {
        TimeZone timeZone = null;
        if (Strings.isNullOrEmpty(_timeZone)) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = TimeZone.getTimeZone(_timeZone);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
        sdf.setTimeZone(timeZone);
        //TimeZone.setDefault(timeZone);
        return sdf.format(new Date());
    }

    public static void setCNTimeZone() {
        final TimeZone zone = TimeZone.getTimeZone("GMT+8");
        TimeZone.setDefault(zone);
    }

    /**
     * 将时间戳转换为时间
     *
     * @param timestamp
     * @return
     */
    public static String stampToDate(Long timestamp) {
        Date date = new Date(timestamp);
        return format(date);
    }

    /**
     * 将时间戳转换为时间
     *
     * @param timestamp 时间戳（毫秒）
     * @param format    时间格式
     * @return
     */
    public static String stampToDate(Long timestamp, String format) {
        Date date = new Date(timestamp);
        return format(date, format);
    }

    /**
     * 将日期字符串转换成日期
     *
     * @param dateStr 日期
     * @param format  日期格式
     * @return String
     */
    public static Date strToDate(String dateStr, String format) {
        if (Strings.isNullOrEmpty(dateStr)) return null;
        SimpleDateFormat df;
        if (dateStr.length() == 10) {
            dateStr = dateStr + " 00:00:00";
        }
        if (Strings.isNullOrEmpty(format)) {
            df = new SimpleDateFormat(FORMATDAY);
        } else {
            df = new SimpleDateFormat(format);
        }
        try {
            return df.parse(dateStr);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 将日期格式化为字符串，默认为yyyy-MM-dd
     *
     * @param srcDate
     * @param format
     * @return
     */
    public static String dateToStr(Date srcDate, String format) {
        if (srcDate == null) return "";
        SimpleDateFormat df;
        if (Strings.isNullOrEmpty(format)) {
            df = new SimpleDateFormat(FORMATDAY);
        } else {
            df = new SimpleDateFormat(format);
        }
        try {
            return df.format(srcDate);
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * 奇数天
     *
     * @param date
     * @return
     */
    public static boolean isOdd(Date date) {
        if (date != null) {
            return getDay(date) % 2 > 0;
        }
        return false;
    }

    /**
     * 偶数天
     *
     * @param date
     * @return
     */
    public static boolean isEven(Date date) {
        if (date != null) {
            return getDay(date) % 2 == 0;
        }
        return false;
    }

}
