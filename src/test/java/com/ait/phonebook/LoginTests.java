package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test(priority = 1)
    public void loginRegisteredUserPositiveTest() {
        //click on Login link
        clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        //fill registration form
        fillLoginRegForm("pv-6@gmail.co", "Price123$");
        //click on Login button
        clickOnLoginButton();
        //verify User logged in
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test(priority = 2)
    public void loginRegisteredUserWithInvalidPasswordNegativeTest() {
        //click on Login link
        clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        //fill registration form
        fillLoginRegForm("pv-6@gmail.co", "Price123$$");
        //click on Login button
        clickOnLoginButton();
        //check alert is appeared
        Assert.assertTrue(isAlertPresent());
    }

    @Test(priority = 3)
    public void loginRegisteredUserWithInvalidEmailNegativeTest() {
        //click on Login link
        clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        //fill registration form
        fillLoginRegForm("pv.co", "Price123$");
        //click on Login button
        clickOnLoginButton();
        //check alert is appeared
        Assert.assertTrue(isAlertPresent());
    }
}
