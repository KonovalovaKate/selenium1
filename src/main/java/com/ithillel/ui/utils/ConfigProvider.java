package com.ithillel.ui.utils;

import java.io.IOException;
import java.util.Properties;
import java.util.PropertyPermission;

public final class ConfigProvider {
    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();
    public static final String BROWSER = prop.getProperty("browser");

    private ConfigProvider (){


    }
    private static Properties initProperties () {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file" + CONFIG_PATH);
        }
        return properties;

    }
}
