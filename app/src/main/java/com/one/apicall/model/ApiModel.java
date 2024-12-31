package com.one.apicall.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class ApiModel implements Parcelable {
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("author")
    @Expose
    private String author;

    public ApiModel(Parcel in) {
        quote = in.readString();
        author = in.readString();
    }

    public static final Creator<ApiModel> CREATOR = new Creator<ApiModel>() {
        @Override
        public ApiModel createFromParcel(Parcel in) {
            return new ApiModel(in);
        }

        @Override
        public ApiModel[] newArray(int size) {
            return new ApiModel[size];
        }
    };

    public ApiModel(JSONObject jsonObject) {
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(quote);
        dest.writeString(author);
    }
}

