package org.scaler.bookmyshow_backend.controllers;

import org.scaler.bookmyshow_backend.dtos.BookMovieRequestDto;
import org.scaler.bookmyshow_backend.dtos.BookMovieResponseDto;
import org.scaler.bookmyshow_backend.models.Booking;
import org.scaler.bookmyshow_backend.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto){return null;}
}
