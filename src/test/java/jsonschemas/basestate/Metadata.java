package jsonschemas.basestate;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonPropertyOrder({
        "vat_value",
        "cost",
        "price",
        "docs",
        "recursive",
        "sgtin_new",
        "kizs"
})
public class Metadata {

    @JsonProperty("vat_value")
    private int vatValue;
    @JsonProperty("cost")
    private int cost;
    @JsonProperty("price")
    private int price;
    @JsonProperty("docs")
    private List<Doc> docs = null;
    @JsonProperty("recursive")
    private int recursive;
    @JsonProperty("sgtin_new")
    private String sgtinNew;
    @JsonProperty("kizs")
    private List<Kiz> kizs = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Metadata() {
    }

    /**
     *
     * @param price
     * @param recursive
     * @param docs
     * @param sgtinNew
     * @param kizs
     * @param vatValue
     * @param cost
     */
    public Metadata(int vatValue, int cost, int price, List<Doc> docs, int recursive, String sgtinNew, List<Kiz> kizs) {
        super();
        this.vatValue = vatValue;
        this.cost = cost;
        this.price = price;
        this.docs = docs;
        this.recursive = recursive;
        this.sgtinNew = sgtinNew;
        this.kizs = kizs;
    }

    public Metadata(int vatValue, int cost) {
        super();
        this.vatValue = vatValue;
        this.cost = cost;
    }

    public Metadata(int vatValue, int price, List<Doc> docs) {
        super();
        this.vatValue = vatValue;
        this.price = price;
        this.docs = docs;
    }


    @JsonProperty("vat_value")
    public int getVatValue() {
        return vatValue;
    }

    @JsonProperty("vat_value")
    public void setVatValue(int vatValue) {
        this.vatValue = vatValue;
    }

    public Metadata withVatValue(int vatValue) {
        this.vatValue = vatValue;
        return this;
    }

    @JsonProperty("cost")
    public int getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(int cost) {
        this.cost = cost;
    }

    public Metadata withCost(int cost) {
        this.cost = cost;
        return this;
    }

    @JsonProperty("price")
    public int getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(int price) {
        this.price = price;
    }

    public Metadata withPrice(int price) {
        this.price = price;
        return this;
    }

    @JsonProperty("docs")
    public List<Doc> getDocs() {
        return docs;
    }

    @JsonProperty("docs")
    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public Metadata withDocs(List<Doc> docs) {
        this.docs = docs;
        return this;
    }

    @JsonProperty("recursive")
    public int getRecursive() {
        return recursive;
    }

    @JsonProperty("recursive")
    public void setRecursive(int recursive) {
        this.recursive = recursive;
    }

    public Metadata withRecursive(int recursive) {
        this.recursive = recursive;
        return this;
    }

    @JsonProperty("sgtin_new")
    public String getSgtinNew() {
        return sgtinNew;
    }

    @JsonProperty("sgtin_new")
    public void setSgtinNew(String sgtinNew) {
        this.sgtinNew = sgtinNew;
    }

    public Metadata withSgtinNew(String sgtinNew) {
        this.sgtinNew = sgtinNew;
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

    public Metadata withKizs(List<Kiz> kizs) {
        this.kizs = kizs;
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

    public Metadata withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}