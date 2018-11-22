package rest;

public class GameNotFoundException extends RuntimeException{

    GameNotFoundException(Long id){
        super("Could not find game : " + id);
    }
}
