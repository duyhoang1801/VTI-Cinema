package cinema.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "theater")
public class Theater {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "theater_name")
    private String name;
}
