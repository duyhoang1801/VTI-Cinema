package cinema.controller;

import cinema.dto.AccountCreateRequest;
import cinema.dto.AccountSearchRequest;
import cinema.dto.AccountUpdateRequest;
import cinema.entity.Account;
import cinema.repository.AccountRepository;
import cinema.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin("*")
@Validated
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/get-all")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @PostMapping("/create")
    public Account create(@RequestBody @Valid AccountCreateRequest request){
        return accountService.create(request);
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return accountService.getById(id);
    }

    @PutMapping("/update")
    public Account update(@RequestBody @Valid AccountUpdateRequest request){
        return accountService.update(request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public String delete(@PathVariable int id) {
        accountService.delete(id);
        return "Đã xóa thành công";
    }

    @PostMapping("/search")
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    public Page<Account> search(@RequestBody AccountSearchRequest request) {
        return accountService.search(request);
    }
}
