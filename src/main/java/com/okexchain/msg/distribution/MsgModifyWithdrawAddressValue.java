package com.okexchain.msg.distribution;

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
public class MsgModifyWithdrawAddressValue {

    @JsonProperty("delegator_address")
    @SerializedName("delegator_address")
    private String delegatorAddress;

    @JsonProperty("withdraw_address")
    @SerializedName("withdraw_address")
    private String withdrawAddress;

    public void setDelegatorAddress(String delegatorAddress) {
        this.delegatorAddress = delegatorAddress;
    }

    public void setWithdrawAddress(String withdrawAddress) {
        if (!withdrawAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            withdrawAddress = AddressUtil.convertAddressFromHexToBech32(withdrawAddress);
        }
        this.withdrawAddress = withdrawAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("delegator_address", delegatorAddress)
            .append("withdraw_address", withdrawAddress)
            .toString();
    }
}
