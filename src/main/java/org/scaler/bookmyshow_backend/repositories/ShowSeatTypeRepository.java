package org.scaler.bookmyshow_backend.repositories;

import org.scaler.bookmyshow_backend.models.Show;
import org.scaler.bookmyshow_backend.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
    @Override
    Optional<ShowSeatType> findById(Long aLong);

    List<ShowSeatType> findAllByShow(Show show);
}
