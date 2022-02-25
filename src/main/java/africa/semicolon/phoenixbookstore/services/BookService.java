package africa.semicolon.phoenixbookstore.services;

import africa.semicolon.phoenixbookstore.data.models.Book;
import africa.semicolon.phoenixbookstore.dtos.BookDto;
import africa.semicolon.phoenixbookstore.exception.BookDoesNotExistException;
import africa.semicolon.phoenixbookstore.exception.BookLogicException;

public interface BookService {
    Book addToFavoriteBooks(BookDto bookDto) throws BookDoesNotExistException, BookLogicException;
    Book findBookByTitle(String title) throws BookDoesNotExistException;
}
