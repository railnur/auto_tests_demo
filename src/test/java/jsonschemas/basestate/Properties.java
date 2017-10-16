package jsonschemas.basestate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({
    "system_subj_id",
    "op_date",
    "order_type",
    "owner_id",
    "hs_code",
    "gtin",
    "batch",
    "exp_date",
    "doc_type",
    "doc_num",
    "doc_date",
    "seller_id",
    "consumer_id",
    "invoice_num",
    "invoice_date",
    "control_type",
    "custom_procedure_code",
    "gtd_info",
    "consignee_id",
    "shipment_type",
    "source_type",
    "accept_type",
    "contract_type",
    "receiving_type",
    "storage_type",
    "refuse_reason",
    "refused_by",
    "withdrawal_type",
    "sscc",
    "prescription_num",
    "prescription_date",
    "use_doc_num",
    "use_doc_date",
    "packing_id",
    "control_id",
    "vendor_id"
})
public class Properties {

    @JsonProperty("system_subj_id")
    private String systemSubjId;
    @JsonProperty("op_date")
    private String opDate;
    @JsonProperty("order_type")
    private int orderType;
    @JsonProperty("owner_id")
    private String ownerId;
    @JsonProperty("hs_code")
    private String hsCode;
    @JsonProperty("gtin")
    private String gtin;
    @JsonProperty("batch")
    private String batch;
    @JsonProperty("exp_date")
    private String expDate;
    @JsonProperty("doc_type")
    private int docType;
    @JsonProperty("doc_num")
    private String docNum;
    @JsonProperty("doc_date")
    private String docDate;
    @JsonProperty("seller_id")
    private String sellerId;
    @JsonProperty("consumer_id")
    private String consumerId;
    @JsonProperty("invoice_num")
    private String invoiceNum;
    @JsonProperty("invoice_date")
    private String invoiceDate;
    @JsonProperty("control_type")
    private int controlType;
    @JsonProperty("custom_procedure_code")
    private int customProcedureCode;
    @JsonProperty("gtd_info")
    private GtdInfo gtdInfo;
    @JsonProperty("consignee_id")
    private String consigneeId;
    @JsonProperty("shipment_type")
    private int shipmentType;
    @JsonProperty("source_type")
    private int sourceType;
    @JsonProperty("accept_type")
    private int acceptType;
    @JsonProperty("contract_type")
    private int contractType;
    @JsonProperty("receiving_type")
    private int receivingType;
    @JsonProperty("storage_type")
    private int storageType;
    @JsonProperty("refuse_reason")
    private String refuseReason;
    @JsonProperty("refused_by")
    private int refusedBy;
    @JsonProperty("refused_by_entity_id")
    private String refusedByEntityId;
    @JsonProperty("withdrawal_type")
    private int withdrawalType;
    @JsonProperty("sscc")
    private String sscc;
    @JsonProperty("prescription_num")
    private String prescriptionNum;
    @JsonProperty("prescription_date")
    private String prescriptionDate;
    @JsonProperty("use_doc_num")
    private String useDocNum;
    @JsonProperty("use_doc_date")
    private String useDocDate;
    @JsonProperty("packing_id")
    private String packingId;
    @JsonProperty("control_id")
    private String controlId;
    @JsonProperty("vendor_id")
    private String vendorId;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Properties() {
    }

    public Properties(String systemSubjId, String opDate) {
        super();
        this.systemSubjId = systemSubjId;
        this.opDate = opDate;
    }

    public Properties(String systemSubjId, String opDate, int orderType, String ownerId, String hsCode, String gtin, String batch, String expDate) {
        super();
        this.systemSubjId = systemSubjId;
        this.opDate = opDate;
        this.orderType = orderType;
        this.ownerId = ownerId;
        this.hsCode = hsCode;
        this.gtin = gtin;
        this.batch = batch;
        this.expDate = expDate;
    }

    public Properties(String systemSubjId, String opDate, int docType, String docNum, String docDate) {
        super();
        this.systemSubjId = systemSubjId;
        this.opDate = opDate;
        this.docType = docType;
        this.docNum = docNum;
        this.docDate = docDate;
    }

    public Properties(String systemSubjId, String opDate, String ownerId, String docNum, String docDate) {
        super();
        this.systemSubjId = systemSubjId;
        this.opDate = opDate;
        this.ownerId = ownerId;
        this.docNum = docNum;
        this.docDate = docDate;
    }

    public Properties(String systemSubjId, String opDate, String docNum, String docDate) {
        super();
        this.systemSubjId = systemSubjId;
        this.opDate = opDate;
        this.docNum = docNum;
        this.docDate = docDate;
    }

    public Properties(String systemSubjId, String opDate, String hsCode, String gtin, String batch, String expDate) {
        super();
        this.systemSubjId = systemSubjId;
        this.opDate = opDate;
        this.hsCode = hsCode;
        this.gtin = gtin;
        this.batch = batch;
        this.expDate = expDate;
    }

    @JsonProperty("system_subj_id")
    public String getSystemSubjId() {
        return systemSubjId;
    }

