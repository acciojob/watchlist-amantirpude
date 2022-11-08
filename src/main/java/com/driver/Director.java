package com.driver;

public class Director {

    private String directorName;
    private int numberOfMovies;
    private double imdbRating;

    public Director() {
    }

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.directorName = directorName;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return directorName;
    }

    public void setName(String name) {
        this.directorName = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
