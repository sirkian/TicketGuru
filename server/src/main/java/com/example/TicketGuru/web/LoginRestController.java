package com.example.TicketGuru.web;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import com.example.TicketGuru.domain.LoginRequest;

@RestController
public class LoginRestController {

    @Autowired
    private AppUserRepository userRepository;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws IOException {

        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        AppUser user = userRepository.findByEmail(email);
        boolean pwdMatch = BCrypt.checkpw(password, user.getPassword());
        if (pwdMatch) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
