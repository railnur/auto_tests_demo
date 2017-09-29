package tests.processes;

import jsonschemas.basestate.Basestate;
import org.junit.*;
import tests.BaseTest;

import static config.JsonMapper.jsonAsString;
import static io.restassured.RestAssured.given;

public class JumpToArrived extends BaseTest {



    @Test
    public void createKizsTest(){

        Basestate basesate22 = new Basestate(QUERY_ID, KIZ_LIST,  PROPS.getProps(22));
        Basestate basesate23 = new Basestate(QUERY_ID, KIZ_LIST_COST,  PROPS.getProps(23));
        Basestate basesate24 = new Basestate(QUERY_ID, KIZ_LIST_COST,  PROPS.getProps(24));


        given().
                contentType("application/json").
                body(jsonAsString(basesate22)).
                when().
                post("/kiz/basestate/22").
                then().
                statusCode(200).
                extract().response();

        given().
                contentType("application/json").
                body(jsonAsString(basesate23)).
                when().
                post("/kiz/basestate/23").
                then().
                statusCode(200).
                extract().response();

        given().
                contentType("application/json").
                body(jsonAsString(basesate24)).
                when().
                post("/kiz/basestate/24").
                then().
                statusCode(200).
                extract().response();
    }
}