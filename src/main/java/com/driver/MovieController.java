package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
        movieService.createMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){

        Movie movie = movieService.getMovie(movieName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName){

        Director director = movieService.getDirector(directorName);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{name}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("name") String directorName){
        List<String> moviesByDirector = movieService.findMovieByDirectorName(directorName);
        return new ResponseEntity<>(moviesByDirector, HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name/{name}")
    public ResponseEntity<String> deleteDirectorByName(@PathVariable("name") String directorName){
        movieService.deleteDirector(directorName);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

}
