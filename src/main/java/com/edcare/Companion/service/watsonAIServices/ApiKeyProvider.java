package com.edcare.Companion.service.watsonAIServices;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApiKeyProvider {

    @Value("${watson.cloud.apikey}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
