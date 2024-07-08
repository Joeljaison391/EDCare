package com.edcare.Companion.controller;


import com.edcare.Companion.service.RawDataService;
import com.edcare.Companion.util.DTO.RawDataRequest;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RawDataController {

    @Autowired
    private RawDataService rawDataService;

    @PostMapping("/analyze")
    public AnalysisResults analyzeAndStoreData(@RequestBody RawDataRequest rawDataRequest) {
        System.out.println("Analyzing text: " + rawDataRequest.getContent());

        // Save the analysis result and return it
        return rawDataService.saveAnalysisResult(rawDataRequest.getUserProfileId(), rawDataRequest.getContent());
    }
}
