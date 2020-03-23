package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class BillPayeeController {


   @Autowired
   BillPayeeRepository billpayeeRepository;

    @GetMapping("/billpayees")
    public List<BillPayee> getAllBillPayees() {
        return billpayeeRepository.findAll();
    }

    @GetMapping("/billpayees/{id}")
    public Optional<BillPayee> getAllBillPayeesById(@PathVariable(value = "id") Integer id) {
        return billpayeeRepository.findById(id);
    }

    @PostMapping("/billpayees")
    public @Valid BillPayee CreatBillPayee(@Valid @RequestBody BillPayee billpayee) {
        return billpayeeRepository.save(billpayee);

    }


    @PutMapping("/billpayees/{id}")
    public @Valid BillPayee updateBillPayee(@PathVariable(value = "id") Integer id, @Valid @RequestBody BillPayee billpayee) throws BillPayeeNotFoundException {
        BillPayee emp = billpayeeRepository.findById(id).orElseThrow(()-> new BillPayeeNotFoundException(id));
        emp.setPayee_id(billpayee.getPayee_id());
        emp.setUser_id(billpayee.getUser_id());
        emp.setPayee_account_no(billpayee.getPayee_account_no());
        emp.setPayee_phone(billpayee.getPayee_phone());
        emp.setPayee_address(billpayee.getPayee_address());
        BillPayee updBillPayee = billpayeeRepository.save(emp);

        return updBillPayee;
    }

    @DeleteMapping("/billpayees/{id}")
    public ResponseEntity<?> deleteBillPayee(@PathVariable(value = "id") Integer id) throws BillPayeeNotFoundException
    {
        BillPayee emp1 = billpayeeRepository.findById(id).orElseThrow (() -> new BillPayeeNotFoundException(id));
        billpayeeRepository.delete(emp1);

        return ResponseEntity.ok().build();
    }
    
    
    
    
    
    
    
    
    
    
}
