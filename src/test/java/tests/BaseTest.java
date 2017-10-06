package tests;

import config.BasestateGenerator;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.concurrent.Callable;

import static io.restassured.RestAssured.given;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class BaseTest extends BasestateGenerator{
    int kizCount;
    String queryId;

    public BaseTest(){
        queryId = getQueryId();
        kizCount = KIZ_COUNT;
    }

    public void postBasestate (int opNumber, boolean checkType) throws Exception{

          Response response;
          if (opNumber < 100) {
              System.out.println(RestAssured.baseURI  + "/kiz/basestate/" + opNumber);
              response = given().
                      contentType("application/json").
                      body(createBody(opNumber)).
                      when().
                      post("/kiz/basestate/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
          } else {
              System.out.println(RestAssured.baseURI  + "/kiz/lp/" + opNumber);
              response = given().
                      contentType("application/json").
                      body(createBody(opNumber)).
                      when().
                      post("/kiz/lp/" + opNumber).
                      then().
                        statusCode(200).
                      extract().response();
          }
            System.out.println(response.body().asString());

        if (checkType)  await().atMost(5 * kizCount, SECONDS).until(checkAccept(queryId));
          else await().atMost(5 * kizCount, SECONDS).until(checkAccept(queryId));
    }


    private Callable<Boolean> checkAccept(final String queryId) throws Exception {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                Response response = given().
                        contentType("application/json").
                        when().
                        get("/kiz/result/" + queryId);
                return response.statusCode() == 200 &&
                        response.body().jsonPath().getInt("kizCount") == kizCount &&
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
                            get("/kiz/result/" + queryId);
                    return response.statusCode() == 200 &&
                            response.body().jsonPath().getInt("kizCount") == kizCount &&
                            response.body().jsonPath().getInt("brokenKizCount") == kizCount;
                }
            };
        }


}
