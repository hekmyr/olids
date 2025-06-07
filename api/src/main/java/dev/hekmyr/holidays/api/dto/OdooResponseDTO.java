package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooResponseDTO {

    private String jsonrpc;
    private Number id;
    private OdooError error;

    public boolean hasError() {
        return this.error != null;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public OdooError getError() {
        return error;
    }

    public void setError(OdooError error) {
        this.error = error;
    }

    public static class OdooError {

        public int code;
        public String message;
        public OdooErrorData data;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public OdooErrorData getData() {
            return data;
        }

        public void setData(OdooErrorData data) {
            this.data = data;
        }
    }

    public static class OdooErrorData {

        public String name;
        public String debug;
        public String message;
        public List<String> arguments;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDebug() {
            return debug;
        }

        public void setDebug(String debug) {
            this.debug = debug;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<String> getArguments() {
            return arguments;
        }

        public void setArguments(List<String> arguments) {
            this.arguments = arguments;
        }
    }
}
