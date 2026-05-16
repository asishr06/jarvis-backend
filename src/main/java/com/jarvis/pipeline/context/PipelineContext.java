package com.jarvis.pipeline.context;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class PipelineContext {

    private String userInput;

    private String detectedIntent;

    private String retrievedMemory;

    private String assembledPrompt;

    private String llmResponse;

    private final Map<String, Object> metadata =
            new HashMap<>();

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setDetectedIntent(
            String detectedIntent) {

        this.detectedIntent =
                detectedIntent;
    }

    public void setRetrievedMemory(
            String retrievedMemory) {

        this.retrievedMemory =
                retrievedMemory;
    }

    public void setAssembledPrompt(
            String assembledPrompt) {

        this.assembledPrompt =
                assembledPrompt;
    }

    public void setLlmResponse(
            String llmResponse) {

        this.llmResponse =
                llmResponse;
    }

    public void addMetadata(
            String key,
            Object value) {

        metadata.put(key, value);
    }
}