package algorithms;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2019/10/31
 */
public class DateTest {


    public static void main(String[] args) throws InterruptedException {
//        Date date1 = DateUtil.parseDate("2019-10-31 08:04:25");
//        Date date2 = DateUtil.parseDate("2019-10-31 12:04:25");
//        Date date3 = DateUtil.parseDate("2019-10-31 08:04:25");
//        System.out.println("判断时间段" + isInDate(date1, "09:00", "19:00", "HH:mm"));
//        System.out.println("判断时间段" + isInDate(date2, "23:00", "09:00", "HH:mm"));
//        System.out.println("判断时间段" + isInDate(date3, "23:00", "23:00", "HH:mm"));
//
//
//
//        // Owner工作时间
//        String o1 = "19:00";
//        String o2 = "09:00";
//
//        // 下单时间
//        Date bookingTime = DateUtil.parseDate("2019-10-31 18:04:25");
//        // 用车时间
//        Date useCarTime = DateUtil.parseDate("2019-11-02 08:04:25");
//
//        // 先判断用车时间是否在 工作时间范围内
//        if (isInDate(useCarTime, o1, o2, "HH:mm")) {
//
//        } else {
//
//        }
//        System.out.println("============");
//        // 标准时间
//        Date bt = bookingTime;
//        System.out.println("下单时间：" + DateUtil.format(bt));
//        Date ot = useCarTime;
//        System.out.println("用车时间：" + DateUtil.format(ot));
//
//
//        System.out.println("============");
//        List<List<Date>> lists = dateList(bookingTime, useCarTime, o1, o2);
//        for (List<Date> list : lists) {
////            System.out.println(DateUtil.format(list.get(0)) + " - " + DateUtil.format(list.get(1)) );
//            System.out.println("======aaaaaaaaa======");
//            re(bookingTime, useCarTime, list.get(0), list.get(1));
//            System.out.println("======aaaaaaaaa======");
//        }

//        ResellerTime resellerTime = new ResellerTime(UUID.randomUUID().toString(), "骑车");
//        resellerTime.start("取车");
//        Thread.sleep(2000L);
//        resellerTime.stop();
//
//        resellerTime.start("洗车");
//        Thread.sleep(2000L);
//        resellerTime.stop();
//
//        sddfds(resellerTime);
//
//        System.out.println(resellerTime.prettyPrint());
//        2.5.2 禁止下单时间：2019-12-17 10:00:00-2019-12-18 09:00:00-2019-12-18 16:00:00
//
//        2.5.2 当前下单时间：2019-12-17 12:49:30 用车时间：2019-12-18 04:32:10
        boolean inDate = isInDate(DateUtil.parseDate("2019-12-17 12:49:30"),
                DateUtil.parseDate("2019-12-17 10:00:00"),
                DateUtil.parseDate("2019-12-18 09:00:00"));
        System.out.println("----------");

        System.out.println(re(DateUtil.parseDate("2019-12-18 13:54:49"), DateUtil.parseDate("2019-12-18 15:46:10"), DateUtil.parseDate("2019-12-18 09:00:00"), DateUtil.parseDate("2019-12-18 23:00:00")) + " ms");
    }

    private static void sddfds(ResellerTime resellerTime) {

        System.out.println("sdfdsfds");

        resellerTime.start("555");
        resellerTime.stop();
    }


