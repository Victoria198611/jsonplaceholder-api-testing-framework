package com.jsonplaceholder.api.config;

public class TestConfig {
    private static final String BASE_URL;

    static {
        // Citește environment-ul din config.properties
        String environment=ConfigReader.getProperty("environment");
        switch (environment.toUpperCase()){
            case "QA":
BASE_URL=ConfigReader.getProperty("qa_baseUrl");
break;

            case "DEV":
BASE_URL=ConfigReader.getProperty("dev_baseUrl");
break;
            case "PROD":
BASE_URL=ConfigReader.getProperty("prod_baseUrl");
break;
            default:
                throw new RuntimeException("Environment necunoscut:" + environment);
    }
}
public static String getBaseUrl(){
        return BASE_URL;
}
}