package shop;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sell")
public class Sell {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "amount")
    private Long amount;
    @Column(name = "price")
    private double price;

    @OneToOne
    @JoinColumn(name = "product_title")
    private Product product;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Sell(){
    }


    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public Date getDate(){return date;}
    public void setDate(Date date){this.date=date;}

    public Long getAmount(){return amount;}
    public void setAmount(Long amount){this.amount=amount;}

    public double getPrice(){return price;}
    public void setPrice(double price){this.price = price;}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
