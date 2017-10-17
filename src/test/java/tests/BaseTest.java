package tests;

import config.Configuration;
import config.KizGenerator;
import config.PropsGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jsonschemas.basestate.basestate.Basestate;
import jsonschemas.basestate.basestate.Kiz;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static config.JsonMapper.jsonAsString;
import static io.restassured.RestAssured.given;


/**
 * Класс содержащий базовые настройки и методы для написания автотестов.
 * Рекомендуется наследовать данный класс тестовым классом.
 *
 * @version 1.0
 */
public class BaseTest {

    private KizGenerator kizGenerator;
    private static String QUERY_ID = UUID.randomUUID().toString();
    private static List<Kiz> KIZ_LIST;
    private static PropsGenerator PROPS;
    protected final Logger myLog = LoggerFactory.getLogger(getCurrentClassName());
    protected Configuration configProps;
    private VerificationHelper verificationHelper;


    @Rule
    public TestName name = new TestName();


    @Before
    public void setUp() throws Exception {
        configProps = new Configuration();
        RestAssured.baseURI = configProps.getApiUri();
        PROPS = new PropsGenerator(configProps);
        kizGenerator = new KizGenerator(configProps);
        verificationHelper = new VerificationHelper(myLog, configProps);
        myLog.info("======================= Run " + name.getMethodName() + " ============================\n");
    }

    @After
    public void tearDown() throws Exception {
        myLog.info("======================= End " + name.getMethodName() + " ============================\n");
    }

    /**
     * Метод, который формирует и отправляет запрос методов трассировки на строну ядра
     * и после этого проверяет статус прохождения операции.
     *
     * @param opNumber Номер операции на стороне ядра
     * @param checkType Ожидаемый результат, true если ожидается успешное прохождение, false если ожидается отказ
     */
    protected void postBasestate(int opNumber, boolean checkType) throws Exception{

        String requestBody = createBody(opNumber); // Создаем тело запроса

        Response response;
        if (opNumber < 100) {
              myLog.info("REQUEST: \nURI: " + RestAssured.baseURI + "/kiz/basestate/" + opNumber + "\nBody: " + requestBody);
              response = given().
                      contentType("application/json").
                      body(requestBody).
                      when().
                      post("/kiz/basestate/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
              myLog.info("RESPONSE: " + response.body().asString());
          } else {
              myLog.info("REQUEST: \n" + "Method: POST + \n" + "URI: " + RestAssured.baseURI + "/lp/basestate/" + opNumber + "\n Body: " + requestBody);
              response = given().
                      contentType("application/json").
                      body(requestBody).
                      when().
                      post("/kiz/lp/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
              myLog.info("RESPONSE: " + response.body().asString());
          }

        if (checkType) verificationHelper.checkPositiveResultOfTraceOperation(QUERY_ID, KIZ_LIST, opNumber);
        else verificationHelper.checkNegativeResultOfTraceOperation(QUERY_ID);


    }





    /**
     * Генерирует тело для методов трассировки на стороне ядра по номеру операции.
     *
     * @param opNumber Номер операции
     * @return String, тело запроса
     */
    private String createBody (int opNumber){
        Basestate bst;
        QUERY_ID = UUID.randomUUID().toString();
        switch (opNumber){
            case 11:
            case 22:
                KIZ_LIST = kizGenerator.generate(configProps.getKizCount());
                bst = new Basestate(QUERY_ID, KIZ_LIST, PROPS.getProps(opNumber));
                break;
            case 12:
            case 17:
            case 18:
            case 25:
            case 28:
            case 33:
            case 52:
            case 301:
            case 305:
            case 306:
                bst = new Basestate(QUERY_ID, KIZ_LIST, PROPS.getProps(opNumber));
                break;
            case 23:
            case 24:
            case 31:
            case 32:
                List<Kiz> KIZ_LIST_COST = new ArrayList<Kiz>(kizGenerator.addMetadataCost(KIZ_LIST));
                bst = new Basestate(QUERY_ID, KIZ_LIST_COST, PROPS.getProps(opNumber));
                break;
            case 65:
                List<Kiz> KIZ_RELABEL = new ArrayList<Kiz>(kizGenerator.createRelabelingList(KIZ_LIST));
                bst = new Basestate(QUERY_ID, KIZ_RELABEL, PROPS.getProps(opNumber));
                KIZ_LIST = new ArrayList<Kiz>(kizGenerator.getNewKizList(KIZ_RELABEL));
                break;
            case 51:
                List<Kiz> KIZ_LIST_PRICE = new ArrayList<Kiz>(kizGenerator.addMetadataPrice(KIZ_LIST));
                bst = new Basestate(QUERY_ID, KIZ_LIST_PRICE, PROPS.getProps(opNumber));
                break;
            default:
                bst = new Basestate();
                break;
        }

        return jsonAsString(bst);
    }


    /**
     * Получить имя класса<br/>
     * Вспомогательный метод, необходим для того чтобы в каждом новом тестовом классе не объявлять логгер
     * @return String, имя класса
     */
    private static String getCurrentClassName(){
        try {
            throw new RuntimeException();
        } catch (RuntimeException e){
            return e.getStackTrace()[1].getClassName();
        }
    }
}
