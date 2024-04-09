package cinema.controller;

import cinema.dto.FilmDto;
import cinema.dto.TheaterDto;
import cinema.form.*;
import cinema.service.FilmService;
import cinema.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TheaterController {
    private TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }


    @GetMapping("/api/v1/theater")
    @ResponseStatus(HttpStatus.OK)
    public Page<TheaterDto> viewTheater(
            TheaterFilterForm form,
            Pageable pageable)
    {
        Page<TheaterDto> theaterDto = theaterService.viewTheater(form, pageable);
        return theaterDto;
    }


    @PostMapping("/api/v1/theater")
    @ResponseStatus(HttpStatus.CREATED)
    public TheaterDto createTheater(@RequestBody TheaterCreaterForm form) {
        return theaterService.createTheater(form);
    }


    @PutMapping("/api/v1/theater/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TheaterDto updateTheater(
            @PathVariable("id") Integer id,
            @RequestBody TheaterUpdateForm form
    ){
        return theaterService.updateTheater(id, form);
    }


    @DeleteMapping("/api/v1/theater/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTheater(@PathVariable("id") Integer id){
        theaterService.deleteTheater(id);
    }
}
