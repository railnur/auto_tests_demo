package jsonschemas.basestate.kizfilter;



import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "query_id",
        "pagination_offset",
        "pagination_limit",
        "sgtin_state",
        "gtin",
        "start_date",
        "end_date",
        "release_start_date",
        "release_end_date",
        "product_sell_name",
        "sgtin",
        "system_subj_id",
        "inn",
        "sscc",
        "batch",
        "product_name"
})
public class KizFilter {

    @JsonProperty("query_id")
    private String queryId;
    @JsonProperty("pagination_offset")
    private int paginationOffset;
    @JsonProperty("pagination_limit")
    private int paginationLimit;
    @JsonProperty("sgtin_state")
    private List<String> sgtinState = null;
    @JsonProperty("gtin")
    private String gtin;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("release_start_date")
    private String releaseStartDate;
    @JsonProperty("release_end_date")
    private String releaseEndDate;
    @JsonProperty("product_sell_name")
    private String productSellName;
    @JsonProperty("sgtin")
    private String sgtin;
    @JsonProperty("system_subj_id")
    private String systemSubjId;
    @JsonProperty("inn")
    private String inn;
    @JsonProperty("sscc")
    private String sscc;
    @JsonProperty("batch")
    private String batch;
    @JsonProperty("product_name")
    private String productName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



    /**
     *
     * @param queryId
     * @param paginationOffset
     * @param paginationLimit
     */
    public KizFilter(String queryId, int paginationOffset, int paginationLimit) {
        super();
        this.queryId = queryId;
        this.paginationOffset = paginationOffset;
        this.paginationLimit = paginationLimit;
    }

    /**
     *
     * @param inn
     * @param paginationOffset
     * @param startDate
     * @param releaseEndDate
     * @param systemSubjId
     * @param gtin
     * @param endDate
     * @param paginationLimit
     * @param sgtinState
     * @param sgtin
     * @param releaseStartDate
     * @param batch
     * @param sscc
     * @param queryId
     * @param productName
     * @param productSellName
     */
    public KizFilter(String queryId, int paginationOffset, int paginationLimit, List<String> sgtinState, String gtin, String startDate, String endDate, String releaseStartDate, String releaseEndDate, String productSellName, String sgtin, String systemSubjId, String inn, String sscc, String batch, String productName) {
        super();
        this.queryId = queryId;
        this.paginationOffset = paginationOffset;
        this.paginationLimit = paginationLimit;
        this.sgtinState = sgtinState;
        this.gtin = gtin;
        this.startDate = startDate;
        this.endDate = endDate;
        this.releaseStartDate = releaseStartDate;
        this.releaseEndDate = releaseEndDate;
        this.productSellName = productSellName;
        this.sgtin = sgtin;
        this.systemSubjId = systemSubjId;
        this.inn = inn;
        this.sscc = sscc;
        this.batch = batch;
        this.productName = productName;
    }


    @JsonProperty("query_id")
    public String getQueryId() {
        return queryId;
    }

    @JsonProperty("query_id")
    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public KizFilter withQueryId(String queryId) {
        this.queryId = queryId;
        return this;
    }

    @JsonProperty("pagination_offset")
    public int getPaginationOffset() {
        return paginationOffset;
    }

    @JsonProperty("pagination_offset")
    public void setPaginationOffset(int paginationOffset) {
        this.paginationOffset = paginationOffset;
    }

    public KizFilter withPaginationOffset(int paginationOffset) {
        this.paginationOffset = paginationOffset;
        return this;
    }

    @JsonProperty("pagination_limit")
    public int getPaginationLimit() {
        return paginationLimit;
    }

    @JsonProperty("pagination_limit")
    public void setPaginationLimit(int paginationLimit) {
        this.paginationLimit = paginationLimit;
    }

    public KizFilter withPaginationLimit(int paginationLimit) {
        this.paginationLimit = paginationLimit;
        return this;
    }

    @JsonProperty("sgtin_state")
    public List<String> getSgtinState() {
        return sgtinState;
    }

    @JsonProperty("sgtin_state")
    public void setSgtinState(List<String> sgtinState) {
        this.sgtinState = sgtinState;
    }

    public KizFilter withSgtinState(List<String> sgtinState) {
        this.sgtinState = sgtinState;
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

    public KizFilter withGtin(String gtin) {
        this.gtin = gtin;
        return this;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public KizFilter withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public KizFilter withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    @JsonProperty("release_start_date")
    public String getReleaseStartDate() {
        return releaseStartDate;
    }

    @JsonProperty("release_start_date")
    public void setReleaseStartDate(String releaseStartDate) {
        this.releaseStartDate = releaseStartDate;
    }

    public KizFilter withReleaseStartDate(String releaseStartDate) {
        this.releaseStartDate = releaseStartDate;
        return this;
    }

    @JsonProperty("release_end_date")
    public String getReleaseEndDate() {
        return releaseEndDate;
    }

    @JsonProperty("release_end_date")
    public void setReleaseEndDate(String releaseEndDate) {
        this.releaseEndDate = releaseEndDate;
    }

    public KizFilter withReleaseEndDate(String releaseEndDate) {
        this.releaseEndDate = releaseEndDate;
        return this;
    }

    @JsonProperty("product_sell_name")
    public String getProductSellName() {
        return productSellName;
    }

    @JsonProperty("product_sell_name")
    public void setProductSellName(String productSellName) {
        this.productSellName = productSellName;
    }

    public KizFilter withProductSellName(String productSellName) {
        this.productSellName = productSellName;
        return this;
    }

    @JsonProperty("sgtin")
    public String getSgtin() {
        return sgtin;
    }

    @JsonProperty("sgtin")
    public void setSgtin(String sgtin) {
        this.sgtin = sgtin;
    }

    public KizFilter withSgtin(String sgtin) {
        this.sgtin = sgtin;
        return this;
    }

    @JsonProperty("system_subj_id")
    public String getSystemSubjId() {
        return systemSubjId;
    }

    @JsonProperty("system_subj_id")
    public void setSystemSubjId(String systemSubjId) {
        this.systemSubjId = systemSubjId;
    }

    public KizFilter withSystemSubjId(String systemSubjId) {
        this.systemSubjId = systemSubjId;
        return this;
    }

    @JsonProperty("inn")
    public String getInn() {
        return inn;
    }

    @JsonProperty("inn")
    public void setInn(String inn) {
        this.inn = inn;
    }

    public KizFilter withInn(String inn) {
        this.inn = inn;
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

    public KizFilter withSscc(String sscc) {
        this.sscc = sscc;
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

    public KizFilter withBatch(String batch) {
        this.batch = batch;
        return this;
    }

    @JsonProperty("product_name")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("product_name")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public KizFilter withProductName(String productName) {
        this.productName = productName;
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

    public KizFilter withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}