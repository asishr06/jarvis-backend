package com.jarvis.api.controller;

import com.jarvis.api.request.ChatRequest;
import com.jarvis.api.response.ChatResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        return new ChatResponse(
                "Jarvis received: " + request.getMessage()
        );
    }
}