    private static List<List<Date>> dateList(Date bookingTime, Date useTime, String o1, String o2) {
        List<List<Date>> dateList = Lists.newArrayList();
        // 下单时间和用车时间隔了几天
        int day = new BigDecimal(useTime.getTime() - bookingTime.getTime()).divide(new BigDecimal(86400000), 0, RoundingMode.UP).intValue();
        // 下单时间前一天
        List<Date> beforeDay = Lists.newArrayList();
        addToDateList(beforeDay, DateUtil.addDays(DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o1, "yyyy-MM-dd HH:mm"), -1),
                DateUtil.addDays(DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o2, "yyyy-MM-dd HH:mm"), -1));
        dateList.add(beforeDay);
        // 下单时间当天
        List<Date> currentDay = Lists.newArrayList();
        currentDay.add(DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o1, "yyyy-MM-dd HH:mm"));
        currentDay.add(DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o2, "yyyy-MM-dd HH:mm"));
        addToDateList(currentDay,
                DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o1, "yyyy-MM-dd HH:mm"),
                DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o2, "yyyy-MM-dd HH:mm"));
        dateList.add(currentDay);
        // 下单时间和用车时间的区间
        for (int i = 1; i <= day; i++) {
            List<Date> list = Lists.newArrayList();
            addToDateList(list,
                    DateUtil.addDays(DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o1, "yyyy-MM-dd HH:mm"), i),
                    DateUtil.addDays(DateUtil.parseDate(DateUtil.format(bookingTime, "yyyy-MM-dd") + " " + o2, "yyyy-MM-dd HH:mm"), i));
            dateList.add(list);
        }
        return dateList;

    }

    private static void addToDateList(List<Date> dateList, Date date1, Date date2) {
        if (date1.after(date2)) {
            dateList.add(date1);
            dateList.add(DateUtil.addDays(date2, 1));
        } else {
            dateList.add(date1);
            dateList.add(date2);
        }
    }

    private static long re(Date bookingTime, Date userTime, Date ownerStartDate, Date ownerEndDate) {
        // 目标时间
        System.out.println("下单时间：" + DateUtil.format(bookingTime));
        System.out.println("用车时间：" + DateUtil.format(userTime));
        System.out.println("owner上班时间：" + DateUtil.format(ownerStartDate));
        System.out.println("owner上班时间：" + DateUtil.format(ownerStartDate));
        System.out.println("owner下班时间：" + DateUtil.format(ownerEndDate));
        // 开始时间
        long start1 = Math.min(bookingTime.getTime(), userTime.getTime());
        // 结束时间
        long end1 = Math.max(bookingTime.getTime(), userTime.getTime());
        // 开始时间
        long start2 = Math.min(ownerStartDate.getTime(), ownerEndDate.getTime());
        // 结束时间
        long end2 = Math.max(ownerStartDate.getTime(), ownerEndDate.getTime());

        // 具体算法如下
        // 首先看是否有包含关系
        boolean isContain = (start2 >= start1 && start2 <= end1) || (end2 >= start1 && end2 <= end1);
        if (isContain) {
            // 一定有重叠部分
            long sblong = start2 >= start1 ? start2 : start1;
            long eblong = end1 >= end2 ? end2 : end1;
            System.out.println("包含的开始时间是：" + DateUtil.format(new Date(sblong)) + "-结束时间是：" + DateUtil.format(new Date(eblong)) + " - 间隔时间为：" + (eblong - sblong) + "ms");
            return eblong - sblong;
        }
        if (start1 >= start2 && end1 <= end2) {
            return end1 - start1;
        }
        System.out.println("无重叠的时间段");
        return 0;
    }

    /**
     * 比较当前时间 是否在 范围内
     */
    public static boolean isInDate(Date date, Date start, Date end) {

        if (start.equals(end)) {
            // 一样说明是全天
            System.out.println("时间为：" + DateUtil.format(date));
            System.out.println("全天 返回true");
            return true;
        }

        if (start.after(end)) {
            // 跨日了
            end = DateUtil.addDays(end, 1);
        }

        if (date.before(start)) {
            end = DateUtil.addDays(end, -1);
            start = DateUtil.addDays(start, -1);
        }
        System.out.println("时间为：" + DateUtil.format(date));
        System.out.println("时间段为：" + DateUtil.format(start));
        System.out.println("时间段为：" + DateUtil.format(end));

        return date.getTime() >= start.getTime() && date.getTime() <= end.getTime();
    }

    /**
     * 比较当前时间 是否在timeArray 范围内
     */
    public static boolean isInDate(Date date, String timeStart, String timeEnd, String pattern) {

        Date start = DateUtil.parseDate(DateUtil.format(date, "yyyy-MM-dd") + " " + timeStart, "yyyy-MM-dd HH:mm");
        Date end = DateUtil.parseDate(DateUtil.format(date, "yyyy-MM-dd") + " " + timeEnd, "yyyy-MM-dd HH:mm");

        if (start.equals(end)) {
            // 一样说明是全天
            System.out.println("时间为：" + DateUtil.format(date));
            System.out.println("全天 返回true");
            return true;
        }

        if (start.after(end)) {
            // 跨日了
            end = DateUtil.addDays(end, 1);
        }

        if (date.before(start)) {
            end = DateUtil.addDays(end, -1);
            start = DateUtil.addDays(start, -1);
        }
        System.out.println("时间为：" + DateUtil.format(date));
        System.out.println("时间段为：" + DateUtil.format(start));
        System.out.println("时间段为：" + DateUtil.format(end));

        if (date.getTime() >= start.getTime() && date.getTime() <= end.getTime()) {
            return true;
        }
        return false;
    }

    public static boolean getDistance(Date date, String timeStart, String timeEnd, String pattern) {

        return false;
    }

}
