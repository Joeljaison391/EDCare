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

        CategoriesOptions categories = new CategoriesOptions.Builder()
                .limit(3)
                .explanation(true)
                .build();


        ClassificationsOptions classifications = new ClassificationsOptions.Builder()
                .model("tone-classifications-en-v1")
                .build();

        ConceptsOptions concepts = new ConceptsOptions.Builder()
                .limit(3)
                .build();

        EntitiesOptions entities = new EntitiesOptions.Builder()
                .sentiment(true)
                .emotion(true)
                .mentions(true)
                .limit(1)
                .build();

        KeywordsOptions keywords = new KeywordsOptions.Builder()
                .sentiment(true)
                .emotion(true)
                .limit(3)
                .build();

        RelationsOptions relations = new RelationsOptions.Builder()
                .build();


        Features features = new Features.Builder()
                .categories(categories)
                .classifications(classifications)
                .concepts(concepts)
                .entities(entities)
                .keywords(keywords)
                .relations(relations)
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
