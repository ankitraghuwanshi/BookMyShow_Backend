package org.scaler.bookmyshow_backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    private User bookedBy;
    private BookingStatus bookingStatus;
    private List<ShowSeat> showSeatList;
    private Date bookingDate;
    private int amount;
    private List<Payment> payments;
}
