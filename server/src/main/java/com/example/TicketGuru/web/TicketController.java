package com.example.TicketGuru.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TicketController {
    
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/checkticket")
    public String returnPage(){

        return "index.html";
    }

}