    @JsonProperty("system_subj_id")
    public void setSystemSubjId(String systemSubjId) {
        this.systemSubjId = systemSubjId;
    }

    public Properties withSystemSubjId(String systemSubjId) {
        this.systemSubjId = systemSubjId;
        return this;
    }

    @JsonProperty("packing_id")
    public String getPackingId() {
        return packingId;
    }

    @JsonProperty("packing_id")
    public void setPackingId(String packingId) {
        this.packingId = packingId;
    }

    public Properties withPackingId(String packingId) {
        this.packingId = packingId;
        return this;
    }

    @JsonProperty("control_id")
    public String getControlId() {
        return controlId;
    }

    @JsonProperty("control_id")
    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    public Properties withControlId(String controlId) {
        this.controlId = controlId;
        return this;
    }

    @JsonProperty("op_date")
    public String getOpDate() {
        return opDate;
    }

    @JsonProperty("op_date")
    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public Properties withOpDate(String opDate) {
        this.opDate = opDate;
        return this;
    }

    @JsonProperty("order_type")
    public int getOrderType() {
        return orderType;
    }

    @JsonProperty("order_type")
    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public Properties withOrderType(int orderType) {
        this.orderType = orderType;
        return this;
    }

    @JsonProperty("owner_id")
    public String getOwnerId() {
        return ownerId;
    }

    @JsonProperty("owner_id")
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Properties withOwnerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    @JsonProperty("hs_code")
    public String getHsCode() {
        return hsCode;
    }

    @JsonProperty("hs_code")
    public void setHsCode(String hsCode) {
        this.hsCode = hsCode;
    }

    public Properties withHsCode(String hsCode) {
        this.hsCode = hsCode;
        return this;
    }

    @JsonProperty("gtin")
    public String getGtin() {
        return gtin;
    }

    @JsonProperty("gtin")
    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public Properties withGtin(String gtin) {
        this.gtin = gtin;
        return this;
    }

    @JsonProperty("batch")
    public String getBatch() {
        return batch;
    }

    @JsonProperty("batch")
    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Properties withBatch(String batch) {
        this.batch = batch;
        return this;
    }

    @JsonProperty("exp_date")
    public String getExpDate() {
        return expDate;
    }

    @JsonProperty("exp_date")
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public Properties withExpDate(String expDate) {
        this.expDate = expDate;
        return this;
    }

    @JsonProperty("doc_type")
    public int getDocType() {
        return docType;
    }

    @JsonProperty("doc_type")
    public void setDocType(int docType) {
        this.docType = docType;
    }

    public Properties withDocType(int docType) {
        this.docType = docType;
        return this;
    }

    @JsonProperty("doc_num")
    public String getDocNum() {
        return docNum;
    }

    @JsonProperty("doc_num")
    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public Properties withDocNum(String docNum) {
        this.docNum = docNum;
        return this;
    }

    @JsonProperty("doc_date")
    public String getDocDate() {
        return docDate;
    }

    @JsonProperty("doc_date")
    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public Properties withDocDate(String docDate) {
        this.docDate = docDate;
        return this;
    }

    @JsonProperty("seller_id")
    public String getSellerId() {
        return sellerId;
    }

    @JsonProperty("seller_id")
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Properties withSellerId(String sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    @JsonProperty("consumer_id")
    public String getConsumerId() {
        return consumerId;
    }

    @JsonProperty("consumer_id")
    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public Properties withConsumerId(String consumerId) {
        this.consumerId = consumerId;
        return this;
    }

    @JsonProperty("invoice_num")
    public String getInvoiceNum() {
        return invoiceNum;
    }

    @JsonProperty("invoice_num")
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Properties withInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
        return this;
    }

    @JsonProperty("invoice_date")
    public String getInvoiceDate() {
        return invoiceDate;
    }

