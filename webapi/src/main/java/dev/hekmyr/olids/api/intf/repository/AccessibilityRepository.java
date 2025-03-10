package dev.hekmyr.olids.api.intf.repository;

import dev.hekmyr.olids.api.entity.Accessibility;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessibilityRepository
  extends JpaRepository<Accessibility, UUID> {}
