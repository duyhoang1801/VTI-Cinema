package cinema.service;

import cinema.dto.FilmDto;
import cinema.entity.Film;
import cinema.form.FilmCreateForm;
import cinema.form.FilmFilterForm;
import cinema.form.FilmUpdateForm;
import cinema.repository.FilmRepository;
import cinema.specification.FilmSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    private ModelMapper modelMapper;

    @Autowired
    public FilmServiceImpl(
            FilmRepository filmRepository,
            ModelMapper modelMapper
    ) {
        this.filmRepository = filmRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Page<FilmDto> viewFilm(FilmFilterForm form, Pageable pageable) {

        Specification<Film> filmSpec = FilmSpecification.buildSpec(form);
        Page<Film> films = filmRepository.findAll(filmSpec, pageable);
        Page<FilmDto> filmsDto = films.map(film -> modelMapper.map(film, FilmDto.class));

        return filmsDto;


//        Specification<Post> spec = PostSpecification.buildSpec(form); //--> buildSpec là Method static nên có thể được gọi trực tiếp từ Class

//        return postRepository.findAll(spec, pageable)
//                .map(post -> modelMapper.map(post, PostDto.class).withSelfRel());
    }


    @Override
    public FilmDto findById(Integer id) {
        FilmDto film = filmRepository.findById(id)
                .map(post -> modelMapper.map(post, FilmDto.class))
                .orElse(null);
        return film;
    }




    @Override
    public FilmDto createFilm(FilmCreateForm form) {

        Film film = modelMapper.map(form, Film.class);
        Film savedFilm = filmRepository.save(film);
        return modelMapper.map(savedFilm, FilmDto.class);

    }



    @Override
    public FilmDto updateFilm(Integer id, FilmUpdateForm form) {
        Film film = filmRepository.findById(id)
                .orElse(null);
        modelMapper.map(form, film);
        Film savedFilm = filmRepository.save(film);
        return modelMapper.map(savedFilm, FilmDto.class);
    }




    @Override
    public void deleteFilm(Integer id) {
        filmRepository.deleteById(id);

    }

}
