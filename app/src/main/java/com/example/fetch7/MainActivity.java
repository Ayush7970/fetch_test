package com.example.fetch7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// This is the main activity class that fetches data to be displayed in a RecyclerView.
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemsAdapter adapter;
    private List<Item> itemList = new ArrayList<>(); // The list of Item objects to display.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Sets the layout for this activity.

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemsAdapter(itemList);
        recyclerView.setAdapter(adapter);

        fetchData(); // Calls a method to fetch data from the API.
    }

    private void fetchData() {
        // Creates an instance of the ApiService to make API calls.
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Item>> call = apiService.getItems();


        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Item> fetchedItems = response.body();

                    itemList.clear();
                    for (Item item : fetchedItems) {
                        if (item.getName() != null && !item.getName().isEmpty()) {
                            itemList.add(item); // Adds each valid item to the list.
                        }
                    }
                    Collections.sort(itemList); // Sorts the list based on the criteria defined in the Item class.
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }
}
