package africa.semicolon.phoenixbookstore.data.repositories;

import africa.semicolon.phoenixbookstore.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
