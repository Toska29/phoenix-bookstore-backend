package africa.semicolon.phoenixbookstore.services;

import africa.semicolon.phoenixbookstore.data.models.Book;
import africa.semicolon.phoenixbookstore.data.repositories.BookRepository;
import africa.semicolon.phoenixbookstore.dtos.BookDto;
import africa.semicolon.phoenixbookstore.exception.BookDoesNotExistException;
import africa.semicolon.phoenixbookstore.exception.BookLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book addToFavoriteBooks(BookDto bookDto) throws BookLogicException {
        if (bookDto == null){
            throw new IllegalArgumentException("Argument cannot be null");
        }

        Optional<Book> query = bookRepository.findByTitle(bookDto.getTitle());
        if (query.isPresent()){
            throw new BookLogicException("employee email exists" +bookDto.getTitle());
        }


      Book book = new Book();

        book.setTitle(bookDto.getTitle());
        book.setDescription(bookDto.getDescription());
        book.setAuthor(bookDto.getAuthor());
        return  bookRepository.save(book);
    }


    @Override
    public Book findBookByTitle(String title) throws BookDoesNotExistException {

        if ( title == null){
            throw new IllegalArgumentException("argument cannot be null");
        }

        Optional<Book> queryResult = bookRepository.findByTitle(title);
        if (queryResult.isPresent()) {
            return queryResult.get();
        }
        throw new BookDoesNotExistException("employee with this email :"  + title + "does not exist");
    }


}
