package africa.semicolon.phoenixbookstore.data.repositories;

import africa.semicolon.phoenixbookstore.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
}
