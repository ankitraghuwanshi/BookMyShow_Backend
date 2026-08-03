package org.scaler.bookmyshow_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name="shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    @OneToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
/*
  1 --> 1
Show---Movie    => M:1
  M  <-- 1

    1 --> 1
  Show---Screen   => 1:1  (at a time)
    1 <-- 1
*/