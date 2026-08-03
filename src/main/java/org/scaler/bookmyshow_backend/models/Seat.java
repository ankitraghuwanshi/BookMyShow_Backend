package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String seatNumber;

    @ManyToOne
    private SeatType seatType;

    private int rowNumber;
    private int columnNumber;
}
/*
 1  --> 1
Seat---SeatType   =>M:1
 M  <--  1
*/