package africa.semicolon.phoenixbookstore.data.repositories;

import africa.semicolon.phoenixbookstore.data.models.AppUser;
import africa.semicolon.phoenixbookstore.data.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql(scripts = "/db/user_insert.sql")
@Slf4j
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Create a book user book test")
    void whenNewUserIsCreated_thenCreateBookTest(){
        List<Book> bookList = new ArrayList<>();
        AppUser appUser = new AppUser();
        appUser.setFirstName("John");
        appUser.setLastName("Ogbe");
        appUser.setEmail("johnogbe@gmail.com");
        appUser.setPassword("hellopassword");

        Book book = new Book();
        book.setTitle("oh baby");
        book.setDescription("na me go marry you");
        book.setAuthor("my heart");

        bookList.add(book);
        appUser.setBookshelf(bookList);

        userRepository.save(appUser);

        assertThat(appUser.getId()).isNotNull();
        assertThat(appUser.getBookshelf()).isNotNull();

        log.info("App User Created --> {}", appUser);

    }
}