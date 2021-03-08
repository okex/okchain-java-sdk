package com.okexchain.msg.dex;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import com.okexchain.env.EnvInstance;
import com.okexchain.utils.crypto.AddressUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import sun.lwawt.macosx.CFRetainedResource;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class MsgConfirmTokenPairOwnershipValue {

    @JsonProperty("new_owner")
    @SerializedName("new_owner")
    private String fromAddress;

    @JsonProperty("product")
    @SerializedName("product")
    private String product;

    public void setFromAddress(String fromAddress) {
        if (!fromAddress.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            fromAddress = AddressUtil.convertAddressFromHexToBech32(fromAddress);
        }
        this.fromAddress = fromAddress;
    }

    public void setProduct(String product) {this.product = product;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("new_owner", fromAddress)
                .append("product", product)
                .toString();
    }
}