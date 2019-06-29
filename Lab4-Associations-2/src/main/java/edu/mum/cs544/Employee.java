package edu.mum.cs544;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee(String name,Department department) {
        this.name = name;
        this.department = department;

    }


}
