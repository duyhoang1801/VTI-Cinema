package cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table
public class Film {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "actor")
    private String actor;

    @Column(name = "director")
    private String director;

    @Column(name = "runtime")
    private Integer runtime;

    @Column(name = "age")
    private Integer age;

    @Column(name = "image")
    private String image;


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
