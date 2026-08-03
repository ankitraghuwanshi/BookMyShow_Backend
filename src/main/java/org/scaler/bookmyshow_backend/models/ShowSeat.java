package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="show_seats")
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}
/*
   1    --> 1
ShowSeat---Show    =>M:1   (S1A1,S1A2,S1A3... ShowSeat belong to S1 Show)
   M    <-- 1

      1    --> 1
   ShowSeat---Seat   =>M:1
       M   <-- 1
*/