package cinema.repository;

import cinema.entity.Account;
import cinema.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>, JpaSpecificationExecutor<Food> {
    List<Food> findAllByFoodType_Id(int foodTypeId);

    //Tham khảo link sau: https://stackoverflow.com/questions/33438483/spring-data-jpa-query-manytomany
    List<Food> findAllByTicketsId(Integer ticketId);
}
