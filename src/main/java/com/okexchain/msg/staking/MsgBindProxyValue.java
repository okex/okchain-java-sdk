package com.okexchain.msg.staking;

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
public class MsgBindProxyValue {

    @JsonProperty("delegator_address")
    @SerializedName("delegator_address")
    private String delAddress;

    @JsonProperty("proxy_address")
    @SerializedName("proxy_address")
    private String proxyAddress;


    public void setDelAddress(String delAddress) {
        if (!delAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            delAddress = AddressUtil.convertAddressFromHexToBech32(delAddress);
        }
        this.delAddress = delAddress;
    }
    public void setProxyAddress(String proxyAddress) {
        if (!proxyAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            proxyAddress = AddressUtil.convertAddressFromHexToBech32(proxyAddress);
        }
        this.proxyAddress = proxyAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("proxy_address", this.delAddress)
                .append("reg", this.proxyAddress)
                .toString();
    }

}
