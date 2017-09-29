
package jsonschemas.basestate;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customs_code",
    "reg_date",
    "reg_number"
})
public class GtdInfo {

    @JsonProperty("customs_code")
    private String customsCode;
    @JsonProperty("reg_date")
    private String regDate;
    @JsonProperty("reg_number")
    private String regNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public GtdInfo() {
    }

    /**
     * 
     * @param regNumber
     * @param regDate
     * @param customsCode
     */
    public GtdInfo(String customsCode, String regDate, String regNumber) {
        super();
        this.customsCode = customsCode;
        this.regDate = regDate;
        this.regNumber = regNumber;
    }

    @JsonProperty("customs_code")
    public String getCustomsCode() {
        return customsCode;
    }

    @JsonProperty("customs_code")
    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode;
    }

    public GtdInfo withCustomsCode(String customsCode) {
        this.customsCode = customsCode;
        return this;
    }

    @JsonProperty("reg_date")
    public String getRegDate() {
        return regDate;
    }

    @JsonProperty("reg_date")
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public GtdInfo withRegDate(String regDate) {
        this.regDate = regDate;
        return this;
    }

    @JsonProperty("reg_number")
    public String getRegNumber() {
        return regNumber;
    }

    @JsonProperty("reg_number")
    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public GtdInfo withRegNumber(String regNumber) {
        this.regNumber = regNumber;
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

    public GtdInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
