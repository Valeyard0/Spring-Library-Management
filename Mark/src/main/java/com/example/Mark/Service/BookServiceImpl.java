package com.example.Mark.Service;

import com.example.Mark.Entity.Author;
import com.example.Mark.Entity.Book;
import com.example.Mark.Entity.Person;
import com.example.Mark.Exceptions.BookNotFound;
import com.example.Mark.Repository.BookDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService {

    private final BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO){
        this.bookDAO=bookDAO;
    }

    @PostConstruct
    public void bookInit() {
        Book book = new Book("1984", 500,false);
        Author author = new Author("George", "Orwell", "sci-fi");
        Author author2 = new Author("George", "Orwell", "sci-fi");
        book.setPerson(new Person("Emre","Karal", LocalDate.now()));
        book.add(author);
        book.add(author2);
        bookDAO.save(book);
    }

    @Override
    public List<Book> gatherAllBook(){
        List<Book> books = bookDAO.findAll();
        System.out.println(books);
        return books;
    }

    @Override
    public Book gatherBookFromId(Long id){
        Optional<Book> book = bookDAO.findById(id);
        if(book.isEmpty())
            throw new BookNotFound("Book does not exist! id:" + id);
        return book.get();
    }

    @Override
    public void saveBook(Book book){
        bookDAO.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = this.gatherBookFromId(id);
        bookDAO.delete(book);
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }
}