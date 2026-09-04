
package com.cicd.webapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class InstanceController {

    @Value("${app.instance.name:BLUE}")
    private String instanceName;

    @Value("${server.port:8080}")
    private String serverPort;

    @GetMapping("/instance")
    public ResponseEntity<Map<String, String>> getInstanceDetails() {
        Map<String, String> response = new HashMap<>();
        response.put("instance", instanceName);
        response.put("port", serverPort);
        return ResponseEntity.ok(response);
    }
}