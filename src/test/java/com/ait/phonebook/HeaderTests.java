package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

    @Test
    public void ElementsHeaderTest() {
        Assert.assertTrue(isElementPresent2(By.cssSelector(".navbar-component_nav__1X_4m")));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[contains(text(),'PHONEBOOK')]")));
        Assert.assertTrue(isElementPresent2(By.className(".active")));
        Assert.assertTrue(isElementPresent2(By.cssSelector("[href='/about']")));
        Assert.assertTrue(isElementPresent2(By.xpath("//a[contains(text(),'LOGIN')]")));

    }
}
