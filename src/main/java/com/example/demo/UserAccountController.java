package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class UserAccountController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @GetMapping("/ua")
    public List<UserAccount> getUserAccount() {
        return userAccountRepository.findAll();
    }
    @PostMapping("/ua")
    public @Valid UserAccount creatUserAccount(@Valid @RequestBody UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }


}