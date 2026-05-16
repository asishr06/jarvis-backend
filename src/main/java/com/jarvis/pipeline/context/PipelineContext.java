package com.jarvis.pipeline.context;

import lombok.Getter;

@Getter
public class PipelineContext {

    private String userInput;

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}