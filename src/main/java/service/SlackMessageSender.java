package service;

import model.message.Message;
import model.SlackMessageSendResult;

public interface SlackMessageSender {

    SlackMessageSendResult sendSimpleMessage(String text);

    SlackMessageSendResult sendSimpleMessage(String url, String text);

    SlackMessageSendResult sendMessage(Message message);

    SlackMessageSendResult sendMessage(String url, Message message);

}
