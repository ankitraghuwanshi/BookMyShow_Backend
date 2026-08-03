package org.scaler.bookmyshow_backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends BaseModel{
    private String userName;
    private String email;
    private String password;
    private String phone;
    private List<Booking> bookings;
}
