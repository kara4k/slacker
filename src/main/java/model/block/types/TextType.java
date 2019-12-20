package model.block.types;

import com.google.gson.annotations.SerializedName;

public enum TextType {
    @SerializedName("plain_text")
    PLAIN_TEXT,
    @SerializedName("mrkdwn")
    MARKDOWN
}
