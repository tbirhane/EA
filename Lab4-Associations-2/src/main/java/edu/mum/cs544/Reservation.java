package edu.mum.cs544;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private Date time;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Book book;




    public Reservation(Date date, Date time) {
        this.date = date;
        this.time = time;
    }

    public Reservation(Date date, Date time, Book book) {
        this.date = date;
        this.time = time;
        this.book = book;
    }
}
