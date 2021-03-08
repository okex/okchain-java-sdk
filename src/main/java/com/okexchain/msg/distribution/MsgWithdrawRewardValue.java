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
public class MsgWithdrawRewardValue {

    @JsonProperty("validator_address")
    @SerializedName("validator_address")
    private String validatorAddress;

    public void setValidatorAddress(String validatorAddress) {
        if (!validatorAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            validatorAddress = AddressUtil.convertAddressFromHexToBech32(validatorAddress);
        }
        this.validatorAddress = validatorAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("validator_address", validatorAddress)
            .toString();
    }
}
