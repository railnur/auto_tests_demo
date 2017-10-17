package config;

import jsonschemas.basestate.Doc;
import jsonschemas.basestate.Kiz;
import jsonschemas.basestate.Metadata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class KizGenerator {

    private List<Doc> docs;
    private Doc doc;
    private Metadata metadata_price;
    private Metadata metadata_cost;
    private Configuration configurationProps;

    public KizGenerator(Configuration configurationProps){
        this.doc = new Doc(configurationProps.getDocType(),configurationProps.getDocNum(),configurationProps.getDocDate());
        this.docs = new ArrayList<Doc>();
        this.docs.add(doc);
        this.configurationProps = configurationProps;
        this.metadata_price  = new Metadata(configurationProps.getVatValue(), configurationProps.getCost(), docs);
        this.metadata_cost = new Metadata(configurationProps.getVatValue(), configurationProps.getCost());
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

        return kiztext;
    }


    public List<Kiz> createRelabelingList (List<Kiz> kizList) {

        List<Kiz> kizListRelebeling = new ArrayList<Kiz>();
        kizListRelebeling.addAll(copyKiz(kizList));

        for (Kiz kiz : kizListRelebeling){
            Metadata metadata = new Metadata();
            metadata.setSgtinNew(kiz.getSign().replaceAll("[A-Z]{8}", randomString("AUTOTEST")));
            kiz.setMetadata(metadata);
        }

        return kizListRelebeling;
    }

    public List<Kiz> getNewKizList (List<Kiz> kizList){
        List<Kiz> newKizList = new ArrayList<Kiz>();
        for (Kiz kizs : kizList){
            Kiz kiz = new Kiz();
            kiz.setSign(kizs.getMetadata().getSgtinNew());
            newKizList.add(kiz);
        }

        return newKizList;
    }


    private String randomString(String chars) {
        Random rand = new Random();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < chars.length(); i++) {
            buf.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return buf.toString().toUpperCase();
    }

}
