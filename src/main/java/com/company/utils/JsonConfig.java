package com.company.utils;

import com.company.model.User;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonConfig {
    public Object[][] data () {
        Gson gson = new Gson();
        try {
            User[] user = gson.fromJson(new FileReader("src/main/resources/data.json"), User[].class);

            Object[][] data = new Object[user.length][1];
            for (int i = 0; i < user.length; i++) {
                data[i][0] = user[i];
            }
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
