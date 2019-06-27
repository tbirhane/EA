package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;
    public static  void main(String[] args) throws Exception{
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //Task 1
        System.out.println("Task 1 statrted:");
        Book book1 = new Book("The Secret","32000998","Jack", 890.0, new GregorianCalendar(2014, Calendar.APRIL, 5).getTime());
        Book book2 = new Book("Game of Thrones","210004328","George", 1090.0, new GregorianCalendar(2013, Calendar.SEPTEMBER, 11).getTime());
        Book book3 = new Book("Blood Diamend","010007898","Jack", 800.0, new GregorianCalendar(2012, Calendar.MARCH, 1).getTime());
        em.persist(book1);
        em.persist(book2);
        em.persist(book3);
        em.getTransaction().commit();
        em.close();
        // Task 2
        System.out.println("Task 2 statrted:");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query1 = em.createQuery("from Book", Book.class);
        List<Book> books = query1.getResultList();
        for(Book book: books){
            System.out.println("Title = " + book.getTitle()+
                    " ISBN = " + book.getISBN()+
                    " Author = " + book.getAuthor()+
                    " Price = "+ book.getPrice()+
                    " Date = "+ book.getPublish_date());
        }
        em.getTransaction().commit();
        em.close();

        //Task 3
        System.out.println("Task 3 statrted:");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query2 = em.createQuery("from Book", Book.class);
        List<Book> books2 = query2.getResultList();
        Book updatebook = null;
        Book[] bookArray = new Book[3];
        int index = 0;
        for(Book book: books2){
            bookArray[index] = book;
            index++;
        }
        bookArray[0].setTitle("Amanda");
        bookArray[0].setPrice(900.0);
        em.persist(bookArray[0]);
        em.remove(bookArray[1]);
        em.getTransaction().commit();
        em.close();

        //Task 4
        System.out.println("Task 4 statrted:");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> query3 = em.createQuery("from Book", Book.class);
        List<Book> books3 = query3.getResultList();
        System.out.println("Updated:");
        for(Book book: books3){
            System.out.println("Title = " + book.getTitle()+
                    " ISBN = " + book.getISBN()+
                    " Author = " + book.getAuthor()+
                    " Price = "+ book.getPrice()+
                    " Date = "+ book.getPublish_date());
        }
        em.getTransaction().commit();
        em.close();


        }
}
