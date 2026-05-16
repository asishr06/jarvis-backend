package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;

public interface PipelineStep {

    String getStepName();

    void execute(PipelineContext context);
}