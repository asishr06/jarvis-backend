package com.jarvis.api.request;

import lombok.Getter;

@Getter
public class ChatRequest {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}