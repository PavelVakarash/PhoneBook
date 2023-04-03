package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase {

    // precondition: 1. User is logged out, 2. Log in
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        } else {
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            type(By.cssSelector("[placeholder='Email']"), "pv-6@gmail.co");
            type(By.cssSelector("[placeholder='Password']"), "Price123$");
            //click on Login button
            click(By.xpath("//button[contains(.,'Login')]"));
        }
    }

    @Test
    public void addContactPositiveTests() {
        // click on Add link
            click(By.cssSelector("a:nth-child(5)"));
        // fill add contact form
        type(By.cssSelector("input:nth-child(1)"),"Filip");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"1232123212321");
        type(By.cssSelector("input:nth-child(4)"),"fil@gm.co");
        type(By.cssSelector("input:nth-child(5)"),"client");
        type(By.cssSelector("input:nth-child(6)"),"toward");

        // click on Save button
        click(By.cssSelector(".add_form__2rsm2 button"));

        // verify new contact is added
        Assert.assertTrue(isContactCreated("Filip"));
    }

    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));

        for (WebElement el: contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
    @Test
    public void addContactNegativeTests() {
        // click on Add link
        click(By.cssSelector("a:nth-child(5)"));
        // fill add contact form
        type(By.cssSelector("input:nth-child(1)"),"Filip");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"1232");
        type(By.cssSelector("input:nth-child(4)"),"fil@gm.co");
        type(By.cssSelector("input:nth-child(5)"),"client");
        type(By.cssSelector("input:nth-child(6)"),"toward");

        // click on Save button
        click(By.cssSelector(".add_form__2rsm2 button"));

        // verify new contact is added
        Assert.assertFalse(isContactCreated("Filip"));
    }
}
