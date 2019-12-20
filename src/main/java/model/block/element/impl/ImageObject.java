package model.block.element.impl;

import com.google.gson.annotations.SerializedName;
import model.block.types.Type;

/**
 *https://api.slack.com/reference/block-kit/block-elements#image
 */
public class ImageObject extends AbstractElementObject {

    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("alt_text")
    private final String altText;

    public ImageObject(final String imageUrl, final String altText) {
        setType(Type.IMAGE);
        this.imageUrl = imageUrl;
        this.altText = altText;
    }
}
