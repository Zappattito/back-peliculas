package com.intermodular.peliculas.controllers;

import com.intermodular.peliculas.models.Pelicula;
import com.intermodular.peliculas.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaRepository repository;

    @GetMapping
    public List<Pelicula> getPeliculas() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> getPeliculaById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Pelicula addPelicula(@RequestBody Pelicula pelicula) {
        return repository.save(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        return repository.save(pelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
