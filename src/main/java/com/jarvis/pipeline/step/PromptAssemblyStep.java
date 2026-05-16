package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;
import com.jarvis.prompt.resolver.PromptResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PromptAssemblyStep
        implements PipelineStep {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    PromptAssemblyStep.class
            );

    private final PromptResolver promptResolver;

    public PromptAssemblyStep(
            PromptResolver promptResolver) {

        this.promptResolver =
                promptResolver;
    }

    @Override
    public String getStepName() {
        return "PromptAssemblyStep";
    }

    @Override
    public void execute(
            PipelineContext context) {

        logger.info(
                "Assembling LLM prompt"
        );

        String systemPrompt =
                promptResolver
                        .resolveSystemPrompt();

        String finalPrompt =
                systemPrompt
                        + "\n\n"
                        + "User Input: "
                        + context.getUserInput()
                        + "\n"
                        + "Detected Intent: "
                        + context.getDetectedIntent()
                        + "\n"
                        + "Memory Context: "
                        + context.getRetrievedMemory();

        context.setAssembledPrompt(
                finalPrompt
        );

        logger.info(
                "Prompt assembly completed"
        );
    }
}