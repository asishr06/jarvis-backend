package com.jarvis.prompt.loader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;

@Component
public class PromptLoader {

    public String loadPrompt(String path) {

        try {

            ClassPathResource resource =
                    new ClassPathResource(path);

            return Files.readString(
                    resource.getFile().toPath()
            );

        } catch (IOException ex) {

            throw new RuntimeException(
                    "Failed to load prompt: "
                            + path
            );
        }
    }
}