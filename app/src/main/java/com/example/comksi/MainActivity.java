package com.example.comksi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Handle window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize buttons and set click listeners
        Button buttonMain = findViewById(R.id.button_main);
        Button buttonCategories = findViewById(R.id.button_categories);
        Button buttonDiscounts = findViewById(R.id.button_discounts);

        buttonMain.setOnClickListener(v -> Toast.makeText(this, "Главная clicked", Toast.LENGTH_SHORT).show());
        buttonCategories.setOnClickListener(v -> Toast.makeText(this, "Категории clicked", Toast.LENGTH_SHORT).show());
        buttonDiscounts.setOnClickListener(v -> Toast.makeText(this, "Скидки clicked", Toast.LENGTH_SHORT).show());

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Populate the RecyclerView with some dummy data
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Комикс 1", "Описание комикса 1", R.drawable.ic_comic_placeholder));
        productList.add(new Product("Комикс 2", "Описание комикса 2", R.drawable.ic_comic_placeholder));

        ProductAdapter adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
    }
}
