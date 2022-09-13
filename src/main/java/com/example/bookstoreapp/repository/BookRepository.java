package com.example.bookstoreapp.repository;

import com.example.bookstoreapp.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Integer> {




}
