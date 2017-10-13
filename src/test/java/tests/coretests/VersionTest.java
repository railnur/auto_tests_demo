package tests.coretests;

import config.Configuration;
import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class VersionTest {

    public VersionTest() {
        RestAssured.baseURI = new Configuration().getApiUri();
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
                    body("core_version", equalTo("6.0")).
                extract().response();
    }
}
