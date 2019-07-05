package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        Patient patient1 = new Patient("tulga","CH2356","345","Chicago");
        Patient patient2 = new Patient("tulga","CH2356","345","Chicago");

        Payment payment = new Payment("12/04/2019", 5680.0);
        Doctor doctor = new Doctor("Heart Specialist", "Hellen","Gebru");
        Appointment appointment = new Appointment("12/04/2019", patient1,payment,doctor );

        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Appointment> query = em.createQuery("from Appointment", Appointment.class);
        List<Appointment> appointmentList = query.getResultList();
        for(Appointment a: appointmentList){
            System.out.println(a.getAppdate()+ " "+
                    a.getPatient().getName() + " "+
                    a.getDoctor().getFirstname());
        }
        em.getTransaction().commit();
        em.close();


    }
}
