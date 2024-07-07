package com.edcare.Companion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AnalyzedDataProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    @Column(length = 10000)
    private String description;  // Description of the incident

    @ElementCollection
    @CollectionTable(name = "analyzed_entities", joinColumns = @JoinColumn(name = "analyzed_profile_id"))
    @MapKeyColumn(name = "entity_key")
    @Column(name = "entity_value", length = 1000)
    private Map<String, String> entities;  // Entities extracted from WatsonX NLU

    @ElementCollection
    @CollectionTable(name = "analyzed_keywords", joinColumns = @JoinColumn(name = "analyzed_profile_id"))
    @Column(name = "keyword_value")
    private List<String> keywords;  // Keywords extracted from WatsonX NLU

    @ElementCollection
    @CollectionTable(name = "analyzed_categories", joinColumns = @JoinColumn(name = "analyzed_profile_id"))
    @Column(name = "category_value")
    private List<String> categories;  // Categories assigned by WatsonX NLU

    @ElementCollection
    @CollectionTable(name = "analyzed_emotions", joinColumns = @JoinColumn(name = "analyzed_profile_id"))
    @Column(name = "emotion_value")
    private Map<String, Double> emotions;  // Emotion scores extracted from WatsonX NLU

    @ElementCollection
    @CollectionTable(name = "analyzed_sentiments", joinColumns = @JoinColumn(name = "analyzed_profile_id"))
    @MapKeyColumn(name = "sentiment_key")
    @Column(name = "sentiment_value")
    private Map<String, Double> sentiments;  // Sentiment scores extracted from WatsonX NLU

    @ElementCollection
    @CollectionTable(name = "analyzed_relations", joinColumns = @JoinColumn(name = "analyzed_profile_id"))
    @MapKeyColumn(name = "relation_key")
    @Column(name = "relation_value", length = 1000)
    private Map<String, String> relations;  // Relations extracted from WatsonX NLU

    @ElementCollection
    @CollectionTable(name = "analyzed_classifications", joinColumns = @JoinColumn(name = "analyzed_profile_id"))
    @Column(name = "classification_value")
    private List<String> classifications;  // Classifications assigned by WatsonX NLU

    @Column(length = 10000)
    private String summary;  // Summary of the incident by WatsonX NLU

    private String language;  // Language of the incident text

    // Getters and setters (Lombok generates these)
}
