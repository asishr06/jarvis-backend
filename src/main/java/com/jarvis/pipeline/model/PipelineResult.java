package com.jarvis.pipeline.model;

public class PipelineResult {

    private boolean success;
    private String response;

    public PipelineResult(boolean success,
                          String response) {

        this.success = success;
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getResponse() {
        return response;
    }
}