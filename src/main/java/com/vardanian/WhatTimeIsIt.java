package com.vardanian;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class WhatTimeIsIt {

    private Locale ruLocale = new Locale("ru", "RU");
    private ResourceBundle bundle = ResourceBundle.getBundle("messages_ru_RU", ruLocale);
    private LocalTime timePoint = LocalTime.now();;
    private DateTimeFormatter formatterHour;

    public WhatTimeIsIt() {
    }

    public int getCurrentHour() {
        formatterHour = DateTimeFormatter.ofPattern("HH");
        String hour = timePoint.format(formatterHour);
        return Integer.parseInt(hour);
    }

    public LocalTime getCurrentTime() {
        formatterHour = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(timePoint.format(formatterHour));
        return localTime;
    }

    public String showMessage(int hour) {
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

    public String showMessage(LocalTime localTime) {
        if (localTime.isAfter(LocalTime.parse(DayPeriods.MORNING.toString()))
                && localTime.isBefore(LocalTime.parse(DayPeriods.DAY.toString()))) {
            return bundle.getString("my.morning");
        } else if (localTime.isAfter(LocalTime.parse(DayPeriods.DAY.toString()))
                && localTime.isBefore(LocalTime.parse(DayPeriods.EVENING.toString()))) {
            return bundle.getString("my.day");
        } else if (localTime.isAfter(LocalTime.parse(DayPeriods.EVENING.toString()))
                && localTime.isBefore(LocalTime.parse(DayPeriods.NIGHT.toString()))) {
            return bundle.getString("my.evening");
        } else if (localTime.isAfter(LocalTime.parse(DayPeriods.NIGHT.toString()))
                || localTime.isBefore(LocalTime.parse(DayPeriods.MORNING.toString()))) {
            return bundle.getString("my.night");
        }
        return "alarm";
    }

    public void messageValues(ResourceBundle bundle) {
        System.out.println(bundle.getString("my.morning"));
        System.out.println(bundle.getString("my.day"));
        System.out.println(bundle.getString("my.evening"));
        System.out.println(bundle.getString("my.night"));
    }

    public static void main(String[] args) {

        WhatTimeIsIt whatTimeIsIt = new WhatTimeIsIt();

        LocalTime localTime = whatTimeIsIt.getCurrentTime();
        System.out.println(whatTimeIsIt.showMessage(localTime));
    }
}
