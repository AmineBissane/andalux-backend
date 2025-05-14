package com.example.andalux.backend.controller;

import com.example.andalux.backend.entities.models.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.andalux.backend.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> addreservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return ResponseEntity.ok(createdReservation);
    }

}
