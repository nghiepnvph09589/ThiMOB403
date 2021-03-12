package com.example.thi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Products> data;
    private DataAdapter adapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recyler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://batdongsanabc.000webhostapp.com/mob306/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestRe request = retrofit.create(RequestRe.class);
        Call<ListProducts> call = request.getJSON();
        call.enqueue(new Callback<ListProducts>() {
            @Override
            public void onResponse(Call<ListProducts> call, Response<ListProducts> response) {
                ListProducts listContact = response.body();
                data = new
                        ArrayList<>(Arrays.asList(listContact.getProducts()));
                adapter = new DataAdapter(data);
                recyclerView.setAdapter(adapter);
            }



            @Override
            public void onFailure(Call<ListProducts> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}