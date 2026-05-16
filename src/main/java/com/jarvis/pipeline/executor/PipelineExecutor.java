package com.jarvis.pipeline.executor;

import com.jarvis.pipeline.context.PipelineContext;
import com.jarvis.pipeline.step.PipelineStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PipelineExecutor {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    PipelineExecutor.class
            );

    private final List<PipelineStep> pipelineSteps;

    public PipelineExecutor(
            List<PipelineStep> pipelineSteps) {

        this.pipelineSteps = pipelineSteps;
    }

    public void execute(
            PipelineContext context) {

        for (PipelineStep step : pipelineSteps) {

            logger.info(
                    "Executing pipeline step: {}",
                    step.getStepName()
            );

            step.execute(context);
        }
    }
}