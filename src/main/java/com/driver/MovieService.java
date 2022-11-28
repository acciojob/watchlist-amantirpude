package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieService {

    @Autowired
    MovieRepository movieRepo;
    public void addMovie(Movie movie){
        movieRepo.addMovie(movie);
    }

    public void addDirector(Director director){
        movieRepo.addDirector(director);
    }

    public Movie getMovie(String movieName){
        return movieRepo.getMovie(movieName);
    }

    public Director getDirector(String directorName){
        return movieRepo.getDirector(directorName);
    }
    public List<String> findMovieByDirectorName(String director){
        return movieRepo.findMovieByDirectorName(director);
    }

    public void createMovieDirectorPair(String movie, String director){
        movieRepo.createMovieDirectorPair(movie,director);
    }
    public void deleteDirector(String director){
        movieRepo.deleteDirector(director);
    }
    public void deleteAllDirectors(){
        movieRepo.deleteAllDirectors();
    }

    public List<Movie> getAllMovies(){
        return movieRepo.getAllMovies();
    }
}
