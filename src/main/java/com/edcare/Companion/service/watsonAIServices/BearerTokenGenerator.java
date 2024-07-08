package com.edcare.Companion.service.watsonAIServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class BearerTokenGenerator {

    private final ApiKeyProvider apiKeyProvider;

    @Autowired
    public BearerTokenGenerator(ApiKeyProvider apiKeyProvider) {
        this.apiKeyProvider = apiKeyProvider;
    }

    public String generateBearerToken() throws IOException, JsonProcessingException {
        String apiKey = apiKeyProvider.getApiKey();
        URL url = new URL("https://iam.cloud.ibm.com/identity/token");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        try {
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);

            String data = "grant_type=urn:ibm:params:oauth:grant-type:apikey&apikey=" + apiKey;
            conn.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));

            if (conn.getResponseCode() != 200) {
                throw new IOException("Failed to generate bearer token: HTTP error code " + conn.getResponseCode());
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(response.toString());
                return rootNode.path("access_token").asText();
            }
        } finally {
            conn.disconnect();
        }
    }
}
