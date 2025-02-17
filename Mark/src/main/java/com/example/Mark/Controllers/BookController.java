package com.example.Mark.Controllers;

import com.example.Mark.Entity.Book;
import com.example.Mark.Service.IBookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final IBookService iBookService;

    public BookController(IBookService iBookService){
        this.iBookService = iBookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Book>> findAll(){
        return new ResponseEntity<>(iBookService.gatherAllBook(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findOneBook(@PathVariable Long id){
        Book book = iBookService.gatherBookFromId(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        iBookService.saveBook(book);
        return new ResponseEntity<>(book ,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book){
       iBookService.updateBook(book,id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
            iBookService.deleteBook(id);
            return new ResponseEntity<String>("Book deleted successfully.",HttpStatus.OK);
    }
}
