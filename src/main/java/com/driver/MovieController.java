package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {

    HashMap<String, Movie> movieMap = new HashMap<>();
    HashMap<String, Director> directorMap= new HashMap<>();


    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){

        movieMap.put(movie.getName(), movie);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){

        directorMap.put(director.getName(), director);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){

        Movie movie = movieMap.get(movieName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName){

        Director director = directorMap.get(directorName);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> allMovies = new ArrayList<>();
        for(Map.Entry<String,Movie> entry:movieMap.entrySet()){
            allMovies.add(entry.getValue());
        }
        return new ResponseEntity<>(allMovies,HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable("name") String directorName){
        directorMap.remove(directorName);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

}
