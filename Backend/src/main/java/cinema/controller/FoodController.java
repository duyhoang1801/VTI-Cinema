package cinema.controller;

import cinema.dto.FoodCreateRequest;
import cinema.dto.FoodSearchRequest;
import cinema.dto.FoodUpdateRequest;
import cinema.entity.Food;
import cinema.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
@CrossOrigin("*")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/get-all")
    public List<Food> getAll() {
        return foodService.getAll();
    }

    @PostMapping("/create")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public Food create(@RequestBody FoodCreateRequest request) {
        return foodService.create(request);
    }

    @GetMapping("/{id}")
    public Food getById(@PathVariable int id) {
        return foodService.getById(id);
    }


    @GetMapping("/ticket/{id}")
    public List<Food> findAllByTicketsId(@PathVariable Integer id) {
        return foodService.findByTicketsId(id);
    }


    @PutMapping("/update")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public Food update(@RequestBody FoodUpdateRequest request) {
        return foodService.update(request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    public String delete(@PathVariable int id) {
        foodService.delete(id);
        return "Đã xóa thành công!";
    }

    @PostMapping("/search")
    public Page<Food> search(@RequestBody FoodSearchRequest request) {
        return foodService.search(request);
    }

//    @GetMapping("find-by-food-type")
//    public List<Food> findByFoodType(@RequestParam int foodTypeId) {
//        return foodService.findByFoodType(foodTypeId);
//    }
}
