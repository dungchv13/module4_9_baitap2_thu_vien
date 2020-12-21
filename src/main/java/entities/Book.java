package entities;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String author;

    private String name;

    @Column(nullable = false)
    private int quantity;

    public Book() {
    }

    public Book(String author, String name, int quantity) {
        this.author = author;
        this.name = name;
        this.quantity = quantity;
    }

    public Book(int id, String author, String name, int quantity) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
