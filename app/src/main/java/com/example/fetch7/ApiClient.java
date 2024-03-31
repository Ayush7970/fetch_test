package com.example.fetch7;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


// Defines a class to handle API client creation using Retrofit, ensuring only one instance is used throughout the app.
public class ApiClient {
    private static final String BASE_URL = "https://fetch-hiring.s3.amazonaws.com/";
    private static Retrofit retrofit = null;

    // Provides a static method to get a Retrofit client, creating it with the BASE_URL if it doesn't already exist.
    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) // Converts JSON responses into Java objects.
                    .build();
        }
        return retrofit;
    }
}
