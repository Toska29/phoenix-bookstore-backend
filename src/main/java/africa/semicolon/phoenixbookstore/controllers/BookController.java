package africa.semicolon.phoenixbookstore.controllers;

import africa.semicolon.phoenixbookstore.data.models.Book;
import africa.semicolon.phoenixbookstore.dtos.BookDto;
import africa.semicolon.phoenixbookstore.exception.BookDoesNotExistException;
import africa.semicolon.phoenixbookstore.exception.BookLogicException;
import africa.semicolon.phoenixbookstore.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("api/get-books-title")
    public ResponseEntity<?> findEmployeeByEmail(String title) {
        try {
            Book savedBook = bookService.findBookByTitle(title);
            return ResponseEntity.ok().body(savedBook);
        }
        catch (BookDoesNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping()
    public ResponseEntity<?> addEmployees(@RequestBody BookDto bookDto) {


        log.info("added an employee :: {} ", bookDto);
        try {
            Book savedBook = bookService.addToFavoriteBooks(bookDto);
            return ResponseEntity.ok().body(savedBook);
        } catch (BookLogicException | BookDoesNotExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
