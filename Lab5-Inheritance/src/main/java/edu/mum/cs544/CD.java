package edu.mum.cs544;

import javax.persistence.Entity;

@Entity
public class CD extends Product {
    private String artist;

    public CD(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }
}
