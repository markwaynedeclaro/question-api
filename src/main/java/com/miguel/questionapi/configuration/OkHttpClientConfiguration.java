package com.miguel.questionapi.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableAsync
public class OkHttpClientConfiguration {

    private final AppConfig appConfig;

    public OkHttpClientConfiguration(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(this.appConfig.getConnectTimeout(), TimeUnit.SECONDS)
                .readTimeout(this.appConfig.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(this.appConfig.getWriteTimeout(), TimeUnit.SECONDS)
                .build();
    }

}
