package com.vardanian;

import java.text.MessageFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class WhatTimeIsIt {

    public static int getCurrentHour() {
        LocalTime timePoint;
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH");
        timePoint = LocalTime.now();
        String hour = timePoint.format(formatterHour);
        return Integer.parseInt(hour);
    }

    public static LocalTime getCurrentTime() {
        LocalTime timePoint;
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm:ss");
        timePoint = LocalTime.now();
        LocalTime localTime = LocalTime.parse(timePoint.format(formatterHour));
        return localTime;
    }

    public static String showMessage(int hour) {
        if (hour >= 6 && hour < 9) {
            return "Good morning, World!";
        } else if (hour >= 9 && hour < 19) {
            return "Good day, World!";
        } else if (hour >= 19 && hour < 23) {
            return "Good evening, World!";
        } else if (hour >= 23 || hour < 6) {
            return "Good night, World!";
        }
        return "alarm";
    }

    public static String showMessage(LocalTime localTime) {
        if (localTime.isAfter(LocalTime.parse(TimesOfDay.MORNING.toString()))
                && localTime.isBefore(LocalTime.parse(TimesOfDay.DAY.toString()))) {
            return "Good morning, World!";
        } else if (localTime.isAfter(LocalTime.parse(TimesOfDay.DAY.toString()))
                && localTime.isBefore(LocalTime.parse(TimesOfDay.EVENING.toString()))) {
            return "Good day, World!";
        } else if (localTime.isAfter(LocalTime.parse(TimesOfDay.EVENING.toString()))
                && localTime.isBefore(LocalTime.parse(TimesOfDay.NIGHT.toString()))) {
            return "Good evening, World!";
        } else if (localTime.isAfter(LocalTime.parse(TimesOfDay.NIGHT.toString()))
                || localTime.isBefore(LocalTime.parse(TimesOfDay.MORNING.toString()))) {
            return "Good night, World!";
        }
        return "alarm";
    }

    public static void messageValues(ResourceBundle bundle) {
        System.out.println("morning " + bundle.getString("my.morning"));
        System.out.println("day " + bundle.getString("my.day"));
        System.out.println("evening " + bundle.getString("my.evening"));
        System.out.println("night " + bundle.getString("my.night"));
    }

    public static void main(String[] args) {
        LocalTime localTome = getCurrentTime();
        System.out.println(showMessage(localTome));

        Properties p = new Properties();
        p.setProperty("messages.myMessage", "This message is for {0} in {1}");
        String s = MessageFormat.format(
                p.getProperty("messages.myMessage"), "foo", "bar");
        System.out.println(s);

        ResourceBundle bundle1 = ResourceBundle.getBundle("messages");
        messageValues(bundle1);

        Locale defaultLocale = Locale.getDefault();
        ResourceBundle bundle2 = ResourceBundle.getBundle("messages", defaultLocale);
        messageValues(bundle2);
    }
}
