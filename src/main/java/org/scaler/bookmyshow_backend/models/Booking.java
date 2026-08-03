package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{

    @ManyToOne
    private User bookedBy;

    private BookingStatus bookingStatus;

    @OneToMany
    private List<ShowSeat> showSeatList;

    private Date bookingDate;
    private int amount;

    @OneToMany
    private List<Payment> payments;
}
