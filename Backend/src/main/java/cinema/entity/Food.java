package cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "do_an")
public class Food {
    @Id
    @Column(name = "id_do_an")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodId;

    @Column(name = "ten_do_an")
    private String nameFood;

    @ManyToOne
    @JoinColumn(name = "id_the_loai_do_an")
    private FoodType foodType;
}
