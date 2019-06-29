package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    private List<Flight> flights;

    public Passenger() {
    }

    public Passenger(String name) {
        this.name = name;
        flights = new ArrayList<Flight>();

    }
    public void addFlight(Flight flight){
        flights.add(flight);
    }

}
