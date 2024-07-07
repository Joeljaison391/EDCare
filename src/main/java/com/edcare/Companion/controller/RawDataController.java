package com.edcare.Companion.controller;

import com.edcare.Companion.service.RawDataService;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analyze")
public class RawDataController {

    private final RawDataService rawDataService;

    @Autowired
    public RawDataController(RawDataService rawDataService) {
        this.rawDataService = rawDataService;
    }

    @PostMapping
    public AnalysisResults analyzeText(@RequestBody String text) {
        return rawDataService.analyzeContent(text);
    }
}
