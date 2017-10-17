
package jsonschemas.basestate.basestate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sign_type",
        "sign",
        "metadata"
})
public class Kiz {

    @JsonProperty("sign_type")
    private int signType;
    @JsonProperty("sign")
    private String sign;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Kiz() {
    }

    /**
     *
     * @param sign
     * @param signType
     */

    public Kiz(int signType, String sign) {
        super();
        this.signType = signType;
        this.sign = sign;
    }

    public Kiz(String sign) {
        super();
        this.sign = sign;
    }

    /**
     *
     * @param sign
     * @param signType
     * @param metadata
     */
    public Kiz(int signType, String sign, Metadata metadata) {
        super();
        this.signType = signType;
        this.sign = sign;
        this.metadata = metadata;
    }

    @JsonProperty("sign_type")
    public int getSignType() {
        return signType;
    }

    @JsonProperty("sign_type")
    public void setSignType(int signType) {
        this.signType = signType;
    }

    public Kiz withSignType(int signType) {
        this.signType = signType;
        return this;
    }

    @JsonProperty("sign")
    public String getSign() {
        return sign;
    }

    @JsonProperty("sign")
    public void setSign(String sign) {
        this.sign = sign;
    }

    public Kiz withSign(String sign) {
        this.sign = sign;
        return this;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Kiz withMetadata(Metadata metadata) {
        this.metadata = metadata;
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

    public Kiz withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}