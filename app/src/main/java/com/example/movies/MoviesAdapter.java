package com.example.movies;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies = new ArrayList<>();
    private OnReachAndListener onReachAndListener;

    private OnMovieClickListener onMovieClickListener;

    public void setOnReachAndListener(OnReachAndListener onReachAndListener) {
        this.onReachAndListener = onReachAndListener;
    }

    public void setOnMovieClickListener(OnMovieClickListener onMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener;
    }

    private static final String URL_NO_POSTER = "https://st.kp.yandex.net/images/no-poster.gif";

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_item,
                parent,
                false
        );
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movies.get(position);
        Poster poster = movie.getPoster();
        if (poster != null) {
            Glide.with(holder.itemView)
                    .load(movie.getPoster().getUrl())
                    .into(holder.imageViewPoster);
        } else {
            Glide.with(holder.itemView)
                    .load(URL_NO_POSTER)
                    .into(holder.imageViewPoster);
        }

        double rating = movie.getRating().getRating();
        int backgroundId;
        if (rating > 7) {
            backgroundId = R.drawable.circle_green;
        } else if (rating > 5) {
            backgroundId = R.drawable.circle_orange;
        } else {
            backgroundId = R.drawable.circle_red;
        }

        Drawable background = ContextCompat.getDrawable(holder.itemView.getContext(), backgroundId);
        holder.textViewRating.setBackground(background);
        holder.textViewRating.setText(String.format("%.1f", movie.getRating().getRating()));

        if(position >= movies.size() - 10 && onReachAndListener != null) {
            onReachAndListener.onReachAnd();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onMovieClickListener != null) {
                    onMovieClickListener.onMovieClick(movie);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    interface OnReachAndListener {
        void onReachAnd();
    }

    interface OnMovieClickListener {
        void onMovieClick(Movie movie);
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewPoster;
        private final TextView textViewRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.imageViewPoster);
            textViewRating = itemView.findViewById(R.id.textViewRating);
        }
    }
}
