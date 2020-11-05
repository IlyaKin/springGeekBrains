package shop;


import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;

    public Client(){

    }
    public long getId(){return id;
    }
    public void setId(Long id){this.id = id;
    }
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
}
