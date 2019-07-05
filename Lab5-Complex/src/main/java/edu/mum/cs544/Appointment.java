package edu.mum.cs544;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appdate;
    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;
    @Embedded
    private Payment payment;
    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor;


    public Appointment() {

    }

    public Appointment(String appdate, Patient patient, Payment payment, Doctor doctor) {
        this.appdate = appdate;
        this.patient = patient;
        this.payment = payment;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public String getAppdate() {
        return appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
