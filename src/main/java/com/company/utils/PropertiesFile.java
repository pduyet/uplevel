package com.company.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {
    private static Properties properties;

    static String projectPath = System.getProperty("user.dir");
    static String propertiesFilePath = "src/test/resources/config.properties";
    static String fullPathPropertiesFile = projectPath + "/" + propertiesFilePath;

    public static void setPropertiesFile() {
        properties = new Properties();

        try {
            FileInputStream fileIn = new FileInputStream(fullPathPropertiesFile);

            properties.load(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getPropValue(String key) {
        String value;
        try {
            value = properties.getProperty(key);
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
