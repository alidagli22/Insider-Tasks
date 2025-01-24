package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;
    private final String propertyFilePath = "src/main/resources/config.properties";


    public PropertiesReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public long getImplicityWait() {
        return Long.parseLong(properties.getProperty("implicitlyWait"));
    }

    public long getPageLoadTimeout() {
        return Long.parseLong(properties.getProperty("pageLoadTimeout"));
    }

}
