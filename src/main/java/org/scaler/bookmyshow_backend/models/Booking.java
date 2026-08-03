package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.*;
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

    @Enumerated(EnumType.ORDINAL) //ordinal means int, String means defined value
    private BookingStatus bookingStatus;

    @OneToMany
    private List<ShowSeat> showSeatList;

    private Date bookingDate;
    private int amount;

    @OneToMany
    private List<Payment> payments;
}
/*
       1   -->  1
    Booking---User     => M:1
       M   <--  1

      1    -->  M
    Booking---ShowSeat   => 1:M
      1    <--  1

       1   -->  M
    Booking---Payment    => 1:M
       1   <--  1
*/