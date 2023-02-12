package com.example.TicketGuru.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PostalCode {

    @Id
    // Otin tästä autogenin pois, että voidaa ite asettaa postikoodi / PK
    // Ja joutu muuttaa tyypin Stringiks, kokonaislukuna 00100 tulostu ja tallentu kantaan lukuna 64 :D
    // https://stackoverflow.com/a/7218803
    @Column(name = "postal_id", nullable = false, updatable = false)
    private String postalCode;

    @Column(name = "city")
    private String city;
    
    public PostalCode() { }

    public PostalCode(String postalCode, String city) {
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
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
