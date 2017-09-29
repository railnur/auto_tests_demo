/*
package tests.processes;


import config.PropsGenerator;
import jsonschemas.basestate.basestate11.Bst11;
import org.junit.Test;
import tests.BaseTest;

import static io.restassured.RestAssured.given;

public class JumpToReleasedContractTest extends BaseTest{


    @Test
    public void createKizsTest(){

        Bst11 body = new Bst11(QUERY_ID, KIZ_LIST,  new PropsGenerator(11).getProps());


        System.out.println(json);
        RESPONSE = given().
                contentType("application/json").
                body(json).
                when().
                post("/kiz/basestate/11").
                then().
                statusCode(200).
                extract().response();

        System.out.println(RESPONSE.body().asString());

    }


}
*/
