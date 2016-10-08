package com.vardanian;

import org.apache.log4j.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class WhatTimeIsIt {

    private static final Logger LOG = Logger.getLogger(WhatTimeIsIt.class);

    private static final Locale DEFAULT_LOCALE = Locale.getDefault();
    private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("messages", DEFAULT_LOCALE);

    private LocalTime timePoint = LocalTime.now();
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

    public static String showMessage(LocalTime localTime) {
        if (localTime == LocalTime.parse(DayPeriods.MORNING.toString())
                || localTime.isAfter(LocalTime.parse(DayPeriods.MORNING.toString()))
                && localTime.isBefore(LocalTime.parse(DayPeriods.DAY.toString()))) {
            LOG.info("Print good morning, World!");
            return MESSAGES.getString("my.morning");
        } else if (localTime == LocalTime.parse(DayPeriods.DAY.toString())
                || localTime.isAfter(LocalTime.parse(DayPeriods.DAY.toString()))
                && localTime.isBefore(LocalTime.parse(DayPeriods.EVENING.toString()))) {
            LOG.info("Print good day, World!");
            return MESSAGES.getString("my.day");
        } else if (localTime == LocalTime.parse(DayPeriods.EVENING.toString())
                || localTime.isAfter(LocalTime.parse(DayPeriods.EVENING.toString()))
                && localTime.isBefore(LocalTime.parse(DayPeriods.NIGHT.toString()))) {
            LOG.info("Print good evening, World!");
            return MESSAGES.getString("my.evening");
        } else if (localTime == LocalTime.parse(DayPeriods.NIGHT.toString())
                || localTime.isAfter(LocalTime.parse(DayPeriods.NIGHT.toString()))
                || localTime.isBefore(LocalTime.parse(DayPeriods.MORNING.toString()))) {
            LOG.info("Print good night, World!");
            return MESSAGES.getString("my.night");
        }
        LOG.warn("Print alarm, day periods didn't exist!");
        return "alarm";
    }

    public static void main(String[] args) {

        WhatTimeIsIt whatTimeIsIt = new WhatTimeIsIt();

        LocalTime localTime = whatTimeIsIt.getCurrentTime();
        System.out.println(showMessage(localTime));
    }
}
