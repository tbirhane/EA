package edu.mum.cs544;
import javax.persistence.*;
import java.util.Set;
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Employee employee;

    public Laptop() {
    }

    public Laptop(String model, Employee employee) {
        this.model = model;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
