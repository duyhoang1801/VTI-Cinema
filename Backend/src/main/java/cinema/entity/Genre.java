package cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table
public class Genre {

    @Id
    @Column(name = "id")
    private Integer id;


    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "genres")
    private List<Film> films;
}
