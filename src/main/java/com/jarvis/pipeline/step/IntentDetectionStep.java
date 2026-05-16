package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IntentDetectionStep
        implements PipelineStep {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    IntentDetectionStep.class
            );

    @Override
    public String getStepName() {
        return "IntentDetectionStep";
    }

    @Override
    public void execute(
            PipelineContext context) {

        logger.info(
                "Detecting user intent"
        );

        String input =
                context.getUserInput()
                        .toLowerCase();

        String intent;

        if (input.contains("weather")) {

            intent = "WEATHER_QUERY";

        } else if (input.contains("code")) {

            intent = "CODING_QUERY";

        } else {

            intent = "GENERAL_QUERY";
        }

        context.setDetectedIntent(intent);

        logger.info(
                "Detected intent: {}",
                intent
        );
    }
}