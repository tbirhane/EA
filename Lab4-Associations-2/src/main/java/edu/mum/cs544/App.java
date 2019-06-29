package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Bidirectional OneToMany association between Department and Employee using annotations
        Department dept1 = new Department("CS");
        Department dept2 = new Department("MBA");

        Employee emp1 = new Employee("Haile",dept1);
        Employee emp2 = new Employee("Miral",dept2);
        //add to department
        dept1.addEmployee(emp1);
        dept2.addEmployee(emp2);
        //persist
        em.persist(dept1);
        em.persist(dept2);
        em.persist(emp1);
        em.persist(emp2);
        em.getTransaction().commit();
        em.close();
        //Optional Unidirectional ManyToOne association between Book and Publisher using annotations
        Publisher pub1 = new Publisher("George");
        Book book1 = new Book("G000123", pub1);
        Book book2 = new Book("G000333", pub1);
        Book book3 = new Book("G000443", pub1);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book1);
        em.persist(book2);
        em.persist(book3);
        em.getTransaction().commit();
        em.close();
        //Bidirectional ManyToMany association between Student and Course using annotations.
        Student stud1 = new Student(new Long(111),"Henok");
        Course course1 = new Course("EA");
        Course course2 = new Course("WAA");
        stud1.addCourse(course1);
        stud1.addCourse(course2);
        course1.addStudent(stud1);
        course2.addStudent(stud1);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(stud1);
        em.getTransaction().commit();
        em.close();
        //Unidirectional OneToMany association between Customer and Reservation using annotations
        Reservation r1 = new Reservation(new GregorianCalendar(2019, Calendar.AUGUST,  23).getTime(), new GregorianCalendar(2019, Calendar.AUGUST,23).getTime());
        Reservation r2 = new Reservation(new GregorianCalendar(2020, Calendar.AUGUST,  24).getTime(), new GregorianCalendar(2019, Calendar.AUGUST,24).getTime());
        Customer c1 = new Customer("John");
        c1.addReservation(r1);
        c1.addReservation(r2);

        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c1);
        em.getTransaction().commit();
        em.close();
        //Unidirectional ManyToOne association between Reservation and Book
        Customer c2 = new Customer("Alan");
        Publisher pub2 = new Publisher("George");
        Book book4 = new Book("G000123", pub2);
        Book book5 = new Book("G000333", pub2);
        Reservation r3 = new Reservation(new GregorianCalendar(2019, Calendar.AUGUST,  23).getTime(), new GregorianCalendar(2019, Calendar.AUGUST,23).getTime(),book4);
        Reservation r4 = new Reservation(new GregorianCalendar(2020, Calendar.AUGUST,  24).getTime(), new GregorianCalendar(2019, Calendar.AUGUST,24).getTime(),book5);
        c2.addReservation(r3);
        c2.addReservation(r4);
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book4);
        em.persist(book5);
        em.persist(c2);
        //em.persist(r4);
        em.getTransaction().commit();
        em.close();

    }
}

