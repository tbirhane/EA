package edu.mum.cs544;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }
}
