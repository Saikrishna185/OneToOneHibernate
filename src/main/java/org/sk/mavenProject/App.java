package org.sk.mavenProject;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the book name");
        String bookName = sc.next();
        System.out.println("Enter the book price");
        int bookPrice = sc.nextInt();
        System.out.println("Enter the number of pages");
        int noOfPages = sc.nextInt();
        Book book = new Book(bookName, bookPrice, noOfPages);
        
        
        System.out.println("Enter the author name");
        String authorName = sc.next();
        System.out.println("Enter the author gender");
        String authorGender = sc.next();
        System.out.println("Enter the author age");
        int authorAge = sc.nextInt();
        System.out.println("Enter the author address");
        String authorAddress = sc.next();
        Author author = new Author(authorName, authorGender, authorAge, authorAddress);
        
        book.setAuthor(author);
        
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(book);
        tx.commit();
        session.close();
        factory.close();
        System.out.println("Data saved successfully");
        sc.close();
        
    }
}
