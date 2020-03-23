package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class LoanController {

    @Autowired
    LoanRepository loanRepository;

    @GetMapping("/loans")
    public List<Loan> getAccounts() {
        return loanRepository.findAll();
    }

    @GetMapping("/loans/{id}")
    public Optional<Loan>getAllLoansById(@PathVariable(value = "id") Integer id) {
        return loanRepository.findById(id);
    }

    @PostMapping("/loans")
    public @Valid Loan CreatLoanUser(@Valid @RequestBody Loan loan){
        return loanRepository.save(loan);
    }

    @PutMapping("/loans/{id}")
    public @Valid Loan updateLoan(@PathVariable(value = "id") Integer id, @Valid @RequestBody Loan loan) throws LoanNotFoundException{
       Loan emp = loanRepository.findById(id).orElseThrow(()-> new LoanNotFoundException(id));
        emp.setLoan_id(loan.getLoan_id());
        emp.setLoan_type(loan.getLoan_type());
        emp.setLoan_amount(loan.getLoan_amount());
        emp.setUser_id(loan.getUser_id());
        emp.setAccount_id(loan.getAccount_id());
        emp.setLoan_open_date(loan.getLoan_open_date());
        emp.setLoan_status(loan.getLoan_status());
        emp.setLoan_term(loan.getLoan_term());
        Loan updAccount = loanRepository.save(emp);
        return updAccount;

    }


    @DeleteMapping("/loans/{id}")
    public ResponseEntity<?> deleteLoan(@PathVariable(value = "id") Integer id) throws LoanNotFoundException
    {
       Loan emp1 = loanRepository.findById(id).orElseThrow (() -> new LoanNotFoundException(id));
        loanRepository.delete(emp1);

        return ResponseEntity.ok().build();
    }


}
