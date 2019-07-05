package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer customer1 = new Customer("John", "Eren");
        Customer customer2 = new Customer("John", "Eren");

        Order order1 = new Order(new GregorianCalendar(2019, Calendar.AUGUST, 11).getTime(), customer1);
        Order order2 = new Order(new GregorianCalendar(2019, Calendar.APRIL,18).getTime(), customer1);


       // Product product1 = new Product("Burger","tomato and cheese");
       // Product product2 = new Product("Beer","7 percent alchool");
        Product product1 = new CD("Game of throne", "Adventure","Gorge");
        Product product2 = new Book("The secret", "Adventure","The knights");
        OrderLine orderLine1 = new OrderLine(2,product1);
        OrderLine orderLine2 = new OrderLine(5,product2);
        order1.addOrderLine(orderLine1);em.persist(product1);
        em.persist(product2);
        order2.addOrderLine(orderLine2);


        em.persist(product1);
        em.persist(product2);
        em.persist(customer1);
        em.persist(order1);
        em.persist(order2);
        em.persist(orderLine1);
        em.persist(orderLine2);

        em.getTransaction().commit();
        em.close();
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Customer> query = em.createQuery("from Customer", Customer.class);
        List<Customer> customerList = query.getResultList();
        for(Customer c: customerList) {
        System.out.println(c.getFirstname() + " " + c.getLastname() + " " +c.getOrderList().get(0).getDate());

        }

    }
}
