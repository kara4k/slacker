package model.block.impl;

import com.google.gson.annotations.SerializedName;
import model.block.element.impl.TextObject;
import model.block.types.Type;

public class ImageBlock extends AbstractBlock {

    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("alt_text")
    private String altText;
    private TextObject title;

    public ImageBlock(final String imageUrl, final String altText) {
        setType(Type.IMAGE);
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAltText() {
        return altText;
    }

    public void setAltText(final String altText) {
        this.altText = altText;
    }

    public TextObject getTitle() {
        return title;
    }

    public void setTitle(final TextObject title) {
        this.title = title;
    }

    public ImageBlock withTitle(final TextObject title){
        this.title = title;
        return this;
    }
}
