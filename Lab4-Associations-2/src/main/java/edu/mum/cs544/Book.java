package edu.mum.cs544;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ISBN;
    @ManyToOne(cascade = CascadeType.ALL)
    private Publisher publishers;

    public Book() {

    }

    public Book(String ISBN, Publisher publishers) {
        this.ISBN = ISBN;
        this.publishers = publishers;
    }
}
