package com.example.newsapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.newsapp1.Connection.GetDataServiceInterface;
import com.example.newsapp1.Connection.RetrofitInstance;
import com.example.newsapp1.adapter.ViewPagerAdapter;
import com.example.newsapp1.fragment.OneFragment;
import com.example.newsapp1.viewModel.Articles;
import com.example.newsapp1.viewModel.Results;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HashMap<String, ArrayList<Articles>> articleListWithSource = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String COUNTRY = "us";
        String CATEGORY = "business";

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        GetDataServiceInterface serviceInterface = RetrofitInstance.getRetrofitInstance().create(GetDataServiceInterface.class);
        Call<Results> searchQueryCall = serviceInterface.getResult(COUNTRY, CATEGORY, RetrofitInstance.API_KEY);
        searchQueryCall.enqueue(new Callback<Results>() {

            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Toast.makeText(getApplicationContext(), "connection successful", Toast.LENGTH_LONG).show();
                setupViewPager(viewPager, response.body());

            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "connection failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupViewPager(ViewPager viewPager, Results results) {
        createUniqueSourceList(results);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        ArrayList<String> sourceList = new ArrayList<>(articleListWithSource.keySet());
        for (String sourceName : sourceList) {
            Log.e("Vikram", sourceName);
            adapter.addFrag(new OneFragment(articleListWithSource.get(sourceName)), sourceName);
        }

        viewPager.setAdapter(adapter);
    }

    private void createUniqueSourceList(Results results) {
        for (Articles articles : results.getArticles()) {
            if(articleListWithSource.size()< 10) {
                if (articleListWithSource.containsKey(articles.getSource().getName())) {
                    articleListWithSource.get(articles.getSource().getName()).add(articles);
                } else {
                    ArrayList<Articles> value = new ArrayList<Articles>();
                    value.add(articles);
                    articleListWithSource.put(articles.getSource().getName(), value);
                }
            }
        }

    }
}
