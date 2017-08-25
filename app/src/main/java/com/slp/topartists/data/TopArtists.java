package com.slp.topartists.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lakshmiprasad on 26-08-2017.
 */

public class TopArtists {

    @SerializedName("artist")
    private Artist[] artists;

    public Artist[] getArtists() {
        return artists;
    }

    public void setArtists(Artist[] artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        return "TopArtists{" +
                "artists=" + Arrays.toString(artists) +
                '}';
    }

}

