package model.block.impl;

import model.block.types.Type;
import model.block.element.ElementObject;

import java.util.List;

public class ContextBlock extends AbstractBlock {

    /**
     * An array of image elements and text objects. Maximum number of items is 10.
     */
    private List<ElementObject> elements;

    public ContextBlock(final List<ElementObject> elements) {
        setType(Type.CONTEXT);
        this.elements = elements;
    }

    public List<ElementObject> getElements() {
        return elements;
    }

    public void setElements(final List<ElementObject> elements) {
        this.elements = elements;
    }
}
