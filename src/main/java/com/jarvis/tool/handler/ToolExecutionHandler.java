package com.jarvis.tool.handler;

import com.jarvis.tool.executor.ToolExecutor;
import com.jarvis.tool.model.ToolExecutionResult;
import com.jarvis.tool.registry.ToolRegistry;
import org.springframework.stereotype.Component;

@Component
public class ToolExecutionHandler {

    private final ToolRegistry toolRegistry;

    public ToolExecutionHandler(
            ToolRegistry toolRegistry) {

        this.toolRegistry = toolRegistry;
    }

    public ToolExecutionResult executeTool(
            String toolName,
            String input) {

        ToolExecutor executor =
                toolRegistry.getTool(
                        toolName
                );

        if (executor == null) {

            return new ToolExecutionResult(
                    false,
                    "Tool not found: "
                            + toolName
            );
        }

        return executor.execute(input);
    }
}