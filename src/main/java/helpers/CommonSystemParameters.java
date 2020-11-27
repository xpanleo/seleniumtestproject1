package helpers;

import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;
import org.apache.log4j.Logger;

public class CommonSystemParameters {


    protected static Logger logger = Logger.getLogger(CommonSystemParameters.class);

    public static String getSystemPropertyFile() {
        return "src/main/resources/system.properties";
    }

    public static String getWebDriverTimeOut() {
        return getSystemFileProperty("WEBDRIVER_WAIT_FOR_TIMEOUT");
    }

    public static String getSystemFileProperty(String property) {
        return System.getProperty(property, getPropFromPropertiesFile(getSystemPropertyFile(), property));
    }


    public static String getPropFromPropertiesFile(String fileName, String propertyName) {
        Properties conf = new Properties();

        try {
            conf.load(new FileReader(fileName));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        return conf.getProperty(propertyName);
    }

    public static String getInputDataJson() {
        String pathPattern = "inputData.json";
        String jsonFilePath = MessageFormat.format(pathPattern, getInputJsonPath());
        return jsonFilePath;
    }

    public static String getInputJsonPath() {
        return getSystemFileProperty("inputDataJsonPath");
    }

    public static String getConfFileProperty() {
        return getSystemFileProperty("APP_URL");
    }

}
