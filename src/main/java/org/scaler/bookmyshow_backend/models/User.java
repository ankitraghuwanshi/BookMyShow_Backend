package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="users")
public class User extends BaseModel{
    private String userName;
    private String email;
    private String password;
    private String phone;

    @OneToMany
    private List<Booking> bookings;
}
/*
    1  -->  M
   User---Booking   so--> 1:M
    1  <---  1
*/