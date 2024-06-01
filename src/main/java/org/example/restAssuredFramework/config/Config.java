package org.example.restAssuredFramework.config;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (var is = Config.class.getClassLoader().getResourceAsStream("config.properties")){
            properties.load(is);
        } catch (IOException e){
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getBaseUrl(){
        return properties.getProperty("base_url");
    }

    private Config(){}
}
