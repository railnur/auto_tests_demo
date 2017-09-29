/*
package tests.basestatetests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Configuration;
import config.KizGenerator;
import io.restassured.RestAssured;
import jsonschemas.basestate.Bst11;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.*;

import java.util.UUID;


public class ProductEmissionTest extends Configuration {

    public static Response response;

    public ProductEmissionTest() {
        RestAssured.baseURI = API_URI;
    }

    @Test
    public void createKizsTest(){

        Properties props = new Properties();
        props.setSystemSubjId(SUBJECT_ID);
        props.setOpDate(OP_DATE);
        props.setOrderType(2);
        props.setHsCode(HS_CODE);
        props.setGtin(GTIN);
        props.setBatch(BATCH);
        props.setExpDate(EXP_DATE);

        Bst11 body = new Bst11(UUID.randomUUID().toString(), new KizGenerator(KIZ_COUNT).generate(),  props);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        response = given().
                contentType("application/json").
                body(json).
                when().
                post("/kiz/basestate/11").
                then().
                //statusCode(200).
                        extract().response();

        System.out.print(response.asString());
    }
}
*/
