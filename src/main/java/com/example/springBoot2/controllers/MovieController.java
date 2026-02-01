package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("")
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getItem(@PathVariable int id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Movie addItem(@RequestBody Movie album) {
        return movieRepository.save(album);
    }

    @PutMapping("/{id}")
    public Movie updateItem(@PathVariable int id, @RequestBody Movie album) {
        album.setId(id);
        return movieRepository.save(album);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}
