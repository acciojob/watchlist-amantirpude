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
    private HashMap<String, List<String>> movieDirectorMapping = new HashMap<>();


    public void addMovie(Movie movie){
        movieMap.put(movie.getMovieName(),movie);
    }

    public void addDirector(Director director){
        directorMap.put(director.getDirectorName(), director);
    }

    public Movie getMovie(String movieName){
        return movieMap.get(movieName);
    }

    public Director getDirector(String directorName){
        return directorMap.get(directorName);
    }

    public List<String> findMovieByDirectorName(String director){
        List<String> movieListByDirector = movieDirectorMapping.get(director);
        return movieListByDirector;
    }

    public void createMovieDirectorPair(String movieName, String directorName){
        List<String> moviesByDirector;
        if(movieDirectorMapping.isEmpty()){
             moviesByDirector = new ArrayList<>();
            moviesByDirector.add(movieName);
            movieDirectorMapping.put(directorName,moviesByDirector);
        }
        else{
            moviesByDirector = movieDirectorMapping.get(directorName);
            moviesByDirector.add(movieName);
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
