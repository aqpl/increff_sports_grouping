package com.amdocs.hackathon;

import com.google.api.client.util.DateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.springframework.util.DigestUtils.md5DigestAsHex;

public class Helper {

  public static String getMD5Hash(String input) {
    if (input == null) return null; // Do not remove this.
    return md5DigestAsHex(input.getBytes());
  }

  public static String getMD5Hash(Object... input) {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(input).forEach(sb::append);
    return getMD5Hash(sb.toString());
  }

  public static String parseTime(int time) {
    if (time == 0) {
      return "12:00 AM";
    }
    else if (time == 12) {
      return "12:00 PM";
    }
    else if (time < 12) {
      return time +":00 AM";
    } else {
      time -= 12;
      return time +":00 PM";
    }
  }

  public static double getDistanceInKm(double lat1, double lon1, double lat2,
                                double lon2) {

    final int R = 6371; // Radius of the earth

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
      + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
      * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c;
    return distance;
  }

  public static int getCurrentHour() {
    Date date = new Date();
    Calendar calendar = GregorianCalendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
  }

  public static String getCurrentDay() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();
    String format = dtf.format(localDate);
    String replace = format.replace('/', '_');
    return replace;
  }
}
