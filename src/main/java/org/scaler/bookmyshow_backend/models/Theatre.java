package org.scaler.bookmyshow_backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre extends BaseModel {
    private String theatreName;
    private List<Screen> screens;
    private City city;
}
