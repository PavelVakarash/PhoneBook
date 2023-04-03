package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        //click on Login link
        clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        //fill registration form
        fillLoginRegForm("pv-6@gmail.co", "Price123$");
        //click on Registration button
        clickOnRegistrationButton();
        //verify Log out button is displayed
        Assert.assertTrue(isSignOutButtonPresent());
    }
}


