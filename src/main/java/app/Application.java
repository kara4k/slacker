package app;


import model.SlackMessageSendResult;
import service.DefaultSlackMessageSender;
import service.SlackMessageSender;

import java.util.logging.Logger;

public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    public static void main(final String[] args) {
        final SlackMessageSender slackMessageSender = new DefaultSlackMessageSender();
        final SlackMessageSendResult result = slackMessageSender
                .sendSimpleMessage(args[0], args[1]);

        LOGGER.info(result.toString());
    }
}
