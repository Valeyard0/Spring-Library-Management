package com.example.Mark.Service;

import com.example.Mark.Entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> gatherAllBook();
    Book gatherBookFromId(Long id);
    void saveBook(Book book);
    void deleteBook(Long id);
    Book updateBook(Book book , Long id);
}
