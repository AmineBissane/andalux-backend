package com.example.andalux.backend.entities.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String passport;
    private String pickupAddress;
    private String destinationAddress;
    private String email;
    private String phone;
    private LocalDate pickupDate;
    private LocalTime pickupTime;
    private int numberOfAdults;
    private int numberOfChildren;
    private String specialRequests;
    private double price;


}
