package cinema.service;

import cinema.dto.FilmDto;
import cinema.repository.FilmRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    private ModelMapper modelMapper;

    @Autowired
    public FilmServiceImpl(
            FilmRepository postRepository,
            ModelMapper modelMapper
    ) {
        this.filmRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Page<FilmDto> viewFilm() {
        return null;
    }

    @Override
    public FilmDto createFilm() {
        return null;
    }

    @Override
    public void updateFilm() {

    }

    @Override
    public void deleteFilm() {

    }

}
