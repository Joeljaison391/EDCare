package com.edcare.Companion.service;

import com.edcare.Companion.service.watsonNLUServices.AnalyzeData;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawDataService {

    private final AnalyzeData categorize;

    @Autowired
    public RawDataService(AnalyzeData categorize) {
        this.categorize = categorize;
    }

    public AnalysisResults analyzeContent(String content) {
        return categorize.analyzeText(content);
    }
}
