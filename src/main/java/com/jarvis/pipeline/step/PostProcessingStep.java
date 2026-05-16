package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PostProcessingStep
        implements PipelineStep {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    PostProcessingStep.class
            );

    @Override
    public String getStepName() {
        return "PostProcessingStep";
    }

    @Override
    public void execute(
            PipelineContext context) {

        logger.info(
                "Post-processing AI response"
        );

        String response =
                context.getLlmResponse()
                        + "\n\n[Processed by Jarvis Pipeline]";

        context.setLlmResponse(
                response
        );

        logger.info(
                "Post-processing completed"
        );
    }
}