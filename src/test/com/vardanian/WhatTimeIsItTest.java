package com.vardanian;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalTime;

import static org.testng.Assert.assertEquals;

public class WhatTimeIsItTest {

    private WhatTimeIsIt whatTimeIsIt;

    @Test
    public void testMorningOne(){
        assertEquals("Good morning, World!", whatTimeIsIt.showMessage(6));
    }

    @Test
    public void testMorningTwo(){
        assertEquals("Good morning, World!", whatTimeIsIt.showMessage(LocalTime.parse("06:00:01")));
    }

    @Test
    public void testDayOne(){
        assertEquals("Good day, World!", whatTimeIsIt.showMessage(9));
    }

    @Test
    public void testDayTwo(){
        assertEquals("Good day, World!", whatTimeIsIt.showMessage(LocalTime.parse("09:50:00")));
    }

    @Test
    public void testEveningOne(){
        assertEquals("Good evening, World!", whatTimeIsIt.showMessage(22));
    }

    @Test
    public void testEveningTwo(){
        assertEquals("Good evening, World!", whatTimeIsIt.showMessage(LocalTime.parse("22:00:00")));
    }

    @Test
    public void testNightOne(){
        assertEquals("Good night, World!", whatTimeIsIt.showMessage(5));
    }

    @Test
    public void testNightTwo(){
        assertEquals("Good night, World!", whatTimeIsIt.showMessage(LocalTime.parse("05:00:00")));
    }
}
