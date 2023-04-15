package com.ait.phonebook.fw;

import com.ait.phonebook.model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

    public class DataProviderUser {

        @DataProvider
        public static Iterator<Object[]> invalidRegistrationDataFromCSV() throws IOException {
            List<Object[]> list = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/invalid_registration.csv")));
            String line = reader.readLine();

            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{new User().setEmail(split[0]).setPassword(split[1])});
                line = reader.readLine();
            }
            return list.iterator();
        }

    }


