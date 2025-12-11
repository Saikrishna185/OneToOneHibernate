package org.sk.mavenProject;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private int noOfPages;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    
    public Book() {
    }
    
    public Book(int id, String name, int price, int noOfPages, Author author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.noOfPages = noOfPages;
        this.author = author;
    }
    
    public Book(String name, int price, int noOfPages, Author author) {
        this.name = name;
        this.price = price;
        this.noOfPages = noOfPages;
        this.author = author;
    }
    
    public Book(String name, int price, int noOfPages) {
        this.name = name;
        this.price = price;
        this.noOfPages = noOfPages;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getNoOfPages() {
        return noOfPages;
    }
    
    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && price == book.price && noOfPages == book.noOfPages && Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, noOfPages, author);
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", noOfPages=" + noOfPages +
                ", author=" + author +
                '}';
    }
}
