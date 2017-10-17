package config;

import jsonschemas.basestate.GtdInfo;
import jsonschemas.basestate.Properties;




public class PropsGenerator{

    private Properties props;
    private Configuration configurationProps;
    public PropsGenerator(Configuration configurationProps){
        this.configurationProps = configurationProps;
    }

    /**
     * Создание контейнера Properties по номеру операции трассировки
     * @param opNumber Номер операции
     * @return Объект jsonschemas.basestate.Properties
     */
    public Properties getProps(int opNumber) {

        props = new Properties(configurationProps.getSubjectIdRf(), configurationProps.getOpDate());
        String temp;
        switch (opNumber){
            case 11:
                props.setOrderType(configurationProps.getOrderType());
                props.setOwnerId(configurationProps.getOwnerId());
                props.setHsCode(configurationProps.getHsCode());
                props.setGtin(configurationProps.getGTIN());
                props.setBatch(configurationProps.getBATCH());
                props.setExpDate(configurationProps.getExpDate());
                break;
            case 12:
                props.setDocType(configurationProps.getDocType());
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                break;
            case 17:
                props.setOwnerId(configurationProps.getOwnerId());
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                break;
            case 18:
                temp = configurationProps.getSubjectIdRf();
                configurationProps.setSubjectIdRf(configurationProps.getOwnerId());
                configurationProps.setOwnerId(temp);
                props.setVendorId(configurationProps.getOwnerId());
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                props.setSystemSubjId(configurationProps.getSubjectIdRf());
            case 28:
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                break;
            case 22:
                props.setHsCode(configurationProps.getHsCode());
                props.setControlId(configurationProps.getControlId());
                props.setPackingId(configurationProps.getPackingId());
                props.setGtin(configurationProps.getGTIN());
                props.setBatch(configurationProps.getBATCH());
                props.setExpDate(configurationProps.getExpDate());
                props.setSystemSubjId(configurationProps.getSubjectIdForeign());
                break;
            case 23:
                props.setSystemSubjId(configurationProps.getSubjectIdForeign());
                props.setSellerId(configurationProps.getSubjectIdForeign());
                props.setConsumerId(configurationProps.getSubjectIdRf());
                props.setInvoiceNum(configurationProps.getInvoiceNum());
                props.setInvoiceDate(configurationProps.getInvoiceDate());
                break;
            case 24:
                props.setSellerId(configurationProps.getSubjectIdForeign());
                props.setInvoiceNum(configurationProps.getInvoiceNum());
                props.setInvoiceDate(configurationProps.getInvoiceDate());
                break;
            case 25:
                props.setControlType(configurationProps.getControlType());
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                props.setCustomProcedureCode(configurationProps.getCustomProcedureCode());
                props.setGtdInfo(new GtdInfo(configurationProps.getGtdCustomsCode(), configurationProps.getGtdRegDate(), configurationProps.getGtdRegNumber()));
                break;
            case 31:
                props.setShipmentType(configurationProps.getShipmentType());
                props.setSourceType(configurationProps.getSourceType());
                props.setAcceptType(configurationProps.getAcceptType());
                props.setContractType(configurationProps.getContractType());
                props.setConsigneeId(configurationProps.getConsigneeId());
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                break;
            case 32:
                configurationProps.setSellerId(configurationProps.getSubjectIdRf());
                temp = configurationProps.getConsigneeId();
                configurationProps.setConsigneeId(configurationProps.getSubjectIdRf());
                configurationProps.setSubjectIdRf(temp);
                props.setReceivingType(configurationProps.getReceivingType());
                props.setAcceptType(configurationProps.getAcceptType());
                props.setContractType(configurationProps.getContractType());
                props.setSellerId(configurationProps.getSellerId());
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                props.setSystemSubjId(configurationProps.getSubjectIdRf());
                break;
            case 33:
                props.setConsigneeId(configurationProps.getConsigneeId());
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                break;
            case 34:
                props.setRefuseReason("reason");
                props.setRefusedBy(configurationProps.getRefusedBy());
                if (configurationProps.getRefusedBy() == 0) configurationProps.setRefusedByEntityId(configurationProps.getSubjectIdRf());
                else configurationProps.setRefusedByEntityId(configurationProps.getOwnerId());
                props.setRefusedByEntityId(configurationProps.getRefusedByEntityId());
                break;
            case 51:
                break;
            case 52:
                props.setDocNum(configurationProps.getDocNum());
                props.setDocDate(configurationProps.getDocDate());
                props.setWithdrawalType(configurationProps.getWithdrawalType());
                break;
            case 65:
                break;
            case 301:
                props.setControlType(configurationProps.getControlType());
                break;
            case 305:
                props.setPrescriptionNum(configurationProps.getDocNum());
                props.setPrescriptionDate(configurationProps.getDocDate());
                break;
            case 306:
                props.setUseDocDate(configurationProps.getDocDate());
                props.setUseDocNum(configurationProps.getDocNum());
                break;
            default:
                break;
        }

        return props;
    }

}
