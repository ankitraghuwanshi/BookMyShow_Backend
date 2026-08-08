package org.scaler.bookmyshow_backend.dtos;

import lombok.Getter;
import lombok.Setter;
import org.scaler.bookmyshow_backend.models.Booking;

@Getter
@Setter
public class BookMovieResponseDto {
    private Booking booking;
    private ResponseStatus status;
}
