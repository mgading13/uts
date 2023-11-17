package com.gading.utsnew;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Ambil data dari strings.xml
        String[] movieTitles = getResources().getStringArray(R.array.movie_titles);
        String[] movieSynopses = getResources().getStringArray(R.array.movie_synopsis);

        // Inisialisasi daftar film
        List<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < movieTitles.length; i++) {
            movieList.add(new Movie(movieTitles[i], movieSynopses[i]));
        }

        // Inisialisasi dan atur adapter
        movieAdapter = new MovieAdapter(movieList);
        recyclerView.setAdapter(movieAdapter);

        return view;
    }
}