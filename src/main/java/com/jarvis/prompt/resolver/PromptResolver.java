package com.jarvis.prompt.resolver;

import com.jarvis.prompt.manager.PromptManager;
import org.springframework.stereotype.Component;

@Component
public class PromptResolver {

    private final PromptManager promptManager;

    public PromptResolver(
            PromptManager promptManager) {

        this.promptManager = promptManager;
    }

    public String resolveSystemPrompt() {

        return promptManager.getPrompt(
                "assistant-system"
        );
    }
}