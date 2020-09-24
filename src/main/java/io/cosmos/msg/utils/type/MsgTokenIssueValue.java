package io.cosmos.msg.utils.type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class MsgTokenIssueValue {

    @JsonProperty("description")
    @SerializedName("description")
    private String description;

    @JsonProperty("symbol")
    @SerializedName("symbol")
    private String symbol;

    @JsonProperty("original_symbol")
    @SerializedName("original_symbol")
    private String originalSymbol;

    @JsonProperty("whole_name")
    @SerializedName("whole_name")
    private String wholeName;

    @JsonProperty("total_supply")
    @SerializedName("total_supply")
    private String totalSupply;

    @JsonProperty("owner")
    @SerializedName("owner")
    private String owner;

    @JsonProperty("mintable")
    @SerializedName("mintable")
    private boolean mintable;

    public void setDescription(String description) {this.description = description;}

    public void setSymbol(String symbol) {this.symbol = symbol;}

    public void setOriginalSymbol(String originalSymbol) {this.originalSymbol = originalSymbol;}

    public void setWholeName(String wholeName) {this.wholeName = wholeName;}

    public void setTotalSupply(String totalSupply) {this.totalSupply = totalSupply;}

    public void  setOwner(String owner) {this.owner = owner;}

    public void setMintable(Boolean mintable) {this.mintable = mintable;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("description", description)
                .append("symbol", symbol)
                .append("original_symbol", originalSymbol)
                .append("whole_name", wholeName)
                .append("total_supply", totalSupply)
                .append("owner", owner)
                .append("mintable", mintable)
                .toString();
    }

}