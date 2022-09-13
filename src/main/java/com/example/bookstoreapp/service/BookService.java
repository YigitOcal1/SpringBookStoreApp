package com.example.bookstoreapp.service;

import com.example.bookstoreapp.model.BookModel;
import com.example.bookstoreapp.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<BookModel> findBookById(Integer bookId){
        return  bookRepository.findById(bookId);
    }

    public List<BookModel> getAllBooks(){
        return bookRepository.findAll();
    }
}
