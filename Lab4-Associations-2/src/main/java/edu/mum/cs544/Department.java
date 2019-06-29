package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department(){}

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
}
