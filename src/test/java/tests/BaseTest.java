package tests;

import config.Configuration;
import config.KizGenerator;
import config.PropsGenerator;
import config.ToLoggerPrintStream;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jsonschemas.basestate.Basestate;
import jsonschemas.basestate.Kiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

import static config.JsonMapper.jsonAsString;
import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;


public class BaseTest {

    private static KizGenerator kizGenerator = new KizGenerator();
    public static Response RESPONSE;
    private static String QUERY_ID = UUID.randomUUID().toString();
    private static List<Kiz> KIZ_LIST;
    private static List<Kiz> KIZ_LIST_COST;
    private static List<Kiz> KIZ_LIST_PRICE;
    private static PropsGenerator PROPS;
    private static List<Kiz> KIZ_RELABEL;
    private Logger myLog;
    private Configuration configProps = new Configuration();


    public BaseTest(){
        myLog = LoggerFactory.getLogger(BaseTest.class);
        ToLoggerPrintStream loggerPrintStream = new ToLoggerPrintStream(myLog);
        RestAssured.baseURI = configProps.getApiUri();
       // RestAssured.config = RestAssured.config().logConfig(new LogConfig( loggerPrintStream.getPrintStream(), true ));
        KIZ_LIST = new ArrayList<Kiz>();
        KIZ_LIST_COST = new ArrayList<Kiz>();
        KIZ_LIST_PRICE = new ArrayList<Kiz>();
        PROPS = new PropsGenerator();

    }

    public void postBasestate (int opNumber, boolean checkType) throws Exception{


         myLog.debug("\n-------------------------------------------\n");
          if (opNumber < 100) {
              given().
                      contentType("application/json").
                      body(jsonAsString(createBody(opNumber))).
                      log().uri().log().body().
                      when().
                      post("/kiz/basestate/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
          } else {
              given().
                      contentType("application/json").
                      body(jsonAsString(createBody(opNumber))).
                      log().all().
                      when().
                      post("/kiz/lp/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
          }

        myLog.debug("\n-------------------------------------------\n");
        if (checkType) await().atMost(5 * configProps.getKizCount(), SECONDS).until(checkAccept(QUERY_ID)); //await().with().pollDelay(100, SECONDS).and().pollInterval(5 * KIZ_COUNT, SECONDS).await().until(checkAccept(QUERY_ID))
        else await().atMost(5 * configProps.getKizCount(), SECONDS).until(checkAccept(QUERY_ID));

    }


    private Callable<Boolean> checkAccept(final String queryId) throws Exception {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                myLog.debug("\n-------------------------------------------\n");
                Response response = given().
                        contentType("application/json").
                        log().uri().log().method().
                        when().
                        get("/kiz/result/" + QUERY_ID);
                System.out.println(response.body().asString());
                myLog.debug("\n-------------------------------------------\n");
                return response.statusCode() == 200 &&
                        response.body().jsonPath().getInt("brokenKizCount") == 0 &&
                        response.body().jsonPath().getInt("code") == 0;
            }
        };
    }


    private Callable<Boolean> checkReject(final String queryId) throws Exception {
            return new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    Response response = given().
                            contentType("application/json").
                            log().all().
                            when().
                            get("/kiz/result/" + QUERY_ID);
                    myLog.debug(response.body().asString());
                    return response.statusCode() == 200 &&
                            response.body().jsonPath().getInt("kizCount") == configProps.getKizCount() &&
                            response.body().jsonPath().getInt("brokenKizCount") == configProps.getKizCount();
                }
            };
        }


    private Basestate createBody (int opNumber){
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
                KIZ_LIST_COST = new ArrayList<Kiz>(kizGenerator.addMetadataCost(KIZ_LIST));
                bst = new Basestate(QUERY_ID, KIZ_LIST_COST, PROPS.getProps(opNumber));
                break;
            case 65:
                KIZ_RELABEL = new ArrayList<Kiz>(kizGenerator.createRelabelingList(KIZ_LIST));
                bst = new Basestate(QUERY_ID, KIZ_RELABEL, PROPS.getProps(opNumber));
                KIZ_LIST = new ArrayList<Kiz>(kizGenerator.getNewKizList(KIZ_RELABEL));
                break;
            case 51:
                KIZ_LIST_PRICE = new ArrayList<Kiz>(kizGenerator.addMetadataPrice(KIZ_LIST));
                bst = new Basestate(QUERY_ID, KIZ_LIST_PRICE, PROPS.getProps(opNumber));
                break;
            default:
                bst = new Basestate();
                break;
        }

        return bst;
    }


}
