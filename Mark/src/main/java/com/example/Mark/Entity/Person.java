package com.example.Mark.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Size(min = 2 , message = "Name has to be  at least 2 character")
    private String name;

    @Size(min = 2 , message = "Surname has to be  at least 2 character")
    private String surname;

    @FutureOrPresent
    private LocalDate localDate;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY, cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Book> books;

    public Person(){}

    public Person(String name, String surname, LocalDate localDate) {
        this.name = name;
        this.surname = surname;
        this.localDate = localDate;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
