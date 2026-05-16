package com.jarvis.tool.executor;

import com.jarvis.tool.definition.ToolDefinition;
import com.jarvis.tool.model.ToolExecutionResult;

public interface ToolExecutor {

    ToolDefinition getToolDefinition();

    ToolExecutionResult execute(String input);
}