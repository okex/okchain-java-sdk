package com.okexchain.msg.staking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import com.okexchain.env.EnvInstance;
import com.okexchain.msg.common.DecCoin;
import com.okexchain.utils.crypto.AddressUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class MsgDepositValue {

    @JsonProperty("delegator_address")
    @SerializedName("delegator_address")
    private String delegatorAddress;

    @JsonProperty("quantity")
    @SerializedName("quantity")
    private DecCoin amount;

    public void setDelegatorAddress(String delegatorAddress) {
        if (!delegatorAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            delegatorAddress = AddressUtil.convertAddressFromHexToBech32(delegatorAddress);
        }
        this.delegatorAddress = delegatorAddress;
    }

    public void setAmount(DecCoin amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("delegatorAddress", this.delegatorAddress)
                .append("amount", this.amount)
                .toString();
    }

}
