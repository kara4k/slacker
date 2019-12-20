package model.block.element.impl;

import com.google.gson.annotations.SerializedName;
import model.block.types.TextType;
import model.block.element.ElementObject;

/**
 * https://api.slack.com/reference/block-kit/composition-objects#text
 */
public class TextObject implements ElementObject {

    @SerializedName("type")
    private TextType textType;
    private String text;
    private Boolean emoji;
    private Boolean verbatim;

    public TextObject(final String text, final TextType textType) {
        this.text = text;
        this.textType = textType;
    }

    public TextType getTextType() {
        return textType;
    }

    public void setTextType(final TextType textType) {
        this.textType = textType;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Boolean getEmoji() {
        return emoji;
    }

    public void setEmoji(final Boolean emoji) {
        this.emoji = emoji;
    }

    public Boolean getVerbatim() {
        return verbatim;
    }

    public void setVerbatim(final Boolean verbatim) {
        this.verbatim = verbatim;
    }

    public TextObject withEmoji(final Boolean emoji) {
        this.emoji = emoji;
        return this;
    }

    public TextObject withVerbatim(final Boolean verbatim) {
        this.verbatim = verbatim;
        return this;
    }
}
