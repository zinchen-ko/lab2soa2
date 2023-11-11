package com.soa.lab2soa2.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@Configuration
public class GroupServiceRetrofitConfig {


    @Bean
    public Retrofit retrofit() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:8080/api/v1/groups/")
                .client(getTlsTrustOkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit;
    }

    private OkHttpClient getTlsTrustOkHttpClient() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {}
            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {}
            @Override
            public X509Certificate[] getAcceptedIssuers() {return new X509Certificate[0];}
        }};
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new SecureRandom());
        return new OkHttpClient.Builder()
                .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
                .hostnameVerifier((hostname, session) -> true)
                .build();
    }
}
