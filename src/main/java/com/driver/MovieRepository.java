package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieRepository {
    private HashMap<String, Movie> movieMap = new HashMap<>();
    private HashMap<String, Director> directorMap= new HashMap<>();
    private HashMap<String, List<Movie>> movieDirectorMapping = new HashMap<>();


    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }

    public Movie getMovie(String movieName){
        return movieMap.get(movieName);
    }

    public Director getDirector(String directorName){
        return directorMap.get(directorName);
    }

    public List<Movie> findMovieByDirectorName(String director){
        return movieDirectorMapping.get(director);
    }

    public void createMovieDirectorPair(String movieName, String directorName){
        Movie movie = movieMap.get(movieName);
        List<Movie> moviesByDirector;
        if(movieDirectorMapping.containsKey(directorName)){
            moviesByDirector = movieDirectorMapping.get(directorName);
            moviesByDirector.add(movie);
            movieDirectorMapping.put(directorName,moviesByDirector);
        }
        else{
            moviesByDirector = new ArrayList<>();
            moviesByDirector.add(movie);
            movieDirectorMapping.put(directorName,moviesByDirector);
        }
    }
    public void deleteDirector(String director){
        directorMap.remove(director);
    }

    public void deleteAllDirectors(){
        movieDirectorMapping.clear();
    }

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        for(Map.Entry<String, Movie> entry : movieMap.entrySet()){
            movies.add(entry.getValue());
        }
        return movies;
    }
}
