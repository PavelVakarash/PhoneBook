package com.ait.phonebook;

import com.ait.phonebook.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {
    @Test
    public void openHomePageTest() {
        //verify to displayed Home Component form
        //isHomeComponentPresent();
        // System.out.println("Home Component is " + isHomeComponentPresent());
        // isHomeComponentPresent2();
        // isElementPresent(By.cssSelector("div:nth-child(2)>div>div"));
        Assert.assertTrue(isHomeComponentPresent());
    }
}
