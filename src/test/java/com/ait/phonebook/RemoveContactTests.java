package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: 1. Verify User is log out, 2. log in, 3. add contact
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else {
            clickOnLoginLink();

            fillLoginRegForm("pv-6@gmail.co", "Price123$");
            clickOnLoginButton();

            clickOnAddLink();
            addContact("Filip", "Adam", "1232123212321", "fil@gm.co", "client", "toward");
            clickOnSaveButton();
        }
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();

        //click on Card
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();

        //verify Contact is removed
        Assert.assertEquals(sizeBefore-sizeAfter,1);
    }

}
