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
public class MsgRegProxyValue {
    @JsonProperty("proxy_address")
    @SerializedName("proxy_address")
    private String proxyAddress;

    @JsonProperty("reg")
    @SerializedName("reg")
    private boolean reg;

    public void setProxyAddress(String proxyAddress) {
        if (!proxyAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            proxyAddress = AddressUtil.convertAddressFromHexToBech32(proxyAddress);
        }
        this.proxyAddress = proxyAddress;
    }

    public void setReg(boolean reg) {
        this.reg = reg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("proxy_address", this.proxyAddress)
                .append("reg", this.reg)
                .toString();
    }
}
