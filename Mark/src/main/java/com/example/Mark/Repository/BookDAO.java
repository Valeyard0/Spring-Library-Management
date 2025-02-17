package com.example.Mark.Repository;

import com.example.Mark.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Book,Long> { }
