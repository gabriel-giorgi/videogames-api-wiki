package rest;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Game {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private Date releasedDate;

    public Game(String name , Date releasedDate){
        this.name = name;
        this.releasedDate = releasedDate;
    }

    public Game(){ }
}
