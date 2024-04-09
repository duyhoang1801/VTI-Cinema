package cinema.controller;

import cinema.dto.LoginDto;
import cinema.dto.LoginRequest;
import cinema.entity.Account;
import cinema.exception.AppException;
import cinema.exception.ErrorResponseEnum;
import cinema.repository.AccountRepository;
import cinema.utils.JWTTokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;

    /**
     * Hàm login: Cần set authenticated() cho api này
     * @param principal: Đối tượng được sinh ra khi đã xác thực được người dùng
     * @return
     */
    @GetMapping("/login-basic-v1")
    public LoginDto loginV1(Principal principal){
        String phoneNumber = principal.getName();
        // Tìm ra được đối tượng Account từ phonenumber
        Optional<Account> accountOptional = accountRepository.findByPhoneNumber(phoneNumber);
        if (accountOptional.isEmpty()) {
            throw new AppException(ErrorResponseEnum.ACCOUNT_NOT_FOUND);
        }
        Account account = accountOptional.get();
        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(account, loginDto);
        return loginDto;
    }

    /**
     * Hàm login: Cách này cần permitAll() với api này để xử lý dữ liệu
     * @param phoneNumber
     * @param password
     * @return
     */
    @GetMapping("/login-basic-v2")
    public LoginDto loginV2(@RequestParam String phoneNumber, @RequestParam String password) {
        Optional<Account> accountOptional = accountRepository.findByPhoneNumber(phoneNumber);
        if (accountOptional.isEmpty()) {
            throw new AppException(ErrorResponseEnum.PHONENUMBER_NOT_EXISTED);
        }
        Account account = accountOptional.get();
        boolean checkPassword = passwordEncoder.matches(password, account.getPassword());
        if (!checkPassword) {
            throw new AppException(ErrorResponseEnum.WRONG_PASSWORD);
        }
        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(account, loginDto);
        return loginDto;
    }

    /**
     * Hàm login JWT: Cách này cần permitAll() với api này để xử lý dữ liệu
     * @param request: Đối tượng gồm phonenumber và password
     * @return
     */
    @PostMapping("/login-jwt")
    public LoginDto loginJWT(@RequestBody LoginRequest request) {
        Optional<Account> accountOptional = accountRepository.findByPhoneNumber(request.getPhoneNumber());
        if (accountOptional.isEmpty()) {
            throw new AppException(ErrorResponseEnum.PHONENUMBER_NOT_EXISTED);
        }
        Account account = accountOptional.get();
        boolean checkPassword = passwordEncoder.matches(request.getPassword(), account.getPassword());
        if (!checkPassword) {
            throw new AppException(ErrorResponseEnum.WRONG_PASSWORD);
        }
        // Login
        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(account, loginDto);
        loginDto.setUserAgent(httpServletRequest.getHeader("User-Agent"));
        String token = jwtTokenUtils.createAccessToken(loginDto);
        loginDto.setToken(token);
        return loginDto;
    }

}
