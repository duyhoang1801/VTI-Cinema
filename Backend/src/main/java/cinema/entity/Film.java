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


    @ManyToMany
    @JoinTable(
            name = "movie_country",
            joinColumns = @JoinColumn(name = "movie_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "country_id", nullable = false)
    )
    private List<Country> countries;


    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "genre_id", nullable = false)
    )
    private List<Genre> genres;

}
