package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class MovieController {

    HashMap<Integer, Movie> map = new HashMap<>();

    @PostMapping("/movie/add-movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PostMapping("/movie/add-director")
    public ResponseEntity<Director> addDirector(@RequestBody Director director){

        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }
}
