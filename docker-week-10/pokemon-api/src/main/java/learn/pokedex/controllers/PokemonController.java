package learn.pokedex.controllers;

import learn.pokedex.data.PokemonRepository;
import learn.pokedex.models.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonRepository repository;

    public PokemonController(PokemonRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Pokemon> get() {
        return repository.findAll();
    }
}
