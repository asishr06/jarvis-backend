package com.jarvis.api.controller;

import com.jarvis.api.request.ChatRequest;
import com.jarvis.api.response.ChatResponse;
import com.jarvis.common.response.ApiResponse;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.jarvis.pipeline.context.PipelineContext;
import com.jarvis.pipeline.orchestrator.ConversationPipelineOrchestrator;


@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final ConversationPipelineOrchestrator orchestrator;

    public ChatController(
            ConversationPipelineOrchestrator orchestrator) {

        this.orchestrator = orchestrator;
    }
    private static final Logger logger =
            LoggerFactory.getLogger(
                    ChatController.class
            );


    @PostMapping
    public ApiResponse<ChatResponse> chat(
            @Valid @RequestBody ChatRequest request) {

        logger.info(
                "Processing chat request: {}",
                request.getMessage()
        );

        PipelineContext context =
                new PipelineContext();

        context.setUserInput(
                request.getMessage()
        );

        orchestrator.execute(context);

        ChatResponse response =
                new ChatResponse(
                        context.getLlmResponse()
                );

        return new ApiResponse<>(
                true,
                "Chat processed successfully",
                response
        );
    }
}