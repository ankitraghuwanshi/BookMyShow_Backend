package org.scaler.bookmyshow_backend.services;


import org.scaler.bookmyshow_backend.dtos.BookMovieRequestDto;
import org.scaler.bookmyshow_backend.exceptions.ShowNotFoundException;
import org.scaler.bookmyshow_backend.exceptions.ShowSeatNotAvailableException;
import org.scaler.bookmyshow_backend.exceptions.UserNotFoundException;
import org.scaler.bookmyshow_backend.models.*;
import org.scaler.bookmyshow_backend.repositories.BookingRepository;
import org.scaler.bookmyshow_backend.repositories.ShowRepository;
import org.scaler.bookmyshow_backend.repositories.ShowSeatRepository;
import org.scaler.bookmyshow_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository  showSeatRepository;
    private PriceCalculationService priceCalculationService;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculationService priceCalculationService,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculationService = priceCalculationService;
        this.bookingRepository = bookingRepository;
    }

    //public Booking bookMovie(BookMovieRequestDto requestDto){return null;}

    @Transactional(isolation= Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException, ShowSeatNotAvailableException {

        //1.get the user details from the DB
        //2.get the show details from DB
        //3.get the list of show seats from DB
        //4.check if all the seats are AVAILABLE
        //5.------TAKE A LOCK-------
        //6.Double check if the seta are AVAILABLE
        //7.if no, throw the exception
        //8.if yes, mark the seta status as blocked
        //9.------RELEASE THE LOCK-------
        //10.create the booking/ticket object
        //11.proceed to the payment

        //1.get the user details from the DB
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user with id:- " + userId + " doesn't exist");
        }
        User user = optionalUser.get();

        //2.get the show details from DB
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("show with id:- " + showId + " doesn't exist");
        }
        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        //list can be empty but not null
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("show seat not available , please try other seat");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setBookedBy(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeatList(showSeats);
        booking.setBookingDate(new Date());
        booking.setAmount(priceCalculationService.calculatePrice(showSeats));
        //booking.setPayments();

        booking=bookingRepository.save(booking);

        return booking;
    }
}
