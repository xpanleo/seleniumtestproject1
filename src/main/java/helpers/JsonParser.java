package helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.FileInputStream;
import java.util.Map;

public class JsonParser {

    private static ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> Map<String, T> readFile(String jsonfile, Class<T> type) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (FileInputStream f = new FileInputStream(jsonfile)) {
            TypeFactory typeFactory = objectMapper.getTypeFactory();
            JavaType inner = typeFactory.constructParametricType(Map.class, String.class, type);
            return objectMapper.readValue(f, inner);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
