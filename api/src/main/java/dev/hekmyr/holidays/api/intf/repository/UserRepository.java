package dev.hekmyr.holidays.api.intf.repository;

import dev.hekmyr.holidays.api.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByEmail(String Email);

    @Query("SELECT u.id FROM User u WHERE u.email = :email")
    public UUID findIdByEmail(String email);
}
