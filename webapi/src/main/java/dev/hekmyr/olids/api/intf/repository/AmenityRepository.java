package dev.hekmyr.olids.api.intf.repository;

import dev.hekmyr.olids.api.entity.Amenity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<Amenity, UUID> {}
