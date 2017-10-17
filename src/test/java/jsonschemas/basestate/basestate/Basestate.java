
package jsonschemas.basestate.basestate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({
    "query_id",
    "kizs",
    "properties"
})
public class Basestate {

    @JsonProperty("query_id")
    private String queryId;
    @JsonProperty("kizs")
    private List<Kiz> kizs = null;
    @JsonProperty("properties")
    private Properties properties;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Basestate() {
    }

    /**
     * 
     * @param kizs
     * @param properties
     * @param queryId
     */
    public Basestate(String queryId, List<Kiz> kizs, Properties properties) {
        super();
        this.queryId = queryId;
        this.kizs = kizs;
        this.properties = properties;
    }

    @JsonProperty("query_id")
    public String getQueryId() {
        return queryId;
    }

    @JsonProperty("query_id")
    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public Basestate withQueryId(String queryId) {
        this.queryId = queryId;
        return this;
    }

    @JsonProperty("kizs")
    public List<Kiz> getKizs() {
        return kizs;
    }

    @JsonProperty("kizs")
    public void setKizs(List<Kiz> kizs) {
        this.kizs = kizs;
    }

    public Basestate withKizs(List<Kiz> kizs) {
        this.kizs = kizs;
        return this;
    }

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Basestate withProperties(Properties properties) {
        this.properties = properties;
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

    public Basestate withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
