package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("kp")
    private double ratingKp;

    public Rating(double rating) {
        this.ratingKp = rating;
    }

    public double getRating() {
        return ratingKp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kp='" + ratingKp + '\'' +
                '}';
    }
}
