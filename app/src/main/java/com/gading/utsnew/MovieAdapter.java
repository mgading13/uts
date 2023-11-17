package com.gading.utsnew;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;

    public MovieAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.titleTextView.setText(movie.getTitle());
        holder.synopsisTextView.setText(movie.getSynopsis());
        // Mendapatkan array dari resource drawable
        TypedArray posters = holder.itemView.getResources().obtainTypedArray(R.array.poster);

        // Mendapatkan drawable berdasarkan posisi
        Drawable drawable = posters.getDrawable(position);

        // Set drawable ke ImageView
        holder.imagePoster.setImageDrawable(drawable);

        // Mengembalikan resource array setelah digunakan
        posters.recycle();
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, synopsisTextView;
        ImageView  imagePoster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            synopsisTextView = itemView.findViewById(R.id.synopsisTextView);
            imagePoster = itemView.findViewById(R.id.imagePoster);
        }
    }
}

