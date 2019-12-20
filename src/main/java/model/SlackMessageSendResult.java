package model;

public class SlackMessageSendResult {

    private Boolean success;
    private Integer statusCode;
    private String requestBody;
    private String response;
    private Exception exception;

    private SlackMessageSendResult(final SlackMessageSendResult.Builder builder) {
        this.success = builder.success;
        this.statusCode = builder.statusCode;
        this.requestBody = builder.requestBody;
        this.response = builder.response;
        this.exception = builder.exception;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(final String response) {
        this.response = response;
    }

    public Exception getException() {
        return exception;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(final String requestBody) {
        this.requestBody = requestBody;
    }

    public void setException(final Exception exception) {
        this.exception = exception;
    }

    @Override
    public String toString() {
        return "SlackMessageSendResult{" +
                "success=" + success +
                ", statusCode=" + statusCode +
                ", requestBody='" + requestBody + '\'' +
                ", response='" + response + '\'' +
                ", exception=" + exception +
                '}';
    }

    public static class Builder{
        private Boolean success;
        private Integer statusCode;
        private final String requestBody;
        private String response;
        private Exception exception;

        public Builder(final String requestBody) {
            this.requestBody = requestBody;
        }

        public Builder success(final Integer statusCode, final String response){
            this.success = true;
            this.statusCode = statusCode;
            this.response = response;
            return this;
        }

        public Builder fail(final Integer statusCode, final String response){
            this.success = false;
            this.statusCode = statusCode;
            this.response = response;
            return this;
        }

        public Builder exception(final Exception exception){
            this.success = false;
            this.exception = exception;
            return this;
        }

        public SlackMessageSendResult build() {
            return new SlackMessageSendResult(this);
        }

    }
}
