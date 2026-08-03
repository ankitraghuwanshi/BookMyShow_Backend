package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="theatres")
public class Theatre extends BaseModel {
    private String theatreName;

    @OneToMany
    private List<Screen> screens;

    @ManyToOne
    private City city;
}
/*
         1   -->   M
     Theatre -- Screen    so-->  1:M
        1    <--  1


         1   -->   1
      Theatre -- City     so-->  M:1
         M   <--  1
*/