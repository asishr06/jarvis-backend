package com.jarvis.api.response;

import lombok.Getter;

@Getter
public class ChatResponse {

    private String response;

    public ChatResponse(String response) {
        this.response = response;
    }

}