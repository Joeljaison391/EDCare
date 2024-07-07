package com.edcare.Companion.util;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class HttpClient {

    public static OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(260, TimeUnit.SECONDS)  // Set your desired connect timeout
                .readTimeout(260, TimeUnit.SECONDS)     // Set your desired read timeout
                .writeTimeout(260, TimeUnit.SECONDS)    // Set your desired write timeout
                .build();
    }
}
