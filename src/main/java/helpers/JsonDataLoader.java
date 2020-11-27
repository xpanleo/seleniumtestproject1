package helpers;

import java.text.MessageFormat;
import java.util.Map;
import helpers.JsonDataLoader;

import static helpers.CommonSystemParameters.getInputDataJson;

public class JsonDataLoader {

    public static <T> T loadFromGeneralJson(String key, Class<T> clazz) {
        String jsonFilePath = getInputDataJson();

        Map<String, T> data = JsonParser.readFile(jsonFilePath, clazz);

        if (data != null) {
            return data.get(key);
        }
        return null;
    }
}
