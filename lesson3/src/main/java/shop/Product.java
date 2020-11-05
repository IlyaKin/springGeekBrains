package shop;

import javax.persistence.*;
import java.io.StringReader;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;

    public Product(){

    }
    public long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public double getPrice(){return price;}
    public void setPrice(Double price){this.price=price;}
}
