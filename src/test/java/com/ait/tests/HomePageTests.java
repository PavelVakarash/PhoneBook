package com.ait.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void openHomePageTest() {

        Assert.assertTrue(app.getHome().isHomeComponentPresent());
    }
}
