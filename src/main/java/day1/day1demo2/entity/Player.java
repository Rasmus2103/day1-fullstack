package day1.day1demo2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Sætter automatisk gætter getter og setter til ens attributer
@Getter
@Setter

//Sætter en default constructor
@NoArgsConstructor
//------------------------
@Entity
@Table(name="spiller")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_name", length = 70, nullable = false)
    int id;
    private String name;
    String country;
    String position;

    public Player(String name, String country, String position) {
        this.name = name;
        this.country = country;
        this.position = position;
    }
}
