package com.jarvis.tool.model;

import lombok.Getter;

@Getter
public class ToolExecutionResult {

    private boolean success;
    private String result;

    public ToolExecutionResult(boolean success,
                               String result) {

        this.success = success;
        this.result = result;
    }

}