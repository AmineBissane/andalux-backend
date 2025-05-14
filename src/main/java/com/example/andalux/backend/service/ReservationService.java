package com.example.andalux.backend.service;

import com.example.andalux.backend.entities.models.Reservation;
import com.example.andalux.backend.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepo reservationRepo;

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepo.findById(id).orElse(null);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
    public Reservation updateReservation(Long id, Reservation reservation) {
        if (reservationRepo.existsById(id)) {
            reservation.setId(id);
            return reservationRepo.save(reservation);
        }
        return null;
    }

    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }

}
