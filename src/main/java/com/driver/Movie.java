package com.driver;

public class Movie {
    private String movieName;
    private int durationInMinutes;
    private double imdbRating;

    public Movie() {
    }

    public Movie(String movieName, int durationInMinutes, double imdbRating) {
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }



    public String getName() {
        return movieName;
    }

    public void setName(String name) {
        this.movieName = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
