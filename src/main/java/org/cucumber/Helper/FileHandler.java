package org.cucumber.Helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class FileHandler {

    public String fileReader(String filePath, String param) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "UTF-8")) {
            Properties properties = new Properties();
            properties.load(isr);
            return properties.get(param).toString();
        }
    }
}


