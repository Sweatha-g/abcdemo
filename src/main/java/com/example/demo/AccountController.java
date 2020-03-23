package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class AccountController{


    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountRepository.findAll();

    }

    @PostMapping("/accounts")
    public @Valid Account creatAccount(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }


    @GetMapping("/accounts/{id}")
    public Optional<Account> getAllAccountsById(@PathVariable(value = "id") Integer id) {
        return accountRepository.findById(id);
    }

    @PutMapping("/accounts/{id}")
    public @Valid Account updateAccount(@PathVariable(value = "id") Integer id, @Valid @RequestBody Account account) throws AccountNotFoundException{
        Account emp = accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException(id));
        emp.setAccount_name(account.getAccount_name());
        emp.setAccount_address(account.getAccount_address());
        emp.setAccount_status(account.getAccount_status());
        emp.setEmail_id(account.getEmail_id());
        emp.setMobile_number(account.getMobile_number());
        emp.setAccount_type(account.getAccount_type());
        emp.setDate_closed(account.getDate_closed());
        emp.setDate_open(account.getDate_open());
        Account updAccount = accountRepository.save(emp);
        return updAccount;

    }


    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Integer id) throws AccountNotFoundException
    {
        Account emp1 = accountRepository.findById(id).orElseThrow (() -> new AccountNotFoundException(id));
        accountRepository.delete(emp1);

        return ResponseEntity.ok().build();
    }




}
