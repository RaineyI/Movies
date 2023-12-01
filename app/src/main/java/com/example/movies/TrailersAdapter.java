package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.trailerViewHolder> {

    private List<Trailer> trailers = new ArrayList<>();

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public trailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.trailer_item,
                parent,
                false
        );
        return new trailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull trailerViewHolder holder, int position) {
        Trailer trailer = trailers.get(position);
        holder.textViewTrailer.setText(trailer.getName());
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    static class trailerViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewTrailer;

        public trailerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTrailer = itemView.findViewById(R.id.textViewTrailer);
        }
    }
}
