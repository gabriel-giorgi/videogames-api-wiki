package rest;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    private final GameRepository repository;

    GameController(GameRepository repository){
        this.repository = repository;
    }

    //For all item
    @GetMapping("/games")
    List<Game> all(){
        return repository.findAll();
    }

    @GetMapping("/games/{id}")
    Game one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
    }

    @PostMapping("/games")
    Game newGame(@RequestBody Game newGame){
        return repository.save(newGame);
    }

    @PutMapping("/games/{id}")
    Game replaceGame(@RequestBody Game newGame , @PathVariable Long id){
        return repository.findById(id).map(game -> {
            game.setName(newGame.getName());
            game.setReleasedDate(newGame.getReleasedDate());
            return repository.save(game);
        })
                .orElseGet(() ->{
            newGame.setId(id);
            return repository.save(newGame);
        });
    }

    @DeleteMapping("/games/{id}")
    void deleteGame(@PathVariable Long id){
        repository.deleteById(id);
    }

}
