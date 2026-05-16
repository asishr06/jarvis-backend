package com.jarvis.tool.definition;

import lombok.Getter;

@Getter
public class ToolDefinition {

    private String name;
    private String description;

    public ToolDefinition(String name,
                          String description) {

        this.name = name;
        this.description = description;
    }

}