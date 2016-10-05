package com.vardanian;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WhatTimeIsIt {

    private static LocalDateTime timePoint;
    private static DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH");

    public static int currentTime(){
        timePoint = LocalDateTime.now();
        String text = timePoint.format(formatterHour);
        return Integer.parseInt(text);
    }

    public static String helloMessage(int hour){
        if(hour >= 6 && hour < 9) {
            return  "Good morning, World!";
        } else if (hour >= 9 && hour < 19) {
            return "Good day, World!";
        } else if (hour >= 19 && hour < 23) {
            return "Good evening, World!";
        } else if (hour >= 23 || hour < 6) {
            return "Good night, World!";
        }
        return "alarm";
    }

    public static void main(String[] args) {
        System.out.println(helloMessage(currentTime()));
    }
}
