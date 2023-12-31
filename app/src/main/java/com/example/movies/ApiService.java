package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=HCFZECX-J6BMCS0-NF9GDT5-MM894BN&rating.kp=7-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie/{idFilms}?token=HCFZECX-J6BMCS0-NF9GDT5-MM894BN")
    Single<TrailerResponse> loadTrailers(@Path("idFilms") int idFilms);

    @GET("review?token=HCFZECX-J6BMCS0-NF9GDT5-MM894BN")
    Single<ReviewResponse> loadReviews(@Query("movieId") int movieId);
}
