package com.example.bookstoreapp;

import com.example.bookstoreapp.model.BookModel;
import com.example.bookstoreapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreAppApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public BookStoreAppApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BookModel book1 = BookModel.builder().book_name("deneme_book_1").book_author("deneme_author1").book_price(15.0).book_stock(11).build();
        BookModel book2 = BookModel.builder().book_name("deneme_book_2").book_author("deneme_author2").book_price(25.3).book_stock(15).build();
        BookModel book3 = BookModel.builder().book_name("deneme_book_3").book_author("deneme_author3").book_price(35.5).book_stock(20).build();

        bookRepository.saveAll(Arrays.asList(book1,book2,book3));
    }
}
