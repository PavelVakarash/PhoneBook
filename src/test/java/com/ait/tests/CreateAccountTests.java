package com.ait.tests;

import com.ait.phonebook.fw.DataProviderContact;
import com.ait.phonebook.fw.DataProviderUser;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("pv-6@gmail.co")
                .setPassword( "Price123$"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test(enabled = false)
    public void newUserRegistrationWithInvalidPasswordNegativeTest() {
        app.getHeader().clickOnLoginLink();
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        app.getUser().fillLoginRegForm(new User()
                .setEmail("pv-7@gmail.co")
                .setPassword( "qwerty"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertFalse(app.getHeader().isSignOutButtonPresent());
    }

    @Test(dataProvider = "invalidRegistrationDataFromCSV", dataProviderClass = DataProviderUser.class)
    public void newUserRegistrationWithInvalidPasswordNegativeFromCSVTest(User user) {
        app.getHeader().clickOnLoginLink();
        app.getUser().fillLoginRegForm(user);
        app.getUser().clickOnRegistrationButton();
    }
}


