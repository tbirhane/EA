package edu.mum.cs544;

import javax.persistence.*;
import java.util.Set;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "employee")
    private Set<Laptop> laptops;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Laptop> getLaptops() {
        return laptops;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLaptops(Set<Laptop> laptops) {
        this.laptops = laptops;
    }

}
