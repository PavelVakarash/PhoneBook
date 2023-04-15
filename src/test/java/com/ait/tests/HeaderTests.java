package com.ait.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase{

    @Test
    public void HeaderElementsTest() {

    }
    public void HeaderElementsIsPresent() {
        Assert.assertTrue(app.getUser().isElementPresent2(By.cssSelector(".navbar-component_nav__1X_4m")));
    }
    public void PhoneBookLogoIsPresent() {
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[contains(text(),'PHONEBOOK')]")));
    }
    public void HomeButtonIsPresent() {
        Assert.assertTrue(app.getUser().isElementPresent2(By.className(".active")));
    }
    public void AboutButtonIsPresent() {
        Assert.assertTrue(app.getUser().isElementPresent2(By.cssSelector("[href='/about']")));
    }
    public void LoginButtonIsPresent() {
        Assert.assertTrue(app.getUser().isElementPresent2(By.xpath("//a[contains(text(),'LOGIN')]")));
    }

}
