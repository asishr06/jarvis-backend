package com.jarvis.tool.executor;

import com.jarvis.tool.definition.ToolDefinition;
import com.jarvis.tool.model.ToolExecutionResult;
import org.springframework.stereotype.Component;

@Component
public class SystemInfoToolExecutor
        implements ToolExecutor {

    @Override
    public ToolDefinition getToolDefinition() {

        return new ToolDefinition(
                "system-info",
                "Returns backend system information"
        );
    }

    @Override
    public ToolExecutionResult execute(
            String input) {

        return new ToolExecutionResult(
                true,
                "Jarvis Backend v1.0 running"
        );
    }
}