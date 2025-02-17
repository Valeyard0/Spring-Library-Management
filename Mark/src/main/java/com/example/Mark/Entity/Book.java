package com.example.Mark.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonIgnore
    private Long id;

    @Size(min = 2 , message = "Name has to be  at least 2 character")
    private String name;

    @NotNull
    private int page;

    private boolean bookAvailable;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    @NotNull
    private List<Author> author;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name ="person_id")
    private Person person;

    public Book(){}

    public Book(String name, int page, boolean bookAvailable) {
        this.name = name;
        this.page = page;
        this.bookAvailable = bookAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public void add(Author author){
        if(this.author == null)
            this.author = new ArrayList<>();
        this.author.add(author);
        author.setBook(this);
    }

    public boolean isBookAvailable() {
        return bookAvailable;
    }

    public void setBookAvailable(boolean bookAvailable) {
        this.bookAvailable = bookAvailable;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", page=" + page +
                ", bookAvailable=" + bookAvailable +
                ", author=" + author +
                ", person=" + person +
                '}';
    }
}
