package com.example.bookstoreapp.controller;

import com.example.bookstoreapp.dto.BookOrderRequest;
import com.example.bookstoreapp.model.BookModel;
import com.example.bookstoreapp.model.Order;
import com.example.bookstoreapp.service.BookService;
import com.example.bookstoreapp.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bookstore")
public class BookStoreController {

    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookModel>> getAllBooks(){
        List<BookModel> bookList=bookService.getAllBooks();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        List<Order> orderList=orderService.getAllOrders();
        return ResponseEntity.ok(orderList);
    }

    @PostMapping
    public ResponseEntity<Order> giveAnOrder(@RequestBody BookOrderRequest bookOrderRequest){
        Order order=orderService.giveAnOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }

}
