package br.com.socialeduk.socialeduk.Response;

public class Response {
    public String status;
    public String message;
    public Object data;

    public Response(String status, String profile, Object data) {
        this.status = status;
        this.message = profile;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
