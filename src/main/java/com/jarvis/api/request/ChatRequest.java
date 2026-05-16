package com.jarvis.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ChatRequest {

    @NotBlank(message = "Message cannot be blank")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }
}