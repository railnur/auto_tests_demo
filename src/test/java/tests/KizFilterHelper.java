package tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jsonschemas.basestate.kizfilter.KizFilter;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import static config.JsonMapper.jsonAsString;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class KizFilterHelper {

    private KizFilter kizFilter;
    private String queryId;
    private JsonNode kizFilterResult;
    private Logger myLog;


    public KizFilterHelper(Logger myLog) throws IOException {
        this.myLog = myLog;
        this.queryId = UUID.randomUUID().toString();
        this.kizFilter = new KizFilter(queryId, 0, 1);
    }

    public KizFilterHelper(Logger myLog, String sgtin) throws IOException {
        this.myLog = myLog;
        this.queryId = UUID.randomUUID().toString();
        this.kizFilter = new KizFilter(queryId, 0, 1);
        this.kizFilterResult = getKizsBySgtin(sgtin);
    }

    private JsonNode getKizsBySgtin(String sgtin) throws IOException {
        kizFilter.setSgtin(sgtin);
        kizFilter.setPaginationLimit(1);
        kizFilter.setPaginationOffset(0);
        Response response;

        myLog.info("REQUEST: \nURI: " + RestAssured.baseURI + "/kiz/filter/" + "\nUsing KiZ: " + sgtin);
        given().
                contentType("application/json").
                    body(jsonAsString(kizFilter)).
                when().
                    post("/kiz/filter").
                then().
                    statusCode(200).
                extract().response();
        ObjectMapper mapper = new ObjectMapper();

        myLog.info("REQUEST: \nURI: " + RestAssured.baseURI + "/kiz/result/" + queryId);
        response = given().
                contentType("application/json").
                when().
                get("/kiz/result/" + queryId);

        return mapper.readTree(response.body().asString());
    }


    /**
     * Получить количество записей выборки</br>
     * @return Количество записей выборки
     * @param kizFilterResult
     */
    public int getRecordsCount(JsonNode kizFilterResult){
        return kizFilterResult.get("filtered_records_count").asInt();
    }

    /**
     * Получить массив записей из выборки</br>
     * @return Количество записей выборки
     * @param kizFilterResult
     */
    public ArrayNode getRecords(JsonNode kizFilterResult){
        return (ArrayNode) kizFilterResult.get("filtered_records");

    }

    /**
     * Получить статус Sgtin'a</br>
     *
     * @param sgtin String, номер КиЗ
     * @return String Статус КиЗ
     */
    public String getSgtinStatus(String sgtin) throws IOException {

        assertThat(getRecordsCount(kizFilterResult), equalTo(1));
        ArrayNode recordsArray = getRecords(kizFilterResult);
        assertNotNull(recordsArray);


        Iterator<JsonNode> recordsIterator = recordsArray.elements();

        while (recordsIterator.hasNext()) {
            JsonNode recordNode = recordsIterator.next();
            return recordNode.get("sgtin_state").get("internalState").asText();
        }
        return null;
    }

    public String getSgtinOwner(String sgtin) throws IOException {

        assertThat(getRecordsCount(kizFilterResult), equalTo(1));
        ArrayNode recordsArray = getRecords(kizFilterResult);
        assertNotNull(recordsArray);


        Iterator<JsonNode> recordsIterator = recordsArray.elements();

        while (recordsIterator.hasNext()) {
            JsonNode recordNode = recordsIterator.next();
            return recordNode.get("system_subj_id").asText();
        }
        return null;
    }
}