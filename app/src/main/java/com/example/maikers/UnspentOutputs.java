package com.example.maikers;

/**
 * Created by maikers on 28.08.17.
 */


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
        "address",
        "txid",
        "vout",
        "ts",
        "scriptPubKey",
        "amount",
        "confirmations",
        "confirmation",
        "confirmationsFromCache"
})
public class UnspentOutputs {

    @JsonProperty("address")
    private String address;
    @JsonProperty("txid")
    private String txid;
    @JsonProperty("vout")
    private Integer vout;
    @JsonProperty("ts")
    private Integer ts;
    @JsonProperty("scriptPubKey")
    private String scriptPubKey;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("confirmations")
    private Integer confirmations;
    @JsonProperty("confirmation")
    private Integer confirmation;
    @JsonProperty("confirmationsFromCache")
    private Boolean confirmationsFromCache;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("txid")
    public String getTxid() {
        return txid;
    }

    @JsonProperty("txid")
    public void setTxid(String txid) {
        this.txid = txid;
    }

    @JsonProperty("vout")
    public Integer getVout() {
        return vout;
    }

    @JsonProperty("vout")
    public void setVout(Integer vout) {
        this.vout = vout;
    }

    @JsonProperty("ts")
    public Integer getTs() {
        return ts;
    }

    @JsonProperty("ts")
    public void setTs(Integer ts) {
        this.ts = ts;
    }

    @JsonProperty("scriptPubKey")
    public String getScriptPubKey() {
        return scriptPubKey;
    }

    @JsonProperty("scriptPubKey")
    public void setScriptPubKey(String scriptPubKey) {
        this.scriptPubKey = scriptPubKey;
    }

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("confirmations")
    public Integer getConfirmations() {
        return confirmations;
    }

    @JsonProperty("confirmations")
    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    @JsonProperty("confirmation")
    public Integer getConfirmation() {
        return confirmation;
    }

    @JsonProperty("confirmation")
    public void setConfirmation(Integer confirmation) {
        this.confirmation = confirmation;
    }

    @JsonProperty("confirmationsFromCache")
    public Boolean getConfirmationsFromCache() {
        return confirmationsFromCache;
    }

    @JsonProperty("confirmationsFromCache")
    public void setConfirmationsFromCache(Boolean confirmationsFromCache) {
        this.confirmationsFromCache = confirmationsFromCache;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

