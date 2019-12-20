package model.message.impl;

import model.block.Block;
import model.message.Message;

import java.util.ArrayList;
import java.util.List;

public class CustomMessage implements Message {

    private List<Block> blocks;

    public CustomMessage(final List<Block> blocks) {
        this.blocks = blocks;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(final List<Block> blocks) {
        this.blocks = blocks;
    }

    public static class Builder {
        private static final List<Block> blocks = new ArrayList<>();

        public Builder withBlock(final Block block){
            blocks.add(block);
            return this;
        }

        public CustomMessage build(){
            return new CustomMessage(blocks);
        }
    }
}
