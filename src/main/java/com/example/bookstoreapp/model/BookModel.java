package com.example.bookstoreapp.model;

import lombok.*;

import javax.persistence.*;


@Data
@Getter
@Setter
@Builder
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor

public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer book_id;

    private String book_name;
    private String book_author;
    private Double book_price;
    private Integer book_stock;
}
