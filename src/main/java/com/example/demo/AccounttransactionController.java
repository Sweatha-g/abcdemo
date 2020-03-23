package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class AccounttransactionController {

    @Autowired
   AccounttransactionRepository accounttransactionRepository;

    @GetMapping("/accountstransaction")
    public List<Accounttransaction> getAccountTransaction() {
        return accounttransactionRepository.findAll();

    }

    @PostMapping("/accountstransaction")
    public @Valid Accounttransaction createAccountTransaction(@Valid @RequestBody Accounttransaction acct) {
        //double ab = 10000;
       // Accounttransaction act1 = new Accounttransaction();
      //  act1.setAccount_balance(ab);

        return accounttransactionRepository.save(acct);
    }


    @GetMapping("/accountstransaction/{id}")
    public Optional<Accounttransaction> getAllAccountTransaction(@PathVariable(value = "id") Integer id) {
        return accounttransactionRepository.findById(id);
    }

    @PutMapping("/accountstransaction/{id}")
    public @Valid Accounttransaction updateAccountTransaction(@PathVariable(value = "id") Integer id, @Valid @RequestBody Accounttransaction acct) throws AccounttransactionNotFoundException{
        Accounttransaction emp = accounttransactionRepository.findById(id).orElseThrow(()-> new AccounttransactionNotFoundException(id));

        //emp.setAccount_balance( acct.actblnc(acct.getAccount_balance(), acct.getTransaction_type(),acct.getTransaction_amount()));
        emp.setAccount_id(acct.getAccount_id());
        emp.setTransaction_no(acct.getTransaction_no());
        emp.setTransaction_date(acct.getTransaction_date());
        emp.setTransaction_amount(acct.getTransaction_amount());
        emp.setTransaction_type(acct.getTransaction_type());
        emp.setLoan_id(acct.getLoan_id());
        emp.setPayee_id(acct.getPayee_id());
        emp.setAccount_balance(acct.getAccount_balance());
        Accounttransaction updAccounttransaction = accounttransactionRepository.save(emp);
        return updAccounttransaction;

    }


    @DeleteMapping("/accountstransaction/{id}")
    public ResponseEntity<?> deleteAccountTransaction(@PathVariable(value = "id") Integer id) throws AccounttransactionNotFoundException
    {
        Accounttransaction emp1 = accounttransactionRepository.findById(id).orElseThrow (() -> new AccounttransactionNotFoundException(id));
        accounttransactionRepository.delete(emp1);

        return ResponseEntity.ok().build();
    }



}
