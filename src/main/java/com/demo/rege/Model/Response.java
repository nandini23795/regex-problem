package com.demo.rege.Model;

public class Response {

    private String match;
    private boolean error;

    public Response() {

    }

    public Response(String match, boolean error) {
        this.match = match;
        this.error = error;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
