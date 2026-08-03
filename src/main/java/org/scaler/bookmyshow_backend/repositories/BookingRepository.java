package org.scaler.bookmyshow_backend.repositories;

import org.scaler.bookmyshow_backend.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
