package dev.hekmyr.holidays.api.repository;

import dev.hekmyr.holidays.api.entity.Amenity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, UUID> {}
