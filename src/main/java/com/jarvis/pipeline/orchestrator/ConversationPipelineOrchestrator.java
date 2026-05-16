package com.jarvis.pipeline.orchestrator;

import com.jarvis.pipeline.context.PipelineContext;
import com.jarvis.pipeline.executor.PipelineExecutor;
import org.springframework.stereotype.Component;

@Component
public class ConversationPipelineOrchestrator {

    private final PipelineExecutor pipelineExecutor;

    public ConversationPipelineOrchestrator(
            PipelineExecutor pipelineExecutor) {

        this.pipelineExecutor = pipelineExecutor;
    }

    public void execute(
            PipelineContext context) {

        pipelineExecutor.execute(context);
    }
}