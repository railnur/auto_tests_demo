package tests;

import config.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jsonschemas.basestate.basestate.Kiz;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class VerificationHelper {

    private Logger myLog;
    private Configuration configProps;

    public VerificationHelper(Logger myLog, Configuration configProps){
        this.myLog = myLog;
        this.configProps = configProps;
    }



    public void checkPositiveResultOfTraceOperation (String queryId, List<Kiz> kizList, int opNumber) throws Exception {
        await().with().pollDelay(configProps.getKizCount(), SECONDS).and().pollInterval(5, SECONDS).await().until(checkAccept(queryId));
        for (Kiz kiz : kizList){
            checkSgtinStatus(kiz.getSign(), opNumber);
        }
    }


    public void checkNegativeResultOfTraceOperation (String queryId) throws Exception {
        await().with().pollDelay(configProps.getKizCount(), SECONDS).and().pollInterval(5, SECONDS).await().until(checkAccept(queryId));

    }


    private void checkSgtinStatus(String sgtin, int opNumber) throws IOException {
        KizFilterHelper kizFilterHelper = new KizFilterHelper(myLog);
        String actualStatus = kizFilterHelper.getSgtinStatus(sgtin);
        String expectedStatus = statusMap().get(opNumber);

        assertThat(actualStatus, equalTo(expectedStatus));
    }

    /**
     * Метод, который с определенным промежутком опрашивает ядро
     * с целью узнать результат прохождения операции.
     * Принимается на вход метод await() из библиотеки Awaitility
     * Пример использование:<br>
     *<pre>
     *          await().with().pollDelay(configProps.getKizCount(), SECONDS).and().pollInterval(5, SECONDS).await().until(checkAccept(QUERY_ID))
     *</pre>
     *
     * @param queryId Query_id операции
     * @return true, если операция обработна успешно, false если ответ отрицательный
     */
    private Callable<Boolean> checkAccept(final String queryId) throws Exception {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                myLog.info("REQUEST: \nURI: " + RestAssured.baseURI + "/kiz/result/" + queryId);
                Response response = given().
                        contentType("application/json").
                        when().
                        get("/kiz/result/" + queryId);
                myLog.info("RESPONSE: " + response.body().asString());
                return response.statusCode() == 200 &&
                        response.body().jsonPath().getInt("brokenKizCount") == 0 &&
                        response.body().jsonPath().getInt("code") == 0;
            }
        };
    }

    /**
     * Метод, который с определенным промежутком опрашивает ядро
     * с целью узнать результат прохождения операции.
     * Принимается на вход метод await() из библиотеки Awaitility
     * Пример использование:<br>
     *<pre>
     *          await().with().pollDelay(configProps.getKizCount(), SECONDS).and().pollInterval(5, SECONDS).await().until(checkAccept(QUERY_ID))
     *</pre>
     *
     * @param queryId Query_id операции
     * @return true, если операция обработна отрицательно, false если операция прошла успешно
     */
    private Callable<Boolean> checkReject(final String queryId) throws Exception {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                myLog.info("REQUEST: \n" + RestAssured.baseURI + "/kiz/result/" + queryId);
                Response response = given().
                        contentType("application/json").
                        when().
                        get("/kiz/result/" + queryId);
                myLog.info("RESPONSE: " + response.body().asString());
                return response.statusCode() == 200 &&
                        response.body().jsonPath().getInt("kizCount") == configProps.getKizCount() &&
                        response.body().jsonPath().getInt("brokenKizCount") == configProps.getKizCount();
            }
        };
    }

    private Map<Integer, String> statusMap (){
        Map<Integer, String> statusMap = new HashMap<Integer, String>();
        statusMap.put(11, "marked");
        if (configProps.getOrderType() == 1) statusMap.put(12, "in_circulation");
        else if (configProps.getOrderType() == 2) statusMap.put(12, "released_contract");
        statusMap.put(17, "transfered_to_owner");
        statusMap.put(18, "in_circulation");
        statusMap.put(22, "released_foreign");
        statusMap.put(31, "in_realization");
        statusMap.put(32, "in_circulation");
        return statusMap;
    }
}
