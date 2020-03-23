package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class UserRegistrationController {

        @Autowired
        UserDetailsRepository userRepository;

        @GetMapping("/users")
        public List<User> getRegistration() {
            return userRepository.findAll();

        }

        @PostMapping("/users")
        public @Valid User creatUser(@Valid @RequestBody User user) {
            return userRepository.save(user);
        }


        @GetMapping("/users/{id}")
        public Optional<User> getAllUsers(@PathVariable(value = "id") Integer id) {
        return userRepository.findById(id);
        }

       @PutMapping("/users/{id}")
       public @Valid User updateUser(@PathVariable(value = "id") Integer id, @Valid @RequestBody User user) throws UserDetailsNotFoundException{
        User emp = userRepository.findById(id).orElseThrow(()-> new UserDetailsNotFoundException(id));
        emp.setFirst_name(user.getFirst_name());
        emp.setLast_name(user.getLast_name());
        emp.setMiddle_name(user.getMiddle_name());
        emp.setEmail(user.getEmail());
        emp.setMobile_number(user.getMobile_number());
        emp.setAddress(user.getAddress());
        emp.setPassword(user.getPassword());
        User updUser = userRepository.save(emp);
        return updUser;

      }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer id) throws UserDetailsNotFoundException
    {
        User emp1 = userRepository.findById(id).orElseThrow (() -> new UserDetailsNotFoundException(id));
        userRepository.delete(emp1);

        return ResponseEntity.ok().build();
    }


    }




