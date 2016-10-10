package com.vardanian;

import org.testng.annotations.Test;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.Assert.assertEquals;

public class WhatTimeIsItTest {

    private static final Locale DEFAULT_LOCALE = Locale.getDefault();
    private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("messages", DEFAULT_LOCALE);


    private WhatTimeIsIt whatTimeIsIt = new WhatTimeIsIt();

    @Test
    public void testMorning(){
        String message = whatTimeIsIt.showMessage(LocalTime.parse("06:00:00"));
        assertEquals(MESSAGES.getString("my.morning"), message);
    }

    @Test
    public void testDay(){
        String message =  whatTimeIsIt.showMessage(LocalTime.parse("09:50:00"));
        assertEquals(MESSAGES.getString("my.day"), message);
    }

    @Test
    public void testEvening(){
        String message = whatTimeIsIt.showMessage(LocalTime.parse("22:00:00"));
        assertEquals(MESSAGES.getString("my.evening"), message);
    }

    @Test
    public void testNight(){
        String message = whatTimeIsIt.showMessage(LocalTime.parse("05:00:00"));
        assertEquals(MESSAGES.getString("my.night"), message);
    }
}
