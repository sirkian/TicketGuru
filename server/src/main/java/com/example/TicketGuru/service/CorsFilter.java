package com.example.TicketGuru.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // Listataan kaikki sallitut URLit
        List<String> originList = new ArrayList<>();
        originList.add("http://localhost:3000");
        originList.add("https://qo7-qo7fof.azurewebsites.net");
        originList.add("https://sirkian.github.io/ticketguru-client/");

        // Otetaan pyynnössä tullut origin header
        String origin = request.getHeader("Origin");
        // Jos origin != null ja origin on sallittujen listalla
        // lisätään url Access-Control-Allow-Origin headeriin
        if (origin != null && originList.contains(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        response.setHeader("Access-Control-Max-Age", "3600");
        // Jos pyynnön metodi on joku muu kuin OPTIONS =>
        if (!request.getMethod().equals("OPTIONS")) {
            chain.doFilter(req, res);
        } else {
            return;
        }
    }
}
