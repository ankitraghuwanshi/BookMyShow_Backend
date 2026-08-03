package org.scaler.bookmyshow_backend.repositories;

import org.scaler.bookmyshow_backend.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType,Long> {
}
