package com.example.moviesjava;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1.4/movie?token=HCFZECX-J6BMCS0-NF9GDT5-MM894BN&rating.kp=7-10&sortField=votes.kp&sortType=-1&limit=40")
    Single<MovieResponse> loadMovies(@Query("page") int page);

}
