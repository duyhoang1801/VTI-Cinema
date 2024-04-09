package cinema.dto;

import cinema.entity.FoodType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto {

    private int foodId;

    private String nameFood;

    private FoodType foodType;
}
