package model.block.types;

import com.google.gson.annotations.SerializedName;

public enum Type {

    @SerializedName("section")
    SECTION,
    @SerializedName("divider")
    DIVIDER,
    @SerializedName("image")
    IMAGE,
    @SerializedName("context")
    CONTEXT

}
