package com.example.TicketGuru.web;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TicketGuru.domain.AppUser;
import com.example.TicketGuru.domain.AppUserRepository;
import com.example.TicketGuru.domain.LoginRequest;
import com.example.TicketGuru.domain.LoginResponse;
import com.example.TicketGuru.service.DetailsService;

@RestController
public class LoginRestController {

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private AppUserRepository userRepository;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    @PostMapping("/appusers/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws IOException {
        // LoginRequest on frontista tulevat lomaketiedot
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        // Ladataan DetailsService-luokasta User frontista tulleella spostilla
        UserDetails user = detailsService.loadUserByUsername(email);
        AppUser appUser = userRepository.findByEmail(email);
        Long id = appUser.getUserId();
        // Tarkastetaan että käyttäjän antama salasana täsmää tallennettuun
        boolean pwdMatch = BCrypt.checkpw(password, user.getPassword());
        if (pwdMatch) {
            // Jos true, luodaan basic auth token, joka voidaan frontissa lähettää
            // fetch-pyyntöjen mukana
            String token = "Basic " + Base64.getEncoder().encodeToString((email + ":" + password).getBytes());
            // Luodaan LoginResponse-olio tokenilla, spostilla ja käyttäjän rooleilla
            LoginResponse res = new LoginResponse(id, token, email, user.getAuthorities());
            return ResponseEntity.ok(res);
        }
        // Jos salasanat ei täsmää, palautetaan 400
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
