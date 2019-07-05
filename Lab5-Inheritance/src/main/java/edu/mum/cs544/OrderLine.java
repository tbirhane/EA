package edu.mum.cs544;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @ManyToOne
    private Product product;



    public OrderLine() {

    }

    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;

        this.product = product;
    }
}
