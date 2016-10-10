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
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private LocalTime getCurrentTime() {
        LocalTime timePoint = LocalTime.now();
        return LocalTime.parse(timePoint.format(TIME_FORMATTER));
    }

    public String showMessage(LocalTime localTime) {
        String message = "";
        if (localTime == getPeriod(DayPeriods.MORNING.toString())
                || isDefinedDayPeriod(localTime,getPeriod(DayPeriods.MORNING.toString()), getPeriod(DayPeriods.DAY.toString()))){
            LOG.info("Print good morning, World!");
            message = MESSAGES.getString("my.morning");
        } else if (localTime == getPeriod(DayPeriods.DAY.toString())
                || isDefinedDayPeriod(localTime, getPeriod(DayPeriods.DAY.toString()), getPeriod(DayPeriods.EVENING.toString()))) {
            LOG.info("Print good day, World!");
            message =  MESSAGES.getString("my.day");
        } else if (localTime == getPeriod(DayPeriods.EVENING.toString())
                || isDefinedDayPeriod(localTime,getPeriod(DayPeriods.EVENING.toString()), getPeriod(DayPeriods.NIGHT.toString()))){
            LOG.info("Print good evening, World!");
            message = MESSAGES.getString("my.evening");
        } else if (localTime == getPeriod(DayPeriods.NIGHT.toString())
                || localTime.isAfter(getPeriod(DayPeriods.NIGHT.toString()))
                || localTime.isBefore(getPeriod(DayPeriods.MORNING.toString()))) {
            LOG.info("Print good night, World!");
            message = MESSAGES.getString("my.night");
        } else {
            message = "Error";
            LOG.warn("Print alarm, day periods didn't exist!");
        }
        return message;
    }

    private LocalTime getPeriod(String period) {
        return LocalTime.parse(period);
    }

    private boolean isDefinedDayPeriod(LocalTime current, LocalTime start, LocalTime end) {
        return current.isAfter(start) && current.isBefore(end);
    }

    public static void main(String[] args) {

        WhatTimeIsIt whatTimeIsIt = new WhatTimeIsIt();

        LocalTime localTime = whatTimeIsIt.getCurrentTime();
        String message = whatTimeIsIt.showMessage(localTime);
        System.out.println(message);
    }
}
