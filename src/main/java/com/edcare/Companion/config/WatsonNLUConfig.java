package com.edcare.Companion.config;

import com.edcare.Companion.util.HttpClient;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WatsonNLUConfig {

    @Value("${watson.nlu.apikey}")
    private String apiKey;

    @Value("${watson.nlu.url}")
    private String serviceUrl;

    @Bean
    public NaturalLanguageUnderstanding naturalLanguageUnderstanding() {
        IamAuthenticator authenticator = new IamAuthenticator(apiKey);
        NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2022-04-07", authenticator);
        OkHttpClient customHttpClient = HttpClient.createClient();
        naturalLanguageUnderstanding.setClient(customHttpClient);
        naturalLanguageUnderstanding.setServiceUrl(serviceUrl);
        return naturalLanguageUnderstanding;
    }
}
