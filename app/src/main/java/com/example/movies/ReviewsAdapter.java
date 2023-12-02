package com.example.movies;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder>{

    private final static String TYPE_POSITIVE = "Позитивный";
    private final static String TYPE_NEUTRAL = "Нейтральный";
    private final static String TYPE_NEGATIVE = "Негативный";

    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false
        );
        return new ReviewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsViewHolder holder, int position) {
        Review review = reviews.get(position);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewTextReview.setText(review.getReview());

        String type = review.getType();
        if (type == null){
            type = TYPE_NEUTRAL;
        };

        int colorResId;

        switch (type) {
            case TYPE_POSITIVE:
                colorResId = R.color.green;
                break;
            case TYPE_NEUTRAL:
                colorResId = R.color.orange;
                break;
            case TYPE_NEGATIVE:
                colorResId = R.color.red;
                break;
            default:
                colorResId = R.color.orange;
        }



        int color = ContextCompat.getColor(holder.itemView.getContext(), colorResId);
        holder.linearLayoutReview.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class ReviewsViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewAuthor;
        private final TextView textViewTextReview;
        private final LinearLayout linearLayoutReview;

        public ReviewsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewTextReview = itemView.findViewById(R.id.textViewTextReview);
            linearLayoutReview = itemView.findViewById(R.id.linearLayoutReview);
        }
    }
}
