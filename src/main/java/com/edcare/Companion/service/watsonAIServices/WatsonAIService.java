package com.edcare.Companion.service.watsonAIServices;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class WatsonAIService {

    private static final String SERVICE_URL = "https://eu-de.ml.cloud.ibm.com/ml/v1/text/generation?version=2023-05-02";
    private final BearerTokenGenerator bearerTokenGenerator;

    @Autowired
    public WatsonAIService(BearerTokenGenerator bearerTokenGenerator) {
        this.bearerTokenGenerator = bearerTokenGenerator;
    }

    public String generateText(String input) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();

        String bearerToken = bearerTokenGenerator.generateBearerToken();
        System.out.println("Bearer token: " + bearerToken);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("max_new_tokens", 2000);

        System.out.println("Input: " + input);

        Map<String, Object> data = new HashMap<>();
        data.put("model_id", "meta-llama/llama-2-70b-chat");
        data.put("input", input);
        data.put("parameters", parameters);
        data.put("project_id", "a946decb-49d1-4aac-9410-c48b1d576295");

        String jsonData = new Gson().toJson(data);

        RequestBody body = RequestBody.create(jsonData, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(SERVICE_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

        String responseBody = response.body().string();
        return formatResponse(responseBody);
    }

    private String formatResponse(String responseBody) {
        String generatedText = extractGeneratedText(responseBody);

        // Split the response into lines
        String[] lines = generatedText.split("\n");

        Map<String, Object> formattedResponse = new HashMap<>();
        StringBuilder story = new StringBuilder();
        List<String> interactiveQuestions = new ArrayList<>();

        // Variables to keep track of the sections
        boolean inInteractiveSection = false;
        String section = "";

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("Interactive Elements:")) {
                inInteractiveSection = true;
            } else if (line.startsWith("Introduction:") || line.startsWith("Significant Event:") || line.startsWith("Reflective Ending:")) {
                if (!section.isEmpty()) {
                    story.append(section).append("\n\n");
                }
                section = line;
                inInteractiveSection = false;
            } else if (inInteractiveSection) {
                // Add interactive questions
                if (!line.isEmpty() && !line.equals("---")) {
                    interactiveQuestions.add(line);
                }
            } else {
                section += "\n" + line;
            }
        }

        // Add the last section to the story
        if (!section.isEmpty()) {
            story.append(section).append("\n\n");
        }

        formattedResponse.put("story", story.toString().trim());
        formattedResponse.put("interactive_questions", interactiveQuestions);

        return new Gson().toJson(formattedResponse);
    }


    private String extractGeneratedText(String responseBody) {
        // Assuming responseBody is in JSON format and contains the "generated_text" field.
        Map<String, Object> responseMap = new Gson().fromJson(responseBody, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) responseMap.get("results");
        return (String) results.get(0).get("generated_text");
    }
}
