package com.jarvis.prompt.manager;

import com.jarvis.prompt.loader.PromptLoader;
import com.jarvis.prompt.registry.PromptRegistry;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PromptManager {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    PromptManager.class
            );

    private final PromptLoader promptLoader;
    private final PromptRegistry promptRegistry;

    public PromptManager(
            PromptLoader promptLoader,
            PromptRegistry promptRegistry) {

        this.promptLoader = promptLoader;
        this.promptRegistry = promptRegistry;
    }

    @PostConstruct
    public void initializePrompts() {

        logger.info(
                "Initializing prompt registry"
        );

        String assistantPrompt =
                promptLoader.loadPrompt(
                        "prompts/system/assistant-system.txt"
                );

        promptRegistry.registerPrompt(
                "assistant-system",
                assistantPrompt
        );

        logger.info(
                "Registered prompt: assistant-system"
        );
    }

    public String getPrompt(String key) {

        return promptRegistry.getPrompt(key);
    }
}