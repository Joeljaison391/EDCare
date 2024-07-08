package com.edcare.Companion.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisResult {
    private String id;
    private String UserProfileId;
    private String content;  // Example field; adjust according to actual analysis results
    private String AnalysisResults; // Example field; adjust according to actual analysis results
}
