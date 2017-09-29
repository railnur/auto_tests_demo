package config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonschemas.basestate.Basestate;

public class JsonMapper {



    public JsonMapper(){
    }

    public static String jsonAsString(Basestate body) {
        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
}
