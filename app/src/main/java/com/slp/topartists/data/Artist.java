package com.slp.topartists.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Created by Lakshmiprasad on 26-08-2017.
 */

public class Artist implements Parcelable {
    private String listeners;

    private String mbid;

    private String name;

    private Image[] image;

    private String streamable;

    private String playcount;

    private String url;

    protected Artist(Parcel in) {
        listeners = in.readString();
        mbid = in.readString();
        name = in.readString();
        streamable = in.readString();
        playcount = in.readString();
        url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(listeners);
        dest.writeString(mbid);
        dest.writeString(name);
        dest.writeString(streamable);
        dest.writeString(playcount);
        dest.writeString(url);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    @Override
    public String toString() {
        return "Artist{" +
                "listeners='" + listeners + '\'' +
                ", mbid='" + mbid + '\'' +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", streamable='" + streamable + '\'' +
                ", playcount='" + playcount + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image[] getImage() {
        return image;
    }

    public void setImage(Image[] image) {
        this.image = image;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}