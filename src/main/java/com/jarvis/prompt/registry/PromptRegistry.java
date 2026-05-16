package com.jarvis.prompt.registry;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PromptRegistry {

    private final Map<String, String> prompts =
            new HashMap<>();

    public void registerPrompt(
            String key,
            String value) {

        prompts.put(key, value);
    }

    public String getPrompt(String key) {

        return prompts.get(key);
    }
}