package tests.coretests;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VersionTest {

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
                    body(containsString("release_date"));
    }
}
