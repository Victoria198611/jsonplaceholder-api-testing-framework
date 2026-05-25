package com.jsonplaceholder.api.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    static {
        try {
            //Incarca fisierul properties din resources
            String path = "src/test/resources/config.properties";
            FileInputStream inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Nu s-a putut incarca fisierul de configurare:" + e.getMessage());
        }
    }
// Returnează valoarea unei chei din config.properties
public static String getProperty(String key){
    String value = properties.getProperty(key);
    if (value == null) {
        throw new RuntimeException("Cheia '" + key + "'nu exista in config properties");
    }
    return value;
}
}