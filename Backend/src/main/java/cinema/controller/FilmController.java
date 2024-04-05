package cinema.controller;

import cinema.dto.FilmDto;
import cinema.form.FilmCreateForm;
import cinema.form.FilmFilterForm;
import cinema.form.FilmUpdateForm;
import cinema.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class FilmController {

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping("/api/v1/film")
    @ResponseStatus(HttpStatus.OK)
    public Page<FilmDto> ViewAllFilm(
            FilmFilterForm form,
            Pageable pageable)
    {
        Page<FilmDto> filmDto = filmService.viewFilm(form, pageable);
        return filmDto;
    }


    @PostMapping("/api/v1/film")
    @ResponseStatus(HttpStatus.CREATED)
    public FilmDto createFilm(@RequestBody FilmCreateForm form){
        return filmService.createFilm(form);
    }


    @PutMapping("/api/v1/film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public FilmDto updateFilm(@PathVariable Integer id, @RequestBody FilmUpdateForm form) {
        return filmService.updateFilm(id, form);
    }


    @DeleteMapping("/api/v1/film/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFilm(@PathVariable("id") Integer id){
        filmService.deleteFilm(id);
    }







}



