package africa.semicolon.phoenixbookstore.data.repositories;

import africa.semicolon.phoenixbookstore.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

}
