package model.block.impl;

import com.google.gson.annotations.SerializedName;
import model.block.types.Type;
import model.block.Block;

public abstract class AbstractBlock implements Block {

    @SerializedName("block_id")
    private String blockId;

    private Type type;

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(final String blockId) {
        this.blockId = blockId;
    }

    protected Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }
}
