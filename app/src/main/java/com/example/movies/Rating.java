package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rating implements Serializable {

    @SerializedName("kp")
    private double rating;

    public Rating(double rating) {
        this.rating = rating;
    }
    public double getRating() {
        return rating;
    }

    public void setKp(double kp) {
        this.rating = kp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "kp='" + rating + '\'' +
                '}';
    }
}