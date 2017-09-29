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

import static config.JsonMapper.jsonAsString;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class BaseTest extends Configuration{

    private KizGenerator kizGenerator = new KizGenerator();
    public static Response RESPONSE;
    public static String QUERY_ID = UUID.randomUUID().toString();
    public static List<Kiz> KIZ_LIST;
    public static List<Kiz> KIZ_LIST_COST;
    public static List<Kiz> KIZ_LIST_PRICE;
    public static PropsGenerator PROPS;


    public BaseTest(){
        RestAssured.baseURI = API_URI;
        KIZ_LIST = kizGenerator.generate(KIZ_COUNT);
        KIZ_LIST_COST = new ArrayList<Kiz>(kizGenerator.addMetadataCost(KIZ_LIST));
        KIZ_LIST_PRICE = new ArrayList<Kiz>(kizGenerator.addMetadataPrice(KIZ_LIST));
        PROPS = new PropsGenerator();
    }

    public static Response postBasestate (int opNumber){

        System.out.println(RestAssured.baseURI  + "/kiz/basestate/" + opNumber);
        System.out.println(jsonAsString(createBody(opNumber)));
          Response response = null;
          if (opNumber < 100) {
              response = given().
                      contentType("application/json").
                      body(jsonAsString(createBody(opNumber))).
                      when().
                      post("/kiz/basestate/" + opNumber).
                      then().
                      //statusCode(200).
                      extract().response();
          } else {
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
           return response;
    }

    public static Response checkAccept(){
        Response response = given().
                    contentType("application/json").
                when().
                    get("/kiz/result/" + QUERY_ID).
                then().
                    statusCode(200).
                    body("kizCount", equalTo(KIZ_COUNT)).
                    body("code", equalTo(0)).
                    body("brokenKizCount", equalTo(0)).
                extract().response();
        System.out.println(response.body().asString());
        return response;
    }

    public static Response checkReject(){
        Response response = given().
                contentType("application/json").
                when().
                get("/kiz/result/" + QUERY_ID).
                then().
                statusCode(200).
                body("kizCount", equalTo(KIZ_COUNT)).
                body("brokenKizCount", equalTo(KIZ_COUNT)).
                extract().response();
        System.out.println(response.body().asString());
        return response;
    }

    private static Basestate createBody (int opNumber){
        Basestate bst;
        switch (opNumber){
            case 11:
            case 12:
            case 17:
            case 18:
            case 22:
            case 25:
            case 28:
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
            case 51:
                bst = new Basestate(QUERY_ID, KIZ_LIST_PRICE, PROPS.getProps(opNumber));
                break;
            default:
                bst = new Basestate();
                break;
        }

        return bst;
    }
}
