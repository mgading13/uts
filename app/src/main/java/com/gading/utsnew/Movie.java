package com.gading.utsnew;

public class Movie {
    private String title;
    private String synopsis;

    public Movie(String title, String synopsis) {
        this.title = title;
        this.synopsis = synopsis;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }
}