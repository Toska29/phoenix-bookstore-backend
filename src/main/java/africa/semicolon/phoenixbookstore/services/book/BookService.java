package africa.semicolon.phoenixbookstore.services.book;

import africa.semicolon.phoenixbookstore.data.models.Book;
import africa.semicolon.phoenixbookstore.dtos.BookDto;
import africa.semicolon.phoenixbookstore.exceptions.BookDoesNotExistException;
import africa.semicolon.phoenixbookstore.exceptions.PhoenixBookStoreException;

public interface BookService {
    Book addToFavoriteBooks(BookDto bookDto) throws BookDoesNotExistException, PhoenixBookStoreException;
    Book findBookByTitle(String title) throws BookDoesNotExistException;
}
