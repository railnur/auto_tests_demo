package config;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class Configuration {

    private Configurations configs = new Configurations();
    private static PropertiesConfiguration config;

    public Configuration(){
        this.readConfig();
    }

    public static final String API_URI = config.getString("API_URI");
    public static  String SUBJECT_ID_RF = config.getString("SUBJECT_ID_RF");
    public static final String SUBJECT_ID_FOREIGN = config.getString("SUBJECT_ID_FOREIGN");
    public static final String OWNER_ID = config.getString("OWNER_ID");
    public static String CONSIGNEE_ID = config.getString("CONSIGNEE_ID");
    public static String SELLER_ID = config.getString("SELLER_ID");
    public static final String OP_DATE = config.getString("OP_DATE");
    public static final String HS_CODE = config.getString("HS_CODE");
    public static final String GTIN = config.getString("GTIN");
    public static final String BATCH = config.getString("BATCH");
    public static final String EXP_DATE = config.getString("EXP_DATE");
    public static final int KIZ_COUNT = config.getInt("KIZ_COUNT");
    public static final int DOC_TYPE = config.getInt("DOC_TYPE");
    public static final String DOC_NUM = config.getString("DOC_NUM");
    public static final String DOC_DATE = config.getString("DOC_DATE");
    public static final String INVOICE_DATE = config.getString("INVOICE_DATE");
    public static final String INVOICE_NUM = config.getString("INVOICE_NUM");
    public static final int CONTRACT_TYPE = config.getInt("CONTRACT_TYPE");
    public static final int CUSTOM_PROCEDURE_CODE = config.getInt("CUSTOM_PROCEDURE_CODE");
    public static final String GTD_CUSTOMS_CODE = config.getString("GTD_CUSTOMS_CODE");
    public static final String GTD_REG_DATE = config.getString("GTD_REG_DATE");
    public static final String GTD_REG_NUMBER = config.getString("GTD_REG_NUMBER");
    public static final int ACCEPT_TYPE = config.getInt("ACCEPT_TYPE");
    public static final int SOURCE_TYPE = config.getInt("SOURCE_TYPE");
    public static final int SHIPMENT_TYPE = config.getInt("SHIPMENT_TYPE");
    public static final int RECEIVING_TYPE = config.getInt("RECEIVING_TYPE");
    public static final int ORDER_TYPE = config.getInt("ORDER_TYPE");
    public static int WITHDRAWAL_TYPE = config.getInt("WITHDRAWAL_TYPE");
    public static final int CONTROL_TYPE = config.getInt("CONTROL_TYPE");
    public static final int STORAGE_TYPE = config.getInt("STORAGE_TYPE");
    public static int[] SEQUENCE = {11, 12, 51};

    private void readConfig(){

        try
        {
            config = configs.properties(new File("config.properties"));

        }
        catch (ConfigurationException cex)
        {
            System.out.println(cex);
        }
    }

}
