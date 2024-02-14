package talrise.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;


        static {

            try {
                String path = "src/test/resources/configuration.properties";
                FileInputStream input = new FileInputStream(path);
                properties = new Properties();
                properties.load(input);

                input.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

    public static void set(String keyName, String value) {
            properties.setProperty(keyName, value);
    }

}