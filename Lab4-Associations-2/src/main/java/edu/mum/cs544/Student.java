package edu.mum.cs544;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)

    private List<Course> courses = new ArrayList<Course>();

    public Student() {

    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public void addCourse(Course course){
        courses.add(course);
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