    @JsonProperty("invoice_date")
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Properties withInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
        return this;
    }

    @JsonProperty("control_type")
    public int getControlType() {
        return controlType;
    }

    @JsonProperty("control_type")
    public void setControlType(int controlType) {
        this.controlType = controlType;
    }

    public Properties withControlType(int controlType) {
        this.controlType = controlType;
        return this;
    }

    @JsonProperty("custom_procedure_code")
    public int getCustomProcedureCode() {
        return customProcedureCode;
    }

    @JsonProperty("custom_procedure_code")
    public void setCustomProcedureCode(int customProcedureCode) {
        this.customProcedureCode = customProcedureCode;
    }

    public Properties withCustomProcedureCode(int customProcedureCode) {
        this.customProcedureCode = customProcedureCode;
        return this;
    }

    @JsonProperty("gtd_info")
    public GtdInfo getGtdInfo() {
        return gtdInfo;
    }

    @JsonProperty("gtd_info")
    public void setGtdInfo(GtdInfo gtdInfo) {
        this.gtdInfo = gtdInfo;
    }

    public Properties withGtdInfo(GtdInfo gtdInfo) {
        this.gtdInfo = gtdInfo;
        return this;
    }

    @JsonProperty("consignee_id")
    public String getConsigneeId() {
        return consigneeId;
    }

    @JsonProperty("consignee_id")
    public void setConsigneeId(String consigneeId) {
        this.consigneeId = consigneeId;
    }

    public Properties withConsigneeId(String consigneeId) {
        this.consigneeId = consigneeId;
        return this;
    }

    @JsonProperty("shipment_type")
    public int getShipmentType() {
        return shipmentType;
    }

    @JsonProperty("shipment_type")
    public void setShipmentType(int shipmentType) {
        this.shipmentType = shipmentType;
    }

    public Properties withShipmentType(int shipmentType) {
        this.shipmentType = shipmentType;
        return this;
    }

    @JsonProperty("source_type")
    public int getSourceType() {
        return sourceType;
    }

    @JsonProperty("source_type")
    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public Properties withSourceType(int sourceType) {
        this.sourceType = sourceType;
        return this;
    }

    @JsonProperty("accept_type")
    public int getAcceptType() {
        return acceptType;
    }

    @JsonProperty("accept_type")
    public void setAcceptType(int acceptType) {
        this.acceptType = acceptType;
    }

    public Properties withAcceptType(int acceptType) {
        this.acceptType = acceptType;
        return this;
    }

    @JsonProperty("contract_type")
    public int getContractType() {
        return contractType;
    }

    @JsonProperty("contract_type")
    public void setContractType(int contractType) {
        this.contractType = contractType;
    }

    public Properties withContractType(int contractType) {
        this.contractType = contractType;
        return this;
    }

    @JsonProperty("receiving_type")
    public int getReceivingType() {
        return receivingType;
    }

    @JsonProperty("receiving_type")
    public void setReceivingType(int receivingType) {
        this.receivingType = receivingType;
    }

    public Properties withReceivingType(int receivingType) {
        this.receivingType = receivingType;
        return this;
    }

    @JsonProperty("storage_type")
    public int getStorageType() {
        return storageType;
    }

    @JsonProperty("storage_type")
    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    public Properties withStorageType(int storageType) {
        this.storageType = storageType;
        return this;
    }

    @JsonProperty("refuse_reason")
    public String getRefuseReason() {
        return refuseReason;
    }

    @JsonProperty("refuse_reason")
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public Properties withRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
        return this;
    }

    @JsonProperty("refused_by")
    public int getRefusedBy() {
        return refusedBy;
    }

    @JsonProperty("refused_by")
    public void setRefusedBy(int refusedBy) {
        this.refusedBy = refusedBy;
    }

    public Properties withRefusedBy(int refusedBy) {
        this.refusedBy = refusedBy;
        return this;
    }

    @JsonProperty("withdrawal_type")
    public int getWithdrawalType() {
        return withdrawalType;
    }

    @JsonProperty("withdrawal_type")
    public void setWithdrawalType(int withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public Properties withWithdrawalType(int withdrawalType) {
        this.withdrawalType = withdrawalType;
        return this;
    }

    @JsonProperty("sscc")
    public String getSscc() {
        return sscc;
    }

    @JsonProperty("sscc")
    public void setSscc(String sscc) {
        this.sscc = sscc;
    }

    public Properties withSscc(String sscc) {
        this.sscc = sscc;
        return this;
    }

    @JsonProperty("prescription_num")
    public String getPrescriptionNum() {
        return prescriptionNum;
    }

    @JsonProperty("prescription_num")
    public void setPrescriptionNum(String prescriptionNum) {
        this.prescriptionNum = prescriptionNum;
    }

    public Properties withPrescriptionNum(String prescriptionNum) {
        this.prescriptionNum = prescriptionNum;
        return this;
    }

    @JsonProperty("prescription_date")
    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    @JsonProperty("prescription_date")
    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Properties withPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
        return this;
    }


    @JsonProperty("use_doc_num")
    public String getUseDocNum() {
        return useDocNum;
    }

    @JsonProperty("use_doc_num")
    public void setUseDocNum(String useDocNum) {
        this.useDocNum = useDocNum;
    }

    public Properties withUseDocNum(String useDocNum) {
        this.useDocNum = useDocNum;
        return this;
    }

    @JsonProperty("use_doc_date")
    public String getUseDocDate() {
        return useDocDate;
    }

    @JsonProperty("use_doc_date")
    public void setUseDocDate(String useDocDate) {
        this.useDocDate = useDocDate;
    }

    public Properties withUseDocDate(String useDocDate) {
        this.useDocDate = useDocDate;
        return this;
    }

    @JsonProperty("vendor_id")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("vendor_id")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Properties withVendorId(String vendorId) {
        this.vendorId = vendorId;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Properties withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @JsonProperty("refused_by_entity_id")
    public String getRefusedByEntityId() {
        return refusedByEntityId;
    }

    @JsonProperty("refused_by_entity_id")
    public void setRefusedByEntityId(String refusedByEntityId) {
        this.refusedByEntityId = refusedByEntityId;
    }

    public Properties withRefusedByEntityId(String refusedByEntityId) {
        this.refusedByEntityId = refusedByEntityId;
        return this;
    }

}
