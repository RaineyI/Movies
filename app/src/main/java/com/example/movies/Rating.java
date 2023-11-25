package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("kp")
    private String ratingKp;

    public Rating(String rating) {
        this.ratingKp = rating;
    }

    public String getRating() {
        return ratingKp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kp='" + ratingKp + '\'' +
                '}';
    }
}
