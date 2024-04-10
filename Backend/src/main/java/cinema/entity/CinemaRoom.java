package cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "phong_chieu_phim")
public class CinemaRoom {
    @Id
    @Column(name = "id_phong_chieu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaRoomId;

    @Column(name = "so_phong")
    private int numberOfRoom;

    @Column(name = "trang_thai")
    private boolean status;
}
