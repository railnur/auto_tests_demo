package config;

import io.restassured.RestAssured;
import jsonschemas.basestate.Basestate;
import jsonschemas.basestate.Kiz;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static config.JsonMapper.jsonAsString;

public class BasestateGenerator extends Configuration {

    private static KizGenerator kizGenerator = new KizGenerator();
    public static String queryId = UUID.randomUUID().toString();
    public static List<Kiz> KIZ_LIST;
    public static List<Kiz> KIZ_LIST_COST;
    public static List<Kiz> KIZ_LIST_PRICE;
    public static PropsGenerator PROPS;
    public static List<Kiz> KIZ_RELABEL;

    public BasestateGenerator() {
        RestAssured.baseURI = API_URI;
        PROPS = new PropsGenerator();
    }

    public static String createBody(int opNumber) {
        Basestate bst;
        switch (opNumber) {
            case 11:
            case 23:
                KIZ_LIST = kizGenerator.generate(KIZ_COUNT);
                bst = new Basestate(queryId, KIZ_LIST, PROPS.getProps(opNumber));
                break;
            case 12:
            case 17:
            case 18:
            case 22:
            case 25:
            case 28:
            case 33:
            case 52:
            case 301:
            case 305:
            case 306:
                bst = new Basestate(queryId, KIZ_LIST, PROPS.getProps(opNumber));
                break;
            case 24:
            case 31:
            case 32:
                KIZ_LIST_COST = new ArrayList<Kiz>(kizGenerator.addMetadataCost(KIZ_LIST));
                bst = new Basestate(queryId, KIZ_LIST_COST, PROPS.getProps(opNumber));
                break;
            case 65:
                KIZ_RELABEL = new ArrayList<Kiz>(kizGenerator.createRelabelingList(KIZ_LIST));
                bst = new Basestate(queryId, KIZ_RELABEL, PROPS.getProps(opNumber));
                KIZ_LIST = new ArrayList<Kiz>(kizGenerator.getNewKizList(KIZ_RELABEL));
                break;
            case 51:
                KIZ_LIST_PRICE = new ArrayList<Kiz>(kizGenerator.addMetadataPrice(KIZ_LIST));
                bst = new Basestate(queryId, KIZ_LIST_PRICE, PROPS.getProps(opNumber));
                break;
            default:
                bst = new Basestate();
                break;
        }

        return jsonAsString(bst);
    }

    public String getQueryId() {
        return queryId;
    }

    public void setCost(int cost) {
        for (Kiz kiz : KIZ_LIST_COST) {
            kiz.getMetadata().setCost(cost);
        }
    }

    public void setPrice (int price) {
        for (Kiz kiz : KIZ_LIST_PRICE) {
            kiz.getMetadata().setPrice(price);
        }
    }

    public void setVatValue (int vatValue) {
        for (Kiz kiz : KIZ_LIST_PRICE) {
            kiz.getMetadata().setVatValue(vatValue);
        }

        for (Kiz kiz : KIZ_LIST_PRICE) {
            kiz.getMetadata().setVatValue(vatValue);
        }
    }
}
