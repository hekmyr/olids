package dev.hekmyr.holidays.api.dto;

import java.util.List;

public class OdooRequestDTO {

    private String jsonrpc;
    private String method;
    private Params params;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public Params getParams() {
        return params;
    }

    public OdooRequestDTO(String jsonrpc, String method, Params params) {
        this.jsonrpc = jsonrpc;
        this.method = method;
        this.params = params;
    }

    public static class Params {

        private String service;
        private String method;
        private List<Object> args;

        public String getService() {
            return service;
        }

        public String getMethod() {
            return method;
        }

        public List<Object> getArgs() {
            return args;
        }

        public Params(String service, String method, List<Object> args) {
            this.service = service;
            this.method = method;
            this.args = args;
        }
    }
}
