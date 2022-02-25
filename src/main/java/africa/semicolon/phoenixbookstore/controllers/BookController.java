package africa.semicolon.phoenixbookstore.controllers;

import africa.semicolon.phoenixbookstore.data.models.Book;
import africa.semicolon.phoenixbookstore.data.dto.BookDto;
import africa.semicolon.phoenixbookstore.exceptions.BookDoesNotExistException;
import africa.semicolon.phoenixbookstore.exceptions.PhoenixBookStoreException;
import africa.semicolon.phoenixbookstore.services.book.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<?> findEmployeeByEmail(String title) {
        try {
            Book savedBook = bookService.findBookByTitle(title);
            return ResponseEntity.ok().body(savedBook);
        }
        catch (BookDoesNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("")
    public ResponseEntity<?> addBooks(@RequestBody BookDto bookDto) {

        try {
            Book savedBook = bookService.addToFavoriteBooks(bookDto);
            return ResponseEntity.ok().body(savedBook);
        } catch (PhoenixBookStoreException | BookDoesNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
