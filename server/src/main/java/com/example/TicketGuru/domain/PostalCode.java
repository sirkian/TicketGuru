package com.example.TicketGuru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postal_id", nullable = false, updatable = false)
    private Long postalCode;

    @Column(name = "city")
    private String city;

    public PostalCode(Long postalCode, String city) {
        this.postalCode = postalCode;
        this.city = city;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PostalCode{" +
                "postalCode=" + postalCode +
                ", city='" + city + '\'' +
                '}';
    }
}
