package africa.semicolon.phoenixbookstore.data.repositories;

import africa.semicolon.phoenixbookstore.data.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
    }



    @Test
    @DisplayName("save an employee ")
    void saveAnEmployeeToDatabaseTest(){

        Book book = new Book();
        book.setTitle("java");
        book.setDescription("programming language");
        book.setAuthor("deital");;
        book.setPageCount(600);

        assertThat(book.getId()).isNull();

        log.info("product saved :: {}", book );
        bookRepository.save(book);

        assertThat(book.getTitle()).isEqualTo("java");
        assertThat(book.getAuthor()).isEqualTo("deital");
    }



    @Test
    @DisplayName("find employee by email")

    void findBooksByTitleTest(){

        Book book =  bookRepository.findByTitle("java").orElse(null);
        assertThat(book).isNotNull();
        assertThat(book.getId()).isEqualTo(11);
        assertThat(book.getFirstName()).isEqualTo("John");
        assertThat(employee.getLastName()).isEqualTo("Ade");
        assertThat(employee.getPhoneNumber()).isEqualTo("08130249216");;

        log.info("employee records retrieved :: {} ", employee);
    }





}
