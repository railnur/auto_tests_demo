package tests;

import config.Configuration;
import config.KizGenerator;
import config.PropsGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import jsonschemas.basestate.Basestate;
import jsonschemas.basestate.Kiz;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

import static config.JsonMapper.jsonAsString;
import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class BaseTest extends Configuration{

    private static KizGenerator kizGenerator = new KizGenerator();
    public static Response RESPONSE;
    public static String QUERY_ID = UUID.randomUUID().toString();
    public static List<Kiz> KIZ_LIST;
    public static List<Kiz> KIZ_LIST_COST;
    public static List<Kiz> KIZ_LIST_PRICE;
    public static PropsGenerator PROPS;
    public static List<Kiz> KIZ_RELABEL;


    public BaseTest(){
        RestAssured.baseURI = API_URI;
        KIZ_LIST = kizGenerator.generate(KIZ_COUNT);
        KIZ_LIST_COST = new ArrayList<Kiz>(kizGenerator.addMetadataCost(KIZ_LIST));
        KIZ_LIST_PRICE = new ArrayList<Kiz>(kizGenerator.addMetadataPrice(KIZ_LIST));
        PROPS = new PropsGenerator();

    }

    public void postBasestate (int opNumber, boolean checkType) throws Exception{


        System.out.println(jsonAsString(createBody(opNumber)));
          Response response;
          if (opNumber < 100) {
              System.out.println(RestAssured.baseURI  + "/kiz/basestate/" + opNumber);
              response = given().
                      contentType("application/json").
                      body(jsonAsString(createBody(opNumber))).
                      when().
                      post("/kiz/basestate/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
          } else {
              System.out.println(RestAssured.baseURI  + "/kiz/lp/" + opNumber);
              response = given().
                      contentType("application/json").
                      body(jsonAsString(createBody(opNumber))).
                      when().
                      post("/kiz/lp/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
          }
            System.out.println(response.body().asString());

        if (checkType)  await().atMost(5 * KIZ_COUNT, SECONDS).until(checkAccept(QUERY_ID));
          else await().atMost(5 * KIZ_COUNT, SECONDS).until(checkAccept(QUERY_ID));

          SECONDS.sleep(1);

    }


    private Callable<Boolean> checkAccept(final String queryId) throws Exception {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                Response response = given().
                        contentType("application/json").
                        when().
                        get("/kiz/result/" + QUERY_ID);
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
                            when().
                            get("/kiz/result/" + QUERY_ID);
                    return response.statusCode() == 200 &&
                            response.body().jsonPath().getInt("kizCount") == KIZ_COUNT &&
                            response.body().jsonPath().getInt("brokenKizCount") ==KIZ_COUNT;
                }
            };
        }

    private static Basestate createBody (int opNumber){
        Basestate bst;
        QUERY_ID = UUID.randomUUID().toString();
        switch (opNumber){
            case 11:
            case 22:
                KIZ_LIST = kizGenerator.generate(KIZ_COUNT);
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
                bst = new Basestate(QUERY_ID, KIZ_LIST_COST, PROPS.getProps(opNumber));
                break;
            case 65:
                KIZ_RELABEL = new ArrayList<Kiz>(kizGenerator.createRelabelingList(KIZ_LIST));
                bst = new Basestate(QUERY_ID, KIZ_RELABEL, PROPS.getProps(opNumber));
                KIZ_LIST = new ArrayList<Kiz>(kizGenerator.getNewKizList(KIZ_RELABEL));
                break;
            case 51:
                bst = new Basestate(QUERY_ID, KIZ_LIST_PRICE, PROPS.getProps(opNumber));
                break;
            default:
                bst = new Basestate();
                break;
        }

        return bst;
    }

    public void setMetadataCost(){
    }

}
