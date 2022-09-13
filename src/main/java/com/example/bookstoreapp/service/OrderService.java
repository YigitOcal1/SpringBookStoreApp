package com.example.bookstoreapp.service;

import com.example.bookstoreapp.repository.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final BookService bookService;


    public OrderService(BookService bookService) {
        this.bookService = bookService;
    }


}
