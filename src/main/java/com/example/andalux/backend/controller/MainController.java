package com.example.andalux.backend.controller;

import com.example.andalux.backend.entities.models.Reservation;
import com.example.andalux.backend.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final ReservationService reservationService;

    @GetMapping("/")
    public String index() {
        return "redirect:/reservations";
    }

    @GetMapping("/reservations")
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        System.out.println("Fetched reservations: " + reservations); // DEBUG
        model.addAttribute("reservations", reservations);
        return "index";
    }

    @GetMapping("/reservations/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return "redirect:/reservations";
        }
        model.addAttribute("reservation", reservation);
        return "edit";
    }


    @PostMapping("/reservations/update/{id}")
    public String updateReservation(@PathVariable Long id, @ModelAttribute Reservation reservation) {
        reservationService.updateReservation(id, reservation); // Call service to update reservation
        return "redirect:/reservations"; // Redirect back to reservation list
    }


    @GetMapping("/reservations/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations";
    }

    // View details of a specific reservation
    @GetMapping("/reservations/details/{id}")
    public String viewReservationDetails(@PathVariable("id") Long id, Model model) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return "redirect:/reservations"; // Redirect if reservation not found
        }
        model.addAttribute("reservation", reservation);
        return "reservation-details"; // Use templates/reservation-details.html for the details view
    }
}
