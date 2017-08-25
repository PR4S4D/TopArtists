package com.slp.topartists.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lakshmiprasad on 26-08-2017.
 */

public class LastFMResponse {

    @SerializedName("artists")
    private TopArtists response;


    @Override
    public String toString() {
        return "LastFMResponse{" +
                "response=" + response +
                '}';
    }

    public TopArtists getResponse() {
        return response;
    }

    public void setResponse(TopArtists response) {
        this.response = response;
    }
}

