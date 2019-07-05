package edu.mum.cs544;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity

@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Date date;
    @ManyToOne
    @JoinColumn
    private Customer customer;
    @OneToMany
    @JoinColumn
    private List<OrderLine> orderLine = new ArrayList<>();

    public Order() {

    }

    public Order(Date date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }
    public void addOrderLine(OrderLine orderLine){
        this.orderLine.add(orderLine);
    }

    public Date getDate() {
        return date;
    }
}
