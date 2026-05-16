package com.jarvis.pipeline.step;

import com.jarvis.pipeline.context.PipelineContext;

public interface PipelineStep {

    void execute(PipelineContext context);
}