package com.edcare.Companion.service;

import com.edcare.Companion.model.AnalysisResult;
import com.edcare.Companion.repository.AnalysisResultRepository;
import com.edcare.Companion.service.watsonNLUServices.AnalyzeData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawDataService {


    @Autowired
    private AnalyzeData analyzeData;


    @Autowired
    private AnalysisResultRepository analysisResultRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public AnalysisResults saveAnalysisResult(String userId, String content) {
        // Analyze the text
        AnalysisResults analysisResults = analyzeData.analyzeText(content);

        AnalysisResult result = new AnalysisResult();
        result.setUserProfileId(userId);
        result.setContent(content);

        try {
            // Convert AnalysisResults to JSON string
            String analysisJson = objectMapper.writeValueAsString(analysisResults);
            result.setAnalysisResults(String.valueOf(objectMapper.readTree(analysisJson)));
            analysisResultRepository.save(result);
            System.out.println("Analysis result saved: " + result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }


        return analysisResults;
    }
}
