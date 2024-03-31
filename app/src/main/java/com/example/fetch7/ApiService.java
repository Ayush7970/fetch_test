package com.example.fetch7;
import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;

// Defines an interface for API requests, specifying HTTP operations like GET.
public interface ApiService {
    @GET("hiring.json") // Specifies a GET request to "hiring.json" endpoint to fetch a list of items.
    Call<List<Item>> getItems();
}