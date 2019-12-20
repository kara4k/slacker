import model.SlackMessageSendResult;
import model.block.element.impl.TextObject;
import model.block.impl.ContextBlock;
import model.block.impl.DividerBlock;
import model.block.impl.ImageBlock;
import model.block.types.TextType;
import model.message.impl.CustomMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.DefaultSlackMessageSender;
import service.SlackMessageSender;

import java.util.Arrays;

public class DefaultSlackMessageSenderTest {

    private static final String URL = "https://hooks.slack.com/services/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";

    private SlackMessageSender messageSender;

    @Before
    public void startUp() {
        messageSender = new DefaultSlackMessageSender(URL);
    }

    @Test
    public void sendSimpleMessageTest() {
        final SlackMessageSendResult result = messageSender
                .sendSimpleMessage("Test sending simple message");

        assertResult(result);
    }

    @Test
    public void sendSimpleMessageWithSpecifiedUrlTest() {
        final SlackMessageSendResult result = messageSender
                .sendSimpleMessage(URL, "Test sending simple message with specified url");

        assertResult(result);
    }

    @Test
    public void sendCustomMessageTest() {
        final CustomMessage message = createCustomMessage();

        final SlackMessageSendResult result = messageSender.sendMessage(message);

        assertResult(result);
    }

    @Test
    public void sendCustomMessageWithSpecifiedUrlTest() {
        final CustomMessage message = createCustomMessage();

        final SlackMessageSendResult result = messageSender.sendMessage(URL, message);

        assertResult(result);
    }

    private CustomMessage createCustomMessage() {
        final TextObject textObject = new TextObject("Hey", TextType.MARKDOWN);
        final TextObject textObject2 = new TextObject("Man", TextType.MARKDOWN);
        final ContextBlock contextBlock = new ContextBlock(Arrays.asList(textObject, textObject2));

        final DividerBlock dividerBlock = new DividerBlock();

        final ImageBlock imageBlock = new ImageBlock(
                "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png",
                "Test Image");

        return new CustomMessage.Builder()
                .withBlock(contextBlock)
                .withBlock(dividerBlock)
                .withBlock(imageBlock)
                .build();
    }

    private void assertResult(final SlackMessageSendResult result) {
        Assert.assertNotNull(result);
        Assert.assertTrue(result.getSuccess());
        Assert.assertNotNull(result.getStatusCode());
        Assert.assertNotNull(result.getRequestBody());
        Assert.assertNotNull(result.getResponse());
        Assert.assertNull(result.getException());
    }
}
