package com.jarvis.tool.registry;

import com.jarvis.tool.executor.ToolExecutor;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ToolRegistry {

    private static final Logger logger =
            LoggerFactory.getLogger(
                    ToolRegistry.class
            );

    private final Map<String, ToolExecutor> toolMap =
            new HashMap<>();

    private final List<ToolExecutor> toolExecutors;

    public ToolRegistry(
            List<ToolExecutor> toolExecutors) {

        this.toolExecutors = toolExecutors;
    }

    @PostConstruct
    public void initializeTools() {

        logger.info(
                "Initializing tool registry"
        );

        for (ToolExecutor executor
                : toolExecutors) {

            String toolName =
                    executor.getToolDefinition()
                            .getName();

            toolMap.put(
                    toolName,
                    executor
            );

            logger.info(
                    "Registered tool: {}",
                    toolName
            );
        }
    }

    public ToolExecutor getTool(
            String toolName) {

        return toolMap.get(toolName);
    }
}