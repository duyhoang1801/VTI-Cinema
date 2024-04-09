package cinema.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "`Account")
public class Account {
    @Id
    @Column(name ="id_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @Column(name = "ho_ten", length = 50, nullable = false, unique = true)
    private String fullName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "mat_khau", nullable = false)
    private String password;

    @Column(name = "gioi_tinh")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "ngay_sinh")
    private Date dateOfBirth;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

}
