package service;

import com.google.gson.Gson;
import model.SlackMessageSendResult;
import model.message.Message;
import model.message.impl.SimpleMessage;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DefaultSlackMessageSender implements SlackMessageSender {

    private String url;

    public DefaultSlackMessageSender() {
    }

    public DefaultSlackMessageSender(final String url) {
        this.url = url;
    }

    @Override
    public SlackMessageSendResult sendSimpleMessage(final String text) {
        return sendSimpleMessage(this.url, text);
    }

    @Override
    public SlackMessageSendResult sendSimpleMessage(final String url, final String text) {
        return send(url, new SimpleMessage(text));
    }

    @Override
    public SlackMessageSendResult sendMessage(final Message message) {
        return sendMessage(this.url, message);
    }

    @Override
    public SlackMessageSendResult sendMessage(final String url, final Message message) {
        return send(url, message);
    }

    private SlackMessageSendResult send(final String url, final Message message) {
        final String jsonBody = new Gson().toJson(message);

        try {
            final HttpsURLConnection connection = executeMessageSend(url, jsonBody);

            return createResult(connection, jsonBody);
        } catch (final IOException e) {
            return new SlackMessageSendResult.Builder(jsonBody).exception(e).build();
        }
    }

    private HttpsURLConnection executeMessageSend(final String url,
                                                  final String jsonBody) throws IOException {

        final URL netUrl = new URL(url);
        final HttpsURLConnection connection = (HttpsURLConnection) netUrl.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        connection.connect();

        try (final OutputStream os = connection.getOutputStream()) {
            os.write(jsonBody.getBytes());
        }

        return connection;
    }

    private SlackMessageSendResult createResult(final HttpURLConnection connection,
                                                final String jsonBody) throws IOException {

        final int responseCode = connection.getResponseCode();

        if (responseCode > 199 && responseCode < 300) {
            final String response = extractResponse(connection.getInputStream());

            return new SlackMessageSendResult.Builder(jsonBody)
                    .success(responseCode, response)
                    .build();
        } else {
            final String response = extractResponse(connection.getErrorStream());

            return new SlackMessageSendResult.Builder(jsonBody)
                    .fail(responseCode, response)
                    .build();
        }
    }

    private String extractResponse(final InputStream inputStream) throws IOException {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        final byte[] buffer = new byte[1024];
        int length;

        while ((length = inputStream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        return result.toString(StandardCharsets.UTF_8.name());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
