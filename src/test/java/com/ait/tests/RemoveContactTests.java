package com.ait.tests;

import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: 1. Verify User is log out, 2. log in, 3. add contact
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else {
            app.getHeader().clickOnLoginLink();

            app.getUser().fillLoginRegForm(new User()
                    .setEmail("pv-6@gmail.co")
                    .setPassword("Price123$"));
            app.getUser().clickOnLoginButton();

            app.getHeader().clickOnAddLink();
            app.getContact().addContact(new Contact()
                    .setName("Karl")
                    .setSurName("Adam")
                    .setPhone("1234567890")
                    .setEmail("adam@gm.co")
                    .setAddress("Koblenz")
                    .setDesc("towart"));
            app.getContact().clickOnSaveButton();
        }
    }

    @Test
    public void removeContactTest() {
        int sizeBefore = app.getContact().sizeOfContacts();

        //click on Card
        app.getContact().removeContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();

        //verify Contact is removed
        Assert.assertEquals(sizeBefore-sizeAfter,1);
    }

}
