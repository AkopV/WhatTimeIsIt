package com.vardanian;

import com.vardanian.WhatTimeIsIt;
import org.junit.Assert;
import org.testng.annotations.Test;

import static com.vardanian.WhatTimeIsIt.helloMessage;

public class WhatTimeIsItTest {

    @Test
    public void testMorning(){
        Assert.assertEquals("Good morning, World!", helloMessage(8));
    }

    @Test
    public void testDay(){
        Assert.assertEquals("Good day, World!", helloMessage(9));
    }

    @Test
    public void testEvening(){
        Assert.assertEquals("Good evening, World!", helloMessage(22));
    }

    @Test
    public void testNight(){
        Assert.assertEquals("Good night, World!", helloMessage(5));
    }
}
