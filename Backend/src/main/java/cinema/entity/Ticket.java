package cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToMany
    @JoinTable(
            name = "food_ticket",
            joinColumns = @JoinColumn(name = "ticket_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "food_id", nullable = false)
    )
    private List<Food> foods;




}
