package africa.semicolon.phoenixbookstore.data.repositories;

import africa.semicolon.phoenixbookstore.data.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@Sql(scripts = "/db/insert.sql")
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("save book to database ")
    void saveBookToDatabaseTest(){

        Book book = new Book();
        book.setTitle("java");
        book.setDescription("programming language");
        book.setAuthor("deital");;
        book.setPageCount(600);

        assertThat(book.getId()).isNull();

        log.info("book saved :: {}", book );
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
        assertThat(book.getTitle()).isEqualTo("java");
        assertThat(book.getAuthor()).isEqualTo("deital");
    }



    @Test
    @DisplayName("find book by title")
    void findBooksByTitleTest(){

        Book book =  bookRepository.findByTitle("java").orElse(null);
        assertThat(book).isNotNull();
        assertThat(book.getId()).isEqualTo(11);
        assertThat(book.getTitle()).isEqualTo("java");
        assertThat(book.getAuthor()).isEqualTo("deital");
        assertThat(book.getPageCount()).isEqualTo(600);;

        log.info("book records retrieved :: {} ", book);
    }


    @Test
    @DisplayName("find all books in the database")
    void findAllBookTest() {
        List<Book> books= bookRepository.findAll();
        AssertionsForInterfaceTypes.assertThat(books).isNotNull();
        assertThat(books.size()).isEqualTo(1);

    }




}
