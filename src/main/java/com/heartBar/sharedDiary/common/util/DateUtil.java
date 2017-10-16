package com.heartBar.sharedDiary.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private final static Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    /**系统短时间格式:  yyyy-MM-dd*/
    public static final String DATE_FORMATE_DAY = "yyyy-MM-dd";
    /**系统短时间格式:  yyyy-MM-dd HH*/
    public static final String DATE_FORMATE_HOUR = "yyyy-MM-dd HH";
    /**系统时间格式:  yyyy-MM-dd HH:mm:ss*/
    public static final String DATE_FORMATE_LONG = "yyyy-MM-dd HH:mm:ss";
    /**系统时间格式:  yyyyMMddHHmmss*/
    public static final String DATE_FORMATE_Time_LONG = "yyyyMMddHHmmss";
    /**系统时间格式:  yyyyMMdd*/
    public static final String DATE_FORMATE_TIME = "yyyyMMdd";
    /**系统时间格式:  yyMMdd*/
    public static final String DATE_FORMATE_TIME_yyMMdd = "yyMMdd";
    /**系统时间格式:  Y年m月d日 H时m分s秒*/
    public static final String DATE_FORMATE_CN_LONG = "yyyy年MM月dd日HH时mm分ss秒";
    /**系统时间格式: yyyy-MM-dd HH:mm*/
    public static final String DATE_FORMATE_MINUTE = "yyyy-MM-dd HH:mm";
    /**系统时间格式: MM-dd HH:mm*/
    public static final String DATE_FORMATE_MINUTE_REMOVE_YEAR = "MM-dd HH:mm";

    /**
     * 比较两个日期大小  time1>=time2 true
     *
     * @param time1 起始日期
     * @param time2 终止日期
     * @return boolean
     */
    public static boolean comparisonDate(Date time1, Date time2) {
        if ((time1.getTime() - time2.getTime()) >= 0) {
            return true;
        }
        return false;
    }

    /**
     * 比较两个日期大小  time1>time2 true
     *
     * @param time1 起始日期
     * @param time2 终止日期
     * @return boolean
     */
    public static boolean comparisonDate1(Date time1, Date time2) {
        if ((time1.getTime() - time2.getTime()) > 0) {
            return true;
        }
        return false;
    }

    /**
     *  根据日期取得星期几
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        String[] weeks = {"周日","周一","周二","周三","周四","周五","周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * yyyy-MM-dd
     *
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static Date parseDayDataFromStr(String dataStr) throws ParseException {
        if (StringUtils.isEmpty(dataStr)) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMATE_DAY).parse(dataStr);
    }


    /**
     * yyyy-MM-dd
     *
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String parseDayDataFrom(Date dataStr) {
        if (dataStr == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMATE_DAY).format(dataStr);
    }


    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static Date parseLongDataFromStr(String dataStr) {
        if (StringUtils.isEmpty(dataStr)) {
            return null;
        }
        try {
            return new SimpleDateFormat(DATE_FORMATE_LONG).parse(dataStr);
        } catch (ParseException e) {
            LOG.error("yyyy-MM-dd HH:mm:ss格式字符串转时间错误");
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDateFromStr(String dataStr, String strFormat)  {
        if (StringUtils.isEmpty(dataStr)) {
            return null;
        }
        try {
            return new SimpleDateFormat(strFormat).parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * yyyyMMddHHmmss
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String parseLongDataFromTimeLongStr(Date dataStr) throws ParseException {
        if (dataStr==null) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMATE_Time_LONG).format(dataStr);
    }


    /**
     * yyyyMMdd
     *
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String parseDayDataFromStr(Date dataStr) throws ParseException {
        if (dataStr == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMATE_TIME).format(dataStr);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String parseLongDataFromStr(Date dataStr) throws ParseException {
        if (dataStr == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_FORMATE_LONG).format(dataStr);
    }

    /**
     * 计算两个时间的时间差
     * startTime开始时间
     * endTime结束时间
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Integer evaluateTimeDays(String startTime, String endTime) {
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long between = 0;
        try {
            Date begin = dfs.parse(startTime);
            Date end = dfs.parse(endTime);
            between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long time = (day * 24 * 60) + (hour * 60) + min;
        return Integer.parseInt(String.valueOf(time));
    }


    /**
     * 时间转化
     * date当前时间
     * dayTime相差天数
     *
     * @param date
     * @param dayTime
     * @return
     */
    public static Date getNextDay(Date date, int dayTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, dayTime);
        date = calendar.getTime();
        return date;
    }



    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getYear(String dateStr) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseDayDataFromStr(dateStr));
        return calendar.get(Calendar.YEAR);
    }

    public static boolean isEarly(Date before, Date after) {
        if(before == null || after == null) {
            throw new NullPointerException("date1 or date2 can't be null !");
        }
        Calendar calendarF = Calendar.getInstance();
        Calendar calendarS = Calendar.getInstance();
        calendarF.setTime(before);
        calendarS.setTime(after);

        return calendarF.before(calendarS);
    }

    public static boolean isEarly(String dateStr1, String dateStr2) throws ParseException {
        Date date1 = parseDayDataFromStr(dateStr1);
        Date date2 = parseDayDataFromStr(dateStr2);
        return isEarly(date1, date2);
    }

    /**
     * 将date转换成String
     *
     * @param format 时间格式
     * @return
     */
    public static String dateToStr(Date date, String format) {
        String ret = null;
        String mask = format;
        if (mask == null || "".equals(mask)){
            mask = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(mask);
        ret = sdf.format(date);
        return ret;
    }


    /**
     * 获取当前日期
     * @return
     */
    public static Date getCurrentDate() {
        return parseDateFromStr(DateUtil.parseDayDataFrom(new Date()), DateUtil.DATE_FORMATE_DAY);
    }


    /**
     * 天数加减
     * @param date
     * @return
     */
    public static Date addOrSubDay(Date date, int n) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_MONTH, n);
        date = cl.getTime();
        return date;
    }

    /**
     * 小时加减
     * @param date
     * @return
     */
    public static Date addOrSubHour(Date date, int n) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.HOUR, n);
        date = cl.getTime();
        return date;
    }

    /**
     * 分钟加减
     * @param date
     * @return
     */
    public static Date addOrSubMinute(Date date, int n) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.MINUTE, n);
        date = cl.getTime();
        return date;
    }


    /**
     *
     * @Title: getBeforeDay
     * @Description: 获取当前日期的前一天 yyyy-MM-dd
     * @return
     * @author zhaox 2015年10月9日下午4:29:15
     */
    public static String getBeforeDay(){
        return getBeforeDay(null);
    }

    /**
     *
     * @Title: getBefore
     * @Description: 获取指定日期的前一天 yyyy-MM-dd
     * @param d
     * @return
     * @author zhaox 2015年10月9日下午4:25:48
     */
    public static String getBeforeDay(Date d){
        Date date = null;
        if(null == d){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        return dateToFormatStr(calendar.getTime(),"yyyy-MM-dd");
    }

    /**
     * 获取当月第一天
     * @return
     */
    public static Date getCurrentMonthFirstDay(){
        return getMonthFirstDay(new Date());
    }

    /**
     * 获取指定月份第一天
     * @param date
     * @return
     */
    public static Date getMonthFirstDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        return calendar.getTime();
    }

    /**
     * 获取当月最后一天
     * @return
     */
    public static Date getCurrentMonthLastDay(){
        return getMonthLastDay(new Date());
    }

    /**
     * 获取指定日期月份的最后一天
     * @param date
     * @return
     */
    public static Date getMonthLastDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+1);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        return calendar.getTime();
    }

    /**
     * 日期格式转化
     * @author wyh
     */
    public static String dateToFormatStr(Date date, String format) {
        if(date == null || StringUtils.isEmpty(format)){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 将时间转换为时间戳
     */
    public static String dateStrToStamp(String s, String patter) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 将时间转换为时间戳
     */
    public static String dateToStamp(Date date) throws ParseException {
        String res;
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s, String patter){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        StringBuffer dayStr = new StringBuffer();
        if(day>0){
            dayStr.append(day);
            dayStr.append("天");
        }
        if(hour>0){
            dayStr.append(hour);
            dayStr.append("小时");
        }
        if(min>0){
            dayStr.append(min);
            dayStr.append("分钟");
        }
        return dayStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(dateToFormatStr(getCurrentMonthFirstDay(),"yyyy-MM-dd"));
        System.out.println(dateToFormatStr(getCurrentMonthLastDay(),"yyyy-MM-dd"));
    }


}
