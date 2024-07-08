package com.edcare.Companion.service;

import com.edcare.Companion.model.AnalysisResult;
import com.edcare.Companion.repository.AnalysisResultRepository;
import com.edcare.Companion.service.watsonAIServices.WatsonAIService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StoryGenerationService {

    @Autowired
    private AnalysisResultRepository analysisResultRepository;

    @Autowired
    private WatsonAIService watsonAIService;

    @Autowired
    private ObjectMapper objectMapper;

    public String generateStory(String analysisResultId) throws IOException {
        System.out.println("Inside generateStory method in StoryGenerationService");
        AnalysisResult analysisResult = analysisResultRepository.findById(analysisResultId)
                .orElseThrow(() -> new RuntimeException("Analysis result not found"));

//        System.out.println("Analysis result found: " + analysisResult);
        // Extract data from AnalysisResult
        String content = analysisResult.getContent();
        String AnalyzedContent = analysisResult.getAnalysisResults();

        System.out.println("Analyzed content " + AnalyzedContent);

//        JsonNode analysis = objectMapper.readTree(analysisResult.getAnalysisResults());


        // Create prompt template
        String input = String.format(
                "Based on the following analysis data, create an interactive non-fictional mood story in a third-person narrative style. " +
                        "This story should help an elderly person remember a past event in their life by including vivid descriptions, emotional connections, and familiar themes. " +
                        "Keep the names, places, and relationships constant as described in the analysis. " +
                        "Refer to the analyzed content and the actual content to craft a coherent and engaging story.\n\n" +


                        "Actual content:\n%s\n\n" +

                        "Output Structure:\n" +
                        "1. Introduction: Introduce the main characters and setting. Use the names and relationships provided in the analysis.\n" +
                        "2. Significant Event: Describe a significant event in detail, ensuring vivid descriptions and emotional connections.\n" +
                        "3. Reflective Ending: Conclude with a reflective ending that emphasizes the emotional and cognitive connections for the elderly person.\n" +
                        "4. Interactive Elements: Incorporate questions or prompts within the story to engage the elderly person, encouraging them to reflect on similar experiences or share their thoughts.\n\n" +

                        "Ensure the story is engaging, emotionally resonant, and supports cognitive engagement for the elderly person.",
                content
        );


//        String input = "Generate a fictional story that depecits inidan culture";


        return watsonAIService.generateText(input);
    }
}
