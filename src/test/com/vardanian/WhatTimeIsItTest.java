package com.vardanian;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;

import static com.vardanian.WhatTimeIsIt.showMessage;

public class WhatTimeIsItTest {

    @Test
    public void testMorningOne(){
        Assert.assertEquals("Good morning, World!", showMessage(6));
    }

    @Test
    public void testMorningTwo(){
        Assert.assertEquals("Good morning, World!", showMessage(LocalTime.parse("06:00:01")));
    }

    @Test
    public void testDayOne(){
        Assert.assertEquals("Good day, World!", showMessage(9));
    }

    @Test
    public void testDayTwo(){
        Assert.assertEquals("Good day, World!", showMessage(LocalTime.parse("09:50:00")));
    }

    @Test
    public void testEveningOne(){
        Assert.assertEquals("Good evening, World!", showMessage(22));
    }

    @Test
    public void testEveningTwo(){
        Assert.assertEquals("Good evening, World!", showMessage(LocalTime.parse("22:00:00")));
    }

    @Test
    public void testNightOne(){
        Assert.assertEquals("Good night, World!", showMessage(5));
    }

    @Test
    public void testNightTwo(){
        Assert.assertEquals("Good night, World!", showMessage(LocalTime.parse("05:00:00")));
    }
}
