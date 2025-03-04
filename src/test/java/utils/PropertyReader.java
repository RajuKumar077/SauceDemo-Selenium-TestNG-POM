package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static Properties readProperty() {
        // Create a Properties object to store key-value pairs from the config file
        Properties prop = new Properties(); // Initialize it to avoid returning null
        // Define the path to the configuration file
        String fileName = ".\\src\\test\\resources\\config\\config.properties";

        // Use try-with-resources to automatically close the file input stream
        try (FileInputStream fis = new FileInputStream(fileName)) {
            // Load the properties file into the Properties object
            prop.load(fis);
        } catch (FileNotFoundException e) {
            // Handle case where the file is not found and print an error message
            System.out.println("File name or file path is not correct: " + fileName);
        } catch (IOException e) {
            // Handle other I/O exceptions and print stack trace
            e.printStackTrace();
        }

        // Return the loaded Properties object
        return prop;
    }
}
