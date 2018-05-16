package com.soal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String[] gambarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final progressbar progressbar = new progressbar(MainActivity.this);
        progressbar.show();
        final Call<ResponseGambar> gambarCall = ApiService.service.getGambar();
        gambarCall.enqueue(new Callback<ResponseGambar>() {
            @Override
            public void onResponse(Call<ResponseGambar> call, Response<ResponseGambar> response) {
                if (response.isSuccessful()) {
                    ResponseGambar modelGambarList = response.body();
                    gambarList = new String[modelGambarList.getLength()];
                    for (int i = 0; i < modelGambarList.getLength(); i++) {
                        gambarList[i] = modelGambarList.getMessage(i);
                    }
                    GridView gridView = findViewById(R.id.grid);
                    gridView.setAdapter(new GridAdapter(MainActivity.this, gambarList));
                    progressbar.hide();
                } else {
                    Log.d("onResponse but Failure", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<ResponseGambar> call, Throwable t) {
                Log.d("onFailure", "Something goes wrong" + t.toString());
            }
        });
    }
}
