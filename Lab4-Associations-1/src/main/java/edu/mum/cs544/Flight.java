package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_no;
    @Column(name = "takeOf_place")
    private String from;
    private String destination;


    public Flight() {
    }

    public Flight(String from, String destination) {
        this.from = from;
        this.destination = destination;
    }



}
