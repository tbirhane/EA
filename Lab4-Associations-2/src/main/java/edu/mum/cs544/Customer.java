package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public Customer(String name) {
        this.name = name;
        this.reservations = reservations;
    }
    public void addReservation(Reservation res){
        reservations.add(res);
    }


}
