package cinema.dto;

import cinema.entity.Gender;
import cinema.entity.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
public class AccountUpdateRequest extends BaseRequest{
    @NotNull(message = "Id không được để trống")
    @Positive(message = "Id phải lớn hơn 0")
    private int id;

    private Role role;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Length(max = 50, message = "Mật khẩu không được quá 50 ký tự")
    private String password;

    @Length(max = 50, message = "Tên không được quá 50 ký tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Length(max = 50, message = "Email không được quá 50 ký tự")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Length(max = 50, message = "Số điện thoại không được quá 50 ký tự")
    private String phoneNumber;

    private String avatar;

    private Date dateOfBirth;

    private Gender gender;

}
