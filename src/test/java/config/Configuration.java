package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;


/**
 * Класс служит для чтения и хранения свойств из файла конфигурации
 *
 * @author RNurullaev
 * @version 1.0
 */
public class Configuration {

    //branches
    private String API_URI = "http://localhost:4444/v3";
    private String SUBJECT_ID_RF = "00000000000464";
    private String SUBJECT_ID_FOREIGN = "e579d5cb-47c9-431a-953b-74077f9f9ba9";
    private String CONTROL_ID = "e579d5cb-47c9-431a-953b-74077f9f9ba9";
    private String PACKING_ID = "e579d5cb-47c9-431a-953b-74077f9f9ba9";
    private String OWNER_ID = "00000000000453";
    private String CONSIGNEE_ID = "00000000000453";
    private String SELLER_ID = "00000000000453";
    private String REFUSED_BY_ENTITY_ID = "00000000000464";

    // json properties
    private String OP_DATE = "2017-08-12T14:00:00+03:00";
    private String HS_CODE = "3004";
    private String GTIN = "04606556002770";
    private String BATCH = "20170912-1410";
    private String EXP_DATE = "2020-02-02";
    private int KIZ_COUNT = 1;
    private int DOC_TYPE = 1;
    private String DOC_NUM = "0005";
    private String DOC_DATE = "2017-08-09";
    private String INVOICE_DATE = "2017-08-01";
    private String INVOICE_NUM = "123/07/2017";
    private int CONTRACT_TYPE = 1;
    private int CUSTOM_PROCEDURE_CODE = 4;
    private String GTD_CUSTOMS_CODE = "12";
    private String GTD_REG_DATE = "2017-08-01";
    private String GTD_REG_NUMBER = "1234567";
    private int ACCEPT_TYPE = 1;
    private int SOURCE_TYPE = 1;
    private int SHIPMENT_TYPE = 1;
    private int RECEIVING_TYPE = 1;
    private int ORDER_TYPE = 1;
    private int WITHDRAWAL_TYPE = 6;
    private int CONTROL_TYPE = 2;
    private int STORAGE_TYPE =1;
    private int[] SEQUENCE = {11, 12, 17};
    private int REFUSED_BY = 1;
    private Properties prop = new Properties();
    private InputStream input = null;

    public Configuration(){
        readConfig();
    }


