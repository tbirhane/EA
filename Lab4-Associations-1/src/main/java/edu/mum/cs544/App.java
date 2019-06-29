package edu.mum.cs544;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {

	private static EntityManagerFactory emf;
    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Create new instance of Car and set values in it
        Owner owner = new Owner("James","fairfield");
        Car car1 = new Car("BMW", "SDA231", 30221.00,owner);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00,owner);
        // save the car
        em.persist(car2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retrieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
        }
        em.getTransaction().commit();
        em.close();

        //Bidirectional between Employee and Laptop
        //create new instance of Employee and Laptop;
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Employee emp1 = new Employee("Jammes");
        Employee emp2 = new Employee("Nasri");

        Laptop lap1 = new Laptop("Hp", emp1);
        Laptop lap2 = new Laptop("Hp", emp1);

        em.persist(emp1);
        em.persist(lap1);
        em.persist(lap2);
        em.getTransaction().commit();
        em.close();
        // Unidirectional OneToMany between Passenger and Flight using a List
        Flight flight1 = new Flight("Chicago","New Jersy");
        Flight flight2 = new Flight("Dc","London");
        Passenger passenger = new Passenger("Kahn");
        passenger.addFlight(flight1);
        passenger.addFlight(flight2);

        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(passenger);
        em.getTransaction().commit();
        em.close();

    //Unidirectional OneToMany association between School and Student using a Map

        //create student
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student1 = new Student(new Long(123), "Nahom");
        Student student2 = new Student(new Long(1234), "Kidu");
        School school = new School("MUM");
        school.addStudent(student1);
        school.addStudent(student2);

        em.persist(school);
//        em.persist(student1);
//        em.persist(student2);

        em.getTransaction().commit();
        em.close();




    }
}

