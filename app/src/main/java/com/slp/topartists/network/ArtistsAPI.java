package com.slp.topartists.network;

import com.slp.topartists.data.LastFMResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Lakshmiprasad on 26-08-2017.
 */

public interface ArtistsAPI {

    @GET("2.0/?method=chart.gettopartists")
    Call<LastFMResponse> getTopArtists(@QueryMap Map<String,Object> queryMap);

}
