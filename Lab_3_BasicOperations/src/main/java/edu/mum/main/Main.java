package edu.mum.main;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        ApplicationContext acxt = new ClassPathXmlApplicationContext("context/applicationContext.xml");
        UserService userService = (UserService) acxt.getBean("userServiceImpl");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");
//        EntityManager em = emf.createEntityManager();


        User user = new User();
        user.setFirstName("James");
        user.setLastName("Smith");
        user.setEmail("james12@gmail.com");
        user.setAdmin(false);
        user.setRating(1);
        user.setVersion(2);
        user.setLastLogin(new GregorianCalendar(2011, Calendar.AUGUST, 12).getTime());
        userService.save(user);


//      users = userService.findAll();
//      System.out.println("User Count:" + users.size());

        User getUser = userService.findByEmail("james12@gmail.com");

        System.out.println();
        System.out.println("        *********  USER **********");

        System.out.println("User Name: " + getUser.getFirstName() + " " + getUser.getLastName());

        //New object and update
        User user1 = new User();
        user1.setFirstName("Eron");
        user1.setLastName("Smith");
        user1.setEmail("sam12@gmail.com");
        user1.setAdmin(false);
        user1.setRating(1);
        user1.setVersion(2);
        user1.setLastLogin(new GregorianCalendar(2011, Calendar.AUGUST, 12).getTime());
        userService.save(user1);

       // update user1
        user1.setFirstName("Bohari");
        userService.update(user1);
        getUser = userService.findByEmail("sam12@gmail.com");
        System.out.println();
        System.out.println("        *********  Updated USER **********");
        System.out.println("User Name: " + getUser.getFirstName() + " " + getUser.getLastName());
        //Merge
       //  StaleObjectStateException
//        userService.detach(user1);
//        user1.setFirstName("Updated Name");
//        userService.update(user1);
//         getUser = userService.findByEmail("sam12@gmail.com");
//         System.out.println();
//         System.out.println("        *********  Updated USER After Detach **********");
//         System.out.println("User Name: " + getUser.getFirstName() + " " + getUser.getLastName());
//

    }
}