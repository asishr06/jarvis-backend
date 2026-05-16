package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LlmExecutionStep
        implements PipelineStep {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    LlmExecutionStep.class
            );

    @Override
    public String getStepName() {
        return "LlmExecutionStep";
    }

    @Override
    public void execute(
            PipelineContext context) {

        logger.info(
                "Executing LLM inference"
        );

        String response =
                "Simulated AI response for: "
                        + context.getUserInput();

        context.setLlmResponse(
                response
        );

        logger.info(
                "LLM execution completed"
        );
    }
}