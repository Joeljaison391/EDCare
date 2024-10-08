package com.edcare.Companion.service.watsonNLUServices;

import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.natural_language_understanding.v1.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyzeData {


    private NaturalLanguageUnderstanding naturalLanguageUnderstanding;

    @Autowired
    public AnalyzeData(NaturalLanguageUnderstanding naturalLanguageUnderstanding) {
        this.naturalLanguageUnderstanding = naturalLanguageUnderstanding;
    }



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

        SummarizationOptions summarization = new SummarizationOptions.Builder()
                .limit(3)
                .build();

        SentimentOptions sentiment = new SentimentOptions.Builder()
                .document(true)
                .build();

        Features features = new Features.Builder()
                .categories(categories)
                .classifications(classifications)
                .concepts(concepts)
                .entities(entities)
                .keywords(keywords)
                .relations(relations)
                .summarization(summarization)
                .sentiment(sentiment)
                .build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(content)
                .features(features)
                .build();

        return naturalLanguageUnderstanding.analyze(parameters).execute().getResult();
    }
}
