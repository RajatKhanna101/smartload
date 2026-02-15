package com.teleport.smartload.controller;

import com.teleport.smartload.model.OptimizeRequest;
import com.teleport.smartload.model.OptimizeResponse;
import com.teleport.smartload.service.LoadOptimizerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/load-optimizer")
public class LoadOptimizerController {

    private final LoadOptimizerService service;

    public LoadOptimizerController(LoadOptimizerService service) {
        this.service = service;
    }

    @PostMapping("/optimize")
    public ResponseEntity<OptimizeResponse> optimize(
            @Valid @RequestBody OptimizeRequest request
    ) {
        OptimizeResponse response = service.optimize(request);
        return ResponseEntity.ok(response);
    }
}
