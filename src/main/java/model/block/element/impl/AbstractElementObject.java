package model.block.element.impl;

import model.block.types.Type;
import model.block.element.ElementObject;

public abstract class AbstractElementObject implements ElementObject {

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }
}
