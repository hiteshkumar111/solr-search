package com.apple.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class DateUtils {

    public static String getEndTimeOfNthDayFromToday(int n){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        cal.add(Calendar.DATE, n);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(cal.getTime());
    }

    public static String getEndTimeOfNthDayFromToday(int n,SimpleDateFormat formatter){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        cal.add(Calendar.DATE, n);
        return formatter.format(cal.getTime());
    }


    public static String getStartTimeOfNthDayFromToday(int n){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        cal.add(Calendar.DATE, n);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(cal.getTime());
    }

    public static String getStartTimeOfNthDayFromToday(int n,SimpleDateFormat formatter){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);
        cal.add(Calendar.DATE, n);
        return formatter.format(cal.getTime());
    }
}
