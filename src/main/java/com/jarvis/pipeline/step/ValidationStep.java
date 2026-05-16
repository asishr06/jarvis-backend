package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.jarvis.prompt.resolver.PromptResolver;
import com.jarvis.tool.handler.ToolExecutionHandler;
import com.jarvis.tool.model.ToolExecutionResult;

@Component
public class ValidationStep
        implements PipelineStep {

    private final PromptResolver promptResolver;
    private final ToolExecutionHandler toolExecutionHandler;


    public ValidationStep(
            PromptResolver promptResolver,
            ToolExecutionHandler toolExecutionHandler) {

        this.promptResolver = promptResolver;
        this.toolExecutionHandler =
                toolExecutionHandler;
    }

    private static final Logger logger =
            LoggerFactory.getLogger(
                    ValidationStep.class
            );

    @Override
    public String getStepName() {
        return "ValidationStep";
    }

    @Override
    public void execute(
            PipelineContext context) {

        ToolExecutionResult toolResult =
                toolExecutionHandler.executeTool(
                        "system-info",
                        ""
                );

        logger.info(
                "Tool execution result: {}",
                toolResult.getResult()
        );

        String systemPrompt =
                promptResolver.resolveSystemPrompt();

        logger.info(
                "Resolved system prompt length: {}",
                systemPrompt.length()
        );

        logger.info(
                "Validating pipeline context"
        );

        if (context.getUserInput() == null
                || context.getUserInput().isBlank()) {

            throw new RuntimeException(
                    "User input cannot be blank"
            );
        }
    }
}