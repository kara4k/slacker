package model.message.impl;

import model.message.Message;

public class SimpleMessage implements Message {

    public SimpleMessage(final String text) {
        this.text = text;
    }

    private String text;

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
