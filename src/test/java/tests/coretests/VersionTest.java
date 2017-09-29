package tests.coretests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import config.Configuration;
import io.restassured.RestAssured;
import org.junit.Test;

public class VersionTest {

    public VersionTest() {
        RestAssured.baseURI = Configuration.API_URI;
    }

    @Test
    public void getVersionTest(){
        given().
                contentType("application/json").
                when().
                get("/core/version").
                then().
                statusCode(200).
                body(containsString("core_version")).
                body(containsString("api_version")).
                body(containsString("release_date")).
                // body("core_version", equalTo("6.0")).
                extract().response();
    }
}
