package com.example.bookstoreapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Data
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity(name = "bookOrder")
@AllArgsConstructor
@NoArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;
    private List<Integer> bookList;
    private Double totalPrice;

}
