package config;

import jsonschemas.basestate.Doc;
import jsonschemas.basestate.Kiz;
import jsonschemas.basestate.Metadata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KizGenerator {

    private List<Doc> docs = new ArrayList<Doc>();
    private Doc doc = new Doc(1,"000000001","2017-08-09");
    private Metadata metadata_price;
    private Metadata metadata_cost = new Metadata(1033, 100033);
    public KizGenerator(){
    }

    public List<Kiz> generate (int count){
        List<Kiz> kizList = new ArrayList<Kiz>();
        for (int i =0; i < count; i++){

            String kiztext = createKizs(i);
            Kiz kiz = new Kiz(0, kiztext);
            kizList.add(kiz);
        }

        return kizList;
    }


    public List<Kiz> addMetadataCost(List<Kiz> kizList){

        List<Kiz> kizListCost = new ArrayList<Kiz>();
        kizListCost.addAll(copyKiz(kizList));

        for (Kiz kiz : kizListCost){
            kiz.setMetadata(metadata_cost);
        }

        return kizListCost;
    }

    public List<Kiz> addMetadataPrice(List<Kiz> kizList){

        List<Kiz> kizListCost = new ArrayList<Kiz>();
        kizListCost.addAll(copyKiz(kizList));
        docs.add(doc);
        metadata_price = new Metadata(1033, 100033, docs);
        for (Kiz kiz : kizListCost){
            kiz.setMetadata(metadata_price);
        }

        return kizListCost;
    }



    public List<Kiz> copyKiz (List<Kiz> kizList){
        List<Kiz> copyList = new ArrayList<Kiz>();
        for (Kiz kiz : kizList){
            copyList.add(new Kiz(kiz.getSignType(), kiz.getSign()));
        }
        return copyList;
    }


    private String createKizs (int i) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date currentDate = new Date();
        String date = dateFormat.format(currentDate);

        String kiztext = date + "AUTOTEST0000" + i;

        if (i < 10) {
            kiztext = date + "AUTOTEST0000" + i;
        } else if (i < 100){
            kiztext = date + "AUTOTEST000" + i;
        } else if (i < 1000){
            kiztext = date + "AUTOTEST00" + i;
        } else if (i < 10000){
            kiztext = date + "AUTOTEST0" + i;
        }

        System.out.println(kiztext);
        return kiztext;
    }

}
