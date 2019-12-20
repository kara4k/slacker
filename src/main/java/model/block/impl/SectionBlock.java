package model.block.impl;

import model.block.element.impl.TextObject;
import model.block.types.Type;
import model.block.element.ElementObject;

import java.util.List;

public class SectionBlock extends AbstractBlock {

    private TextObject text;
    private List<TextObject> fields;
    private ElementObject accessory;

    public SectionBlock(final TextObject text) {
        setType(Type.SECTION);
        this.text = text;
    }

    public TextObject getText() {
        return text;
    }

    public void setText(final TextObject text) {
        this.text = text;
    }

    public List<TextObject> getFields() {
        return fields;
    }

    public void setFields(final List<TextObject> fields) {
        this.fields = fields;
    }

    public ElementObject getAccessory() {
        return accessory;
    }

    public void setAccessory(final ElementObject accessory) {
        this.accessory = accessory;
    }
}
