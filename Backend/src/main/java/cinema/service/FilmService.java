package cinema.service;

import cinema.dto.FilmDto;
import org.springframework.data.domain.Page;

public interface FilmService {

    public Page<FilmDto> viewFilm();

    public FilmDto createFilm();

    public void updateFilm();

    public void deleteFilm();
}
