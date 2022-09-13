package com.example.bookstoreapp.service;

import com.example.bookstoreapp.model.BookModel;
import com.example.bookstoreapp.model.Order;
import com.example.bookstoreapp.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {


    private final Logger logger= LoggerFactory.getLogger(OrderService.class);
    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }
    public Order giveAnOrder(List<Integer> bookIdList, String userName){
        List<Optional<BookModel>> bookList=bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());

        Double totalPrice=bookList.stream()

                .map(optionalBook->optionalBook.map(BookModel::getBook_price).orElse(0.0))
                .reduce(0.0,Double::sum);

        Order order= Order.builder()
                .bookIdList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return orderRepository.save(order);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
