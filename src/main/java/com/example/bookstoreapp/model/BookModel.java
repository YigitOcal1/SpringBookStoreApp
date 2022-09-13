package com.example.bookstoreapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Data
@Getter
@Setter
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer book_id;

    private String book_name;
    private String book_author;
    private Double book_price;
    private Integer book_stock;
}
