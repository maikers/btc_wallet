package com.example.maikers;

/**
 * Created by maikers on 18.08.17.
 */
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import com.fasterxml.jackson.annotation.JsonAnyGetter;
        import com.fasterxml.jackson.annotation.JsonAnySetter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "addrStr",
        "balance",
        "balanceSat",
        "totalReceived",
        "totalReceivedSat",
        "totalSent",
        "totalSentSat",
        "unconfirmedBalance",
        "unconfirmedBalanceSat",
        "unconfirmedTxApperances",
        "txApperances",
        "transactions"
})
public class Addr {
    @JsonProperty("addrStr")
    private String addrStr;
    @JsonProperty("balance")
    private Integer balance;
    @JsonProperty("balanceSat")
    private Integer balanceSat;
    @JsonProperty("totalReceived")
    private Integer totalReceived;
    @JsonProperty("totalReceivedSat")
    private Integer totalReceivedSat;
    @JsonProperty("totalSent")
    private Integer totalSent;
    @JsonProperty("totalSentSat")
    private Integer totalSentSat;
    @JsonProperty("unconfirmedBalance")
    private Integer unconfirmedBalance;
    @JsonProperty("unconfirmedBalanceSat")
    private Integer unconfirmedBalanceSat;
    @JsonProperty("unconfirmedTxApperances")
    private Integer unconfirmedTxApperances;
    @JsonProperty("txApperances")
    private Integer txApperances;
    @JsonProperty("transactions")
    private List<Object> transactions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("addrStr")
    public String getAddrStr() {
        return addrStr;
    }

    @JsonProperty("addrStr")
    public void setAddrStr(String addrStr) {
        this.addrStr = addrStr;
    }

    @JsonProperty("balance")
    public Integer getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @JsonProperty("balanceSat")
    public Integer getBalanceSat() {
        return balanceSat;
    }

    @JsonProperty("balanceSat")
    public void setBalanceSat(Integer balanceSat) {
        this.balanceSat = balanceSat;
    }

    @JsonProperty("totalReceived")
    public Integer getTotalReceived() {
        return totalReceived;
    }

    @JsonProperty("totalReceived")
    public void setTotalReceived(Integer totalReceived) {
        this.totalReceived = totalReceived;
    }

    @JsonProperty("totalReceivedSat")
    public Integer getTotalReceivedSat() {
        return totalReceivedSat;
    }

    @JsonProperty("totalReceivedSat")
    public void setTotalReceivedSat(Integer totalReceivedSat) {
        this.totalReceivedSat = totalReceivedSat;
    }

    @JsonProperty("totalSent")
    public Integer getTotalSent() {
        return totalSent;
    }

    @JsonProperty("totalSent")
    public void setTotalSent(Integer totalSent) {
        this.totalSent = totalSent;
    }

    @JsonProperty("totalSentSat")
    public Integer getTotalSentSat() {
        return totalSentSat;
    }

    @JsonProperty("totalSentSat")
    public void setTotalSentSat(Integer totalSentSat) {
        this.totalSentSat = totalSentSat;
    }

    @JsonProperty("unconfirmedBalance")
    public Integer getUnconfirmedBalance() {
        return unconfirmedBalance;
    }

    @JsonProperty("unconfirmedBalance")
    public void setUnconfirmedBalance(Integer unconfirmedBalance) {
        this.unconfirmedBalance = unconfirmedBalance;
    }

    @JsonProperty("unconfirmedBalanceSat")
    public Integer getUnconfirmedBalanceSat() {
        return unconfirmedBalanceSat;
    }

    @JsonProperty("unconfirmedBalanceSat")
    public void setUnconfirmedBalanceSat(Integer unconfirmedBalanceSat) {
        this.unconfirmedBalanceSat = unconfirmedBalanceSat;
    }

    @JsonProperty("unconfirmedTxApperances")
    public Integer getUnconfirmedTxApperances() {
        return unconfirmedTxApperances;
    }

    @JsonProperty("unconfirmedTxApperances")
    public void setUnconfirmedTxApperances(Integer unconfirmedTxApperances) {
        this.unconfirmedTxApperances = unconfirmedTxApperances;
    }

    @JsonProperty("txApperances")
    public Integer getTxApperances() {
        return txApperances;
    }

    @JsonProperty("txApperances")
    public void setTxApperances(Integer txApperances) {
        this.txApperances = txApperances;
    }

    @JsonProperty("transactions")
    public List<Object> getTransactions() {
        return transactions;
    }

    @JsonProperty("transactions")
    public void setTransactions(List<Object> transactions) {
        this.transactions = transactions;
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