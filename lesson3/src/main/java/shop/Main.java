package shop;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        EntityManagerFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = entityFactory.createEntityManager();
        Client client1 = new Client();
        client1.setName("Ilya");
        createEntity(em,client1);
        Product product1 = new Product();
        Product product2 = new Product();
        product1.setTitle("Eggs");
        product1.setPrice(50.36);
        product2.setTitle("Meat");
        product2.setPrice(350.56);
        createEntity(em,product1);
        createEntity(em, product2);
        Sell sell1 = new Sell();
        sell1.setDate(date);
        sell1.setClient(client1);
        sell1.setProduct(product2);
        sell1.setAmount(1L);
        sell1.setPrice(product2.getPrice());
        createEntity(em,sell1);

    }

   private static <T> void createEntity (EntityManager em, T entity){
       System.out.println("Creating entity");
       em.getTransaction().begin();
       em.persist(entity);
       em.getTransaction().commit();
    }
}
