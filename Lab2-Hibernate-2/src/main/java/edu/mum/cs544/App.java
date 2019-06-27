package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args){
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        //retrive all students
        em.getTransaction().begin();
        TypedQuery<Students> query1 = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> students = query1.getResultList();
        for (Students student: students){
            System.out.println(student.getName());
        }
        em.getTransaction().commit();
        em.close();

        //add extra student
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Students student = new Students(12,"Sami","hellen199@gmail.com","password");
        em.persist(student);
        em.getTransaction().commit();
        em.close();

        //
        //retrive all students
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Students> query2 = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> students2 = query2.getResultList();
        for (Students s: students2){
            System.out.println(s.getName());
        }
        em.getTransaction().commit();
        em.close();

    }
}
