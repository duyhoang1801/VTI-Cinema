package cinema.controller;

import cinema.entity.CinemaRoom;
import cinema.service.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/room")
public class CinemaRoomController {
    @Autowired
    private CinemaRoomService cinemaRoomService;

    @GetMapping("/get-all")
        public List<CinemaRoom> getAll(){
            return cinemaRoomService.getAll();
        }

    @PostMapping("/create")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
        public CinemaRoom create(@RequestBody CinemaRoom cinemaRoom){
            return cinemaRoomService.create(cinemaRoom);
    }

    @PutMapping("/update")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public CinemaRoom update(@RequestBody CinemaRoom cinemaRoom, @PathVariable int id){
        return cinemaRoomService.update(cinemaRoom, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public String delete(@PathVariable int id){
        cinemaRoomService.delete(id);
        return "Đã xóa thành công";
    }
}
