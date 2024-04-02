package cinema.dto;

import cinema.entity.Country;
import cinema.entity.Genre;

import java.time.LocalDate;
import java.util.List;

public class FilmDto {

    private String name;

    private String description;

    private LocalDate releaseDate;

    private String actor;

    private String director;

    private Integer runtime;

    private Integer age;

    private String image;

    private List<Country> countries;

    private List<Genre> genres;


}
