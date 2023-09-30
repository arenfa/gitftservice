package com.gift.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
  

  public static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
  
  public static Date getDate(String dateAndTime) {
    Date date = null;
    try {
      date = dateFormat.parse(dateAndTime);
    } catch (ParseException e) {
        // TODO log
        e.printStackTrace();
    }
    return date;
  }
  
  public static Date addHoursToDate(Date date, int hours, int minutes) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.HOUR_OF_DAY, hours);
    calendar.add(Calendar.MINUTE, minutes);
    return calendar.getTime();
  }

  
  public static void main(String[] args) {
    System.out.println(addHoursToDate(new Date(), 1, 0));
    System.out.println(addHoursToDate(new Date(), 1, 30));
  }
}
