package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{

    @OneToMany
    private List<Seat> seatList;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection    //for list of enum
    private List<Feature> features;
}
/*
  1   --> M
Screen---Seat   =>1:M
   1  <-- 1
*/