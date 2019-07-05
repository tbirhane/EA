package edu.mum.cs544;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@SecondaryTable(name="Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(table="Patient")
    private String name;
    private String street;
    private String zip;
    private String city;

    public Patient() {

    }

    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }
}
