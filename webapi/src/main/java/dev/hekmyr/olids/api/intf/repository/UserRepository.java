package dev.hekmyr.olids.api.intf.repository;

import dev.hekmyr.olids.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  public User findByEmail(String Email);
}
