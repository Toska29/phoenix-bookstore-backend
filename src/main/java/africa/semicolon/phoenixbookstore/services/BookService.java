package africa.semicolon.phoenixbookstore.services;

import africa.semicolon.phoenixbookstore.data.models.Book;
import africa.semicolon.phoenixbookstore.dtos.BookDto;

public interface BookService {
    Book addToFavoriteBooks(BookDto bookDto);
    Book findBookByTitle(String title);
}
