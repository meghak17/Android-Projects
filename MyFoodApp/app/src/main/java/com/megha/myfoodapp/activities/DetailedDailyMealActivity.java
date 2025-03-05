package com.megha.myfoodapp.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.megha.myfoodapp.R;
import com.megha.myfoodapp.adapters.DetailedDailyAdapter;
import com.megha.myfoodapp.models.DetailedDailyModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedDailyMealActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DetailedDailyModel> detailedDailyModelList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailed_daily_meal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelList);
        recyclerView.setAdapter(dailyAdapter);

        if (type != null && type.equalsIgnoreCase("breakfast")){

            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav1,"Breakfast","description","4.4","price","10 to 9"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav2,"Breakfast","description","4.4","price","10 to 9"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.fav3,"Breakfast","description","4.4","price","10 to 9"));
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("sweets")){

            imageView.setImageResource(R.drawable.sweets);
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s1,"Sweets","description","4.4","price","10 to 9"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s2,"Sweets","description","4.4","price","10 to 9"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s3,"Sweets","description","4.4","price","10 to 9"));
            detailedDailyModelList.add(new DetailedDailyModel(R.drawable.s4,"Sweets","description","4.4","price","10 to 9"));
            dailyAdapter.notifyDataSetChanged();

        }
    }
}