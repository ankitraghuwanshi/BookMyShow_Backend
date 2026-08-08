package org.scaler.bookmyshow_backend.repositories;

import org.scaler.bookmyshow_backend.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    List<ShowSeat> findAllById(List<Long> showSeatId);
    ShowSeat save(ShowSeat showSeat);
}
