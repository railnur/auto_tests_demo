package tests;

import config.Configuration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jsonschemas.basestate.basestate.Kiz;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.List;
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
        if (opNumber != 65) {
            for (Kiz kiz : kizList) {
                checkSgtinStatus(kiz.getSign(), opNumber);
                checkSgtinOwner(kiz.getSign(), opNumber);
            }
        }
    }


    public void checkNegativeResultOfTraceOperation (String queryId) throws Exception {
        await().with().pollDelay(configProps.getKizCount(), SECONDS).and().pollInterval(5, SECONDS).await().until(checkAccept(queryId));

    }

    /**
     * Метод для проверки того, что КиЗ получил нужный статус после оперделенной операции</br>
     * @param sgtin КиЗ
     * @param opNumber Номер операции
     */
    private void checkSgtinStatus(String sgtin, int opNumber) throws IOException {
        KizFilterHelper kizFilterHelper = new KizFilterHelper(myLog, sgtin);
        String actualStatus = kizFilterHelper.getSgtinStatus(sgtin);
        String expectedStatus = statusMap(opNumber);

        assertThat(actualStatus, equalTo(expectedStatus));
    }

    /**
     * Метод для проверки того, что у КиЗа корректный владелец после оперделенной операции</br>
     * @param sgtin КиЗ
     * @param opNumber Номер операции
     */
    private void checkSgtinOwner(String sgtin, int opNumber) throws IOException {
        KizFilterHelper kizFilterHelper = new KizFilterHelper(myLog, sgtin);
        String actualOwner = kizFilterHelper.getSgtinOwner(sgtin);
        String expectedOwner = getOwner(opNumber);

        assertThat(actualOwner, equalTo(expectedOwner));
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


    /**
     *
     * @return
     */
    private String statusMap (int opNumber){

        switch (opNumber){
            case 11: return "marked";
            case 12 :
                if (configProps.getOrderType() == 1) return "in_circulation";
                else return "released_contract";
            case 17: return "transfered_to_owner";
            case 18: return "in_circulation";
            case 22: return "released_foreign";
            case 23: return "shipped";
            case 24: return "arrived";
            case 25: return "declared";
            case 31:
                if (configProps.getAcceptType() == 1) return "in_realization";
                else return "in_circulation";
            case 32:
                if (configProps.getAcceptType() == 1) return "in_circulation";
                else return "in_realization";
            case 51: return "in_sale";
            case 52:
                if (configProps.getWithdrawalType() < 500) return "out_of_circulation";
                else return "reexported";
            case 301:
                if (configProps.getControlType() == 1 || configProps.getControlType() == 3)  return "out_of_circulation";
                else if (configProps.getControlType() == 2) return "lp_sampled";
            case 305: return "in_discount_prescription_sale";
            default: return null;
        }
    }

    private String getOwner (int opNumber){

        switch (opNumber){
            case 11:
            case 12:
            case 17:
            case 18:
            case 25:
            case 51:
            case 52:
            case 301:
            case 305:
                return configProps.getSubjectIdRf();
            case 22:
            case 23:
            case 24:
                return configProps.getSubjectIdForeign();
            case 31:
                if (configProps.getAcceptType() == 1) return configProps.getSubjectIdRf();
                else return configProps.getConsigneeId();
            case 32:
                if (configProps.getAcceptType() == 1) return configProps.getSubjectIdRf();
                else return configProps.getConsigneeId();
            default: return null;
        }
    }
}
