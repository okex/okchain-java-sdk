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
public class MsgTokenModifyValue {

    @JsonProperty("description")
    @SerializedName("description")
    private String description;

    @JsonProperty("description_modified")
    @SerializedName("description_modified")
    private boolean IsDescriptionModified;

    @JsonProperty("owner")
    @SerializedName("owner")
    private String owner;

    @JsonProperty("symbol")
    @SerializedName("symbol")
    private String symbol;

    @JsonProperty("whole_name")
    @SerializedName("whole_name")
    private String wholeName;

    @JsonProperty("whole_name_modified")
    @SerializedName("whole_name_modified")
    private Boolean IsWholeNameModified;


    public void setDescription(String description) {this.description = description;}

    public void setSymbol(String symbol) {this.symbol = symbol;}

    public void setDescriptionModified(Boolean IsDescriptionModified) {this.IsDescriptionModified = IsDescriptionModified;}

    public void setWholeName(String wholeName) {this.wholeName = wholeName;}

    public void setOwner(String owner) {
        if (!owner.startsWith(EnvInstance.getEnv().GetMainPrefix())) {
            owner = AddressUtil.convertAddressFromHexToBech32(owner);
        }
        this.owner = owner;
    }

    public void setWholeNameModified(Boolean IsWholeNameModified) {this.IsWholeNameModified = IsWholeNameModified;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("description", description)
                .append("description_modified", IsDescriptionModified)
                .append("owner", owner)
                .append("symbol", symbol)
                .append("whole_name", wholeName)
                .append("whole_name_modified", IsWholeNameModified)
                .toString();
    }

}