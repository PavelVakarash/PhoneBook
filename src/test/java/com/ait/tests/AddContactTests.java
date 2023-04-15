package com.ait.tests;

import com.ait.phonebook.fw.DataProviderContact;
import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {



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
        }
    }

    @Test
    public void addContactPositiveTests() {
        app.getContact().pause(2000);
        //click on Add link
        app.getHeader().clickOnAddLink();
        //fill add contact form
        app.getContact().addContact(new Contact()
                .setName("Karl")
                .setSurName("Adam")
                .setPhone("1234567890")
                .setEmail("adam@gm.co")
                .setAddress("Koblenz")
                .setDesc("torwart"));

        //click on Save button
        app.getContact().clickOnSaveButton();

        //verify new contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Karl"));
    }

    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromDataProviderTests(String name, String lastName, String phone, String email,
                                                        String address, String desc) {
        app.getHeader().clickOnAddLink();
        app.getContact().addContact(new Contact()
                .setName(name)
                .setSurName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromCSVFileTests(Contact contact) {

        app.getHeader().clickOnAddLink();
        app.getContact().addContact(contact);
        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
    }
}
