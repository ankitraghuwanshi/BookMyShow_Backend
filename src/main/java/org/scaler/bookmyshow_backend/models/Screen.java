package org.scaler.bookmyshow_backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen extends BaseModel{
    //private String screenName;
    private List<Seat> seatList;
    private List<Feature> featureList;
}
