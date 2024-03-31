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


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemsAdapter adapter;
    private List<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemsAdapter(itemList);
        recyclerView.setAdapter(adapter);

        fetchData();
    }

    private void fetchData() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Item>> call = apiService.getItems();

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Item> fetchedItems = response.body();
                    // Filter and sort the items
                    itemList.clear();
                    for (Item item : fetchedItems) {
                        if (item.getName() != null && !item.getName().isEmpty()) {
                            itemList.add(item);
                        }
                    }
                    Collections.sort(itemList);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                // Handle failure
            }
        });
    }
}
