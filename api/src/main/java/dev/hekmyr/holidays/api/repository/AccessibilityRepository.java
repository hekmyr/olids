package dev.hekmyr.holidays.api.repository;

import dev.hekmyr.holidays.api.entity.Accessibility;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessibilityRepository
    extends JpaRepository<Accessibility, UUID> {}
