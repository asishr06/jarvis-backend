package com.jarvis.api.controller;

import com.jarvis.common.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/v1/health")
    public ApiResponse<Map<String, String>> health() {

        Map<String, String> response =
                Map.of(
                        "service", "jarvis-backend",
                        "status", "UP"
                );

        return new ApiResponse<>(
                true,
                "Health check successful",
                response
        );
    }
}
