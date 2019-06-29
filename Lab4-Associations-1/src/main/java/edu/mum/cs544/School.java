package edu.mum.cs544;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @MapKey(name="id")
    @JoinColumn(name = "school_id")
    private Map<Long, Student> students;

    public School() {
    }

    public School(String name) {
        this.name = name;
        students = new HashMap<Long, Student>();
    }
    public void addStudent(Student student){
        students.put(student.getId(), student);
    }

}
