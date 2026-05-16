package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MemoryRetrievalStep
        implements PipelineStep {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    MemoryRetrievalStep.class
            );

    @Override
    public String getStepName() {
        return "MemoryRetrievalStep";
    }

    @Override
    public void execute(
            PipelineContext context) {

        logger.info(
                "Retrieving contextual memory"
        );

        String memory =
                "No previous memory found";

        context.setRetrievedMemory(
                memory
        );

        logger.info(
                "Memory retrieval completed"
        );
    }
}