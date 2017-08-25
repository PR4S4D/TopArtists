package com.slp.topartists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slp.topartists.Utils.TopArtistsConstants;
import com.slp.topartists.data.Artist;
import com.slp.topartists.data.LastFMResponse;
import com.slp.topartists.data.TopArtists;
import com.slp.topartists.network.ArtistsAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements TopArtistsConstants, Callback<LastFMResponse> {

    private List<Artist> topArtists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTopArtists();
    }

    public void getTopArtists() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TOP_ARTISTS_END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ArtistsAPI artists = retrofit.create(ArtistsAPI.class);
        Call<LastFMResponse> topArtist = artists.getTopArtists(getQueryMap());
        topArtist.enqueue(this);
        Log.i("getTopArtists: ", topArtist.toString());

    }

    public Map<String, Object> getQueryMap() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(API_KEY, LAST_FM_API_KEY);
        map.put(LIMIT_LABEL, LIMIT);
        map.put("format", "json");
        return map;
    }

    @Override
    public void onResponse(Call<LastFMResponse> call, Response<LastFMResponse> response) {
        Artist[] artists = response.body().getResponse().getArtists();

        for (int i = 1; i <= artists.length; i++) {
            Log.i("Rank = " + i, artists[i - 1].getName() + "\n");
        }

    }

    @Override
    public void onFailure(Call<LastFMResponse> call, Throwable t) {
        Log.w("onFailure: ", t);

    }
}