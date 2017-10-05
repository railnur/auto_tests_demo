package config;

import jsonschemas.basestate.GtdInfo;
import jsonschemas.basestate.Properties;

public class PropsGenerator extends Configuration{

    private Properties props;
    public PropsGenerator(){
    }

    public Properties getProps(int opNumber) {

        props = new Properties(SUBJECT_ID_RF, OP_DATE);

        switch (opNumber){
            case 11:
                props.setOrderType(ORDER_TYPE);
                props.setOwnerId(SUBJECT_ID_RF);
                props.setHsCode(HS_CODE);
                props.setGtin(GTIN);
                props.setBatch(BATCH);
                props.setExpDate(EXP_DATE);
                break;
            case 12:
                props.setDocType(DOC_TYPE);
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                break;
            case 17:
                props.setOwnerId(OWNER_ID);
                SUBJECT_ID_RF = OWNER_ID;
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                break;
            case 18:
            case 28:
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                break;
            case 22:
                props.setHsCode(HS_CODE);
                props.setGtin(GTIN);
                props.setBatch(BATCH);
                props.setExpDate(EXP_DATE);
                props.setSystemSubjId(SUBJECT_ID_FOREIGN);
                break;
            case 23:
                props.setSystemSubjId(SUBJECT_ID_FOREIGN);
                props.setSellerId(SUBJECT_ID_FOREIGN);
                props.setConsumerId(SUBJECT_ID_RF);
                props.setInvoiceNum(INVOICE_NUM);
                props.setInvoiceDate(INVOICE_DATE);
                break;
            case 24:
                props.setSellerId(SUBJECT_ID_FOREIGN);
                props.setInvoiceNum(INVOICE_NUM);
                props.setInvoiceDate(INVOICE_DATE);
                break;
            case 25:
                props.setControlType(CONTROL_TYPE);
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                props.setCustomProcedureCode(CUSTOM_PROCEDURE_CODE);
                props.setGtdInfo(new GtdInfo(GTD_CUSTOMS_CODE, GTD_REG_DATE, GTD_REG_NUMBER));
                break;
            case 31:
                props.setShipmentType(SHIPMENT_TYPE);
                props.setSourceType(SOURCE_TYPE);
                props.setAcceptType(ACCEPT_TYPE);
                props.setContractType(CONTRACT_TYPE);
                props.setConsigneeId(new String(CONSIGNEE_ID));
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                props.setSystemSubjId(SUBJECT_ID_RF);
                break;
            case 32:
                SELLER_ID = new String(SUBJECT_ID_RF);
                String temp = new String(CONSIGNEE_ID);
                CONSIGNEE_ID = new String(SUBJECT_ID_RF);
                SUBJECT_ID_RF = new String(temp);
                props.setReceivingType(RECEIVING_TYPE);
                props.setAcceptType(ACCEPT_TYPE);
                props.setContractType(CONTRACT_TYPE);
                props.setSellerId(SELLER_ID);
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                props.setSystemSubjId(SUBJECT_ID_RF);
                break;
            case 33:
                props.setConsigneeId(CONSIGNEE_ID);
                props.setStorageType(STORAGE_TYPE);
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                break;
            case 51:
                break;
            case 52:
                props.setDocNum(DOC_NUM);
                props.setDocDate(DOC_DATE);
                props.setWithdrawalType(WITHDRAWAL_TYPE);
                break;
            case 65:
                break;
            case 301:
                props.setControlType(CONTROL_TYPE);
                break;
            case 305:
                props.setPrescriptionNum(DOC_NUM);
                props.setPrescriptionDate(DOC_DATE);
                break;
            case 306:
                props.setUseDocDate(DOC_DATE);
                props.setUseDocNum(DOC_NUM);
                break;
            default:
                break;
        }

        return props;
    }

}