    /**
     * Попытка чтения файла конфигурации и запись свойст в переменные
     */
    private void readConfig(){

        try {

            input = new FileInputStream("src\\test\\resources\\config.properties");

            // load a properties file
            prop.load(input);

            // set params
            setSubjectIdRf(prop.getProperty("SUBJECT_ID_RF"));
            setApiUri(prop.getProperty("API_URI"));
            setSubjectIdForeign(prop.getProperty("SUBJECT_ID_FOREIGN"));
            setControlId(prop.getProperty("CONTROL_ID"));
            setPackingId(prop.getProperty("PACKING_ID"));
            setOwnerId(prop.getProperty("OWNER_ID"));
            setConsigneeId(prop.getProperty("CONSIGNEE_ID"));
            setSellerId(prop.getProperty("SELLER_ID"));

            // set Json properties data
            setOpDate(getCurrentDate());
            setHsCode(prop.getProperty("HS_CODE"));
            setGTIN(prop.getProperty("GTIN"));
            setBATCH(prop.getProperty("BATCH"));
            setExpDate(prop.getProperty("EXP_DATE"));
            setKizCount(Integer.parseInt(prop.getProperty("KIZ_COUNT")));
            setDocType(Integer.parseInt(prop.getProperty("DOC_TYPE")));
            setDocNum(prop.getProperty("DOC_NUM"));
            setDocDate(prop.getProperty("DOC_DATE"));
            setInvoiceDate(prop.getProperty("INVOICE_DATE"));
            setInvoiceNum(prop.getProperty("INVOICE_NUM"));
            setContractType(Integer.parseInt(prop.getProperty("CONTRACT_TYPE")));
            setCustomProcedureCode(Integer.parseInt(prop.getProperty("CUSTOM_PROCEDURE_CODE")));
            setGtdCustomsCode(prop.getProperty("GTD_CUSTOMS_CODE"));
            setGtdRegDate(prop.getProperty("GTD_REG_DATE"));
            setGtdRegNumber(prop.getProperty("GTD_REG_NUMBER"));
            setAcceptType(Integer.parseInt(prop.getProperty("ACCEPT_TYPE")));
            setSourceType(Integer.parseInt(prop.getProperty("SOURCE_TYPE")));
            setShipmentType(Integer.parseInt(prop.getProperty("SHIPMENT_TYPE")));
            setReceivingType(Integer.parseInt(prop.getProperty("RECEIVING_TYPE")));
            setOrderType(Integer.parseInt(prop.getProperty("ORDER_TYPE")));
            setWithdrawalType(Integer.parseInt(prop.getProperty("WITHDRAWAL_TYPE")));
            setControlType(Integer.parseInt(prop.getProperty("CONTROL_TYPE")));
            setStorageType(Integer.parseInt(prop.getProperty("STORAGE_TYPE")));
            setRefusedBy(Integer.parseInt(prop.getProperty("REFUSED_BY")));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = new Date();
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(date);
    }

    public  String getApiUri() {
        return API_URI;
    }

    public void setApiUri(String apiUri) {
        API_URI = apiUri;
    }

    public  String getSubjectIdRf() {
        return SUBJECT_ID_RF;
    }

    public  void setSubjectIdRf(String subjectIdRf) {
        SUBJECT_ID_RF = subjectIdRf;
    }

    public  String getSubjectIdForeign() {
        return SUBJECT_ID_FOREIGN;
    }

    public  void setSubjectIdForeign(String subjectIdForeign) {
        SUBJECT_ID_FOREIGN = subjectIdForeign;
    }

    public  String getOwnerId() {
        return OWNER_ID;
    }

    public  void setOwnerId(String ownerId) {
        OWNER_ID = ownerId;
    }

    public  String getConsigneeId() {
        return CONSIGNEE_ID;
    }

    public  void setConsigneeId(String consigneeId) {
        CONSIGNEE_ID = consigneeId;
    }

    public  String getSellerId() {
        return SELLER_ID;
    }

    public  void setSellerId(String sellerId) {
        SELLER_ID = sellerId;
    }

    public  String getRefusedByEntityId() {
        return REFUSED_BY_ENTITY_ID;
    }

    public  void setRefusedByEntityId(String refusedByEntityId) {
        REFUSED_BY_ENTITY_ID = refusedByEntityId;
    }

    public  String getOpDate() {
        return OP_DATE;
    }

    public  void setOpDate(String opDate) {
        OP_DATE = opDate;
    }

    public  String getHsCode() {
        return HS_CODE;
    }

    public  void setHsCode(String hsCode) {
        HS_CODE = hsCode;
    }

    public  String getGTIN() {
        return GTIN;
    }

    public  void setGTIN(String gtin) {
        GTIN = gtin;
    }

    public  String getBATCH() {
        return BATCH;
    }

    public  void setBATCH(String bathc) {
       BATCH = bathc;
    }

    public  String getExpDate() {
        return EXP_DATE;
    }

    public  void setExpDate(String expDate) {
        EXP_DATE = expDate;
    }

    public  int getKizCount() {
        return KIZ_COUNT;
    }

    public  void setKizCount(int kizCount) {
        KIZ_COUNT = kizCount;
    }

    public  int getDocType() {
        return DOC_TYPE;
    }

    public  void setDocType(int docType) {
        DOC_TYPE = docType;
    }

    public  String getDocNum() {
        return DOC_NUM;
    }

    public  void setDocNum(String docNum) {
        DOC_NUM = docNum;
    }

    public  String getDocDate() {
        return DOC_DATE;
    }

    public  void setDocDate(String docDate) {
        DOC_DATE = docDate;
    }

    public  String getInvoiceDate() {
        return INVOICE_DATE;
    }

    public  void setInvoiceDate(String invoiceDate) {
        INVOICE_DATE = invoiceDate;
    }

    public  String getInvoiceNum() {
        return INVOICE_NUM;
    }

    public  void setInvoiceNum(String invoiceNum) {
        INVOICE_NUM = invoiceNum;
    }

    public  int getContractType() {
        return CONTRACT_TYPE;
    }

    public  void setContractType(int contractType) {
        CONTRACT_TYPE = contractType;
    }

    public  int getCustomProcedureCode() {
        return CUSTOM_PROCEDURE_CODE;
    }

    public  void setCustomProcedureCode(int customProcedureCode) {
        CUSTOM_PROCEDURE_CODE = customProcedureCode;
    }

    public  String getGtdCustomsCode() {
        return GTD_CUSTOMS_CODE;
    }

    public  void setGtdCustomsCode(String gtdCustomsCode) {
        GTD_CUSTOMS_CODE = gtdCustomsCode;
    }

    public  String getGtdRegDate() {
        return GTD_REG_DATE;
    }

    public  void setGtdRegDate(String gtdRegDate) {
        GTD_REG_DATE = gtdRegDate;
    }

    public  String getGtdRegNumber() {
        return GTD_REG_NUMBER;
    }

    public  void setGtdRegNumber(String gtdRegNumber) {
        GTD_REG_NUMBER = gtdRegNumber;
    }

    public  int getAcceptType() {
        return ACCEPT_TYPE;
    }

    public  void setAcceptType(int acceptType) {
        ACCEPT_TYPE = acceptType;
    }

    public  int getSourceType() {
        return SOURCE_TYPE;
    }

    public  void setSourceType(int sourceType) {
        SOURCE_TYPE = sourceType;
    }

    public  int getShipmentType() {
        return SHIPMENT_TYPE;
    }

    public  void setShipmentType(int shipmentType) {
        SHIPMENT_TYPE = shipmentType;
    }

    public  int getReceivingType() {
        return RECEIVING_TYPE;
    }

    public  void setReceivingType(int receivingType) {
        RECEIVING_TYPE = receivingType;
    }

    public  int getOrderType() {
        return ORDER_TYPE;
    }

    public  void setOrderType(int orderType) {
        ORDER_TYPE = orderType;
    }

    public  int getWithdrawalType() {
        return WITHDRAWAL_TYPE;
    }

    public  void setWithdrawalType(int withdrawalType) {
        WITHDRAWAL_TYPE = withdrawalType;
    }

    public  int getControlType() {
        return CONTROL_TYPE;
    }

    public  void setControlType(int controlType) {
        CONTROL_TYPE = controlType;
    }

    public  int getStorageType() {
        return STORAGE_TYPE;
    }

    public  void setStorageType(int storageType) {
        STORAGE_TYPE = storageType;
    }

    public  int[] getSEQUENCE() {
        return SEQUENCE;
    }

    public  void setSEQUENCE(int[] sequence) {
        SEQUENCE = sequence;
    }

    public  int getRefusedBy() {
        return REFUSED_BY;
    }

    public  void setRefusedBy(int refusedBy) {
        REFUSED_BY = refusedBy;
    }

    public  String getControlId() {
        return CONTROL_ID;
    }

    public  void setControlId(String controlId) {
        CONTROL_ID = controlId;
    }

    public  String getPackingId() {
        return PACKING_ID;
    }

    public  void setPackingId(String packingId) {
        PACKING_ID = packingId;
    }
}
