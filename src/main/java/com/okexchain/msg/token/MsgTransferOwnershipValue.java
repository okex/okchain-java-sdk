package com.okexchain.msg.token;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import com.okexchain.env.EnvInstance;
import com.okexchain.utils.crypto.AddressUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class MsgTransferOwnershipValue {

    @JsonProperty("from_address")
    @SerializedName("from_address")
    private String fromAddress;

    @JsonProperty("symbol")
    @SerializedName("symbol")
    private String symbol;

    @JsonProperty("to_address")
    @SerializedName("to_address")
    private String toAddress;

    public void setFromAddress(String fromAddress) {
        if (!fromAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            fromAddress = AddressUtil.convertAddressFromHexToBech32(fromAddress);
        }
        this.fromAddress = fromAddress;
    }

    public void setToAddress(String toAddress) {
        if (!toAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            toAddress = AddressUtil.convertAddressFromHexToBech32(toAddress);
        }
        this.toAddress = toAddress;
    }

    public void setSymbol(String symbol) {this.symbol = symbol;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("from_address", fromAddress)
                .append("to_address", toAddress)
                .append("symbol", symbol)
                .toString();
    }

}