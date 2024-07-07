package com.edcare.Companion.service.watsonNLUServices;

import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.natural_language_understanding.v1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeData {

    @Autowired
    private NaturalLanguageUnderstanding naturalLanguageUnderstanding;

    public AnalysisResults analyzeText(String content) {
        // Configure categories options
        CategoriesOptions categories = new CategoriesOptions.Builder()
                .limit(3)
                .build();

        // Configure classifications options
        ClassificationsOptions classifications = new ClassificationsOptions.Builder()
                .model("tone-classifications-en-v1")
                .build();

        // Build features
        Features features = new Features.Builder()
                .categories(categories)
                .classifications(classifications)
                .build();

        // Build analyze options
        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(content)
                .features(features)
                .build();

        // Execute analysis
        return naturalLanguageUnderstanding.analyze(parameters).execute().getResult();
    }
}
