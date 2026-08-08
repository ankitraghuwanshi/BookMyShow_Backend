package org.scaler.bookmyshow_backend.controllers;

import org.scaler.bookmyshow_backend.dtos.BookMovieRequestDto;
import org.scaler.bookmyshow_backend.dtos.BookMovieResponseDto;
import org.scaler.bookmyshow_backend.dtos.ResponseStatus;
import org.scaler.bookmyshow_backend.exceptions.ShowNotFoundException;
import org.scaler.bookmyshow_backend.exceptions.ShowSeatNotAvailableException;
import org.scaler.bookmyshow_backend.exceptions.UserNotFoundException;
import org.scaler.bookmyshow_backend.models.Booking;
import org.scaler.bookmyshow_backend.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto){
        BookMovieResponseDto responseDto = new BookMovieResponseDto();

        try{
            Booking booking=bookingService.bookMovie(
                    requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds()
            );

            responseDto.setBooking(booking);
            responseDto.setStatus(ResponseStatus.SUCCESS);

            return responseDto;
        }catch (ShowNotFoundException e){
            //throw new ShowNotFoundException("show not found exception");
            e.printStackTrace();
        }catch(ShowSeatNotAvailableException e){
            //throw new ShowSeatNotAvailableException("");
            e.printStackTrace();
        }catch(UserNotFoundException e){
            //throw new UserNotFoundException("");
            e.printStackTrace();
        } catch(Exception e){ //should always at last
            e.printStackTrace();
        }

        responseDto.setStatus(ResponseStatus.FAILURE);
        return responseDto;
    }
}
