package jsonschemas.basestate.basestate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "doc_type",
        "doc_num",
        "doc_date"
})
public class Doc {

    @JsonProperty("doc_type")
    private int docType;
    @JsonProperty("doc_num")
    private String docNum;
    @JsonProperty("doc_date")
    private String docDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Doc() {
    }

    /**
     *
     * @param docNum
     * @param docType
     * @param docDate
     */
    public Doc(int docType, String docNum, String docDate) {
        super();
        this.docType = docType;
        this.docNum = docNum;
        this.docDate = docDate;
    }

    @JsonProperty("doc_type")
    public int getDocType() {
        return docType;
    }

    @JsonProperty("doc_type")
    public void setDocType(int docType) {
        this.docType = docType;
    }

    public Doc withDocType(int docType) {
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

    public Doc withDocNum(String docNum) {
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

    public Doc withDocDate(String docDate) {
        this.docDate = docDate;
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

    public Doc withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}