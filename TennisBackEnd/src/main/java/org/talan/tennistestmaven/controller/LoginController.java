package org.talan.tennistestmaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.talan.tennistestmaven.model.data.Login;
import org.talan.tennistestmaven.repo.LoginRepo;


import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginRepo loginRepo;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        Optional<Login> user = loginRepo.findByUsername(login.getUsername());

        if (user.isPresent()) {
            Login foundUser = user.get();
            boolean passwordMatches = passwordEncoder.matches(login.getPassword(), foundUser.getPassword());

            if (passwordMatches) {
                return ResponseEntity.ok("Login successful, role: " + foundUser.getRole());
            } else {
                return ResponseEntity.status(401).body("Invalid username or password");
            }
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}