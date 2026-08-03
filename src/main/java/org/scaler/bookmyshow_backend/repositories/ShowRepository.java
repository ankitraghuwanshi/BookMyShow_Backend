package org.scaler.bookmyshow_backend.repositories;

import org.scaler.bookmyshow_backend.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
