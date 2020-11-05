package geekbrains.lesson4.repository;

import geekbrains.lesson4.shoples4.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductImplDAO implements ProductDAO {

    private final EntityManager em;

    public ProductImplDAO(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Product> findAll() {
        return em.createQuery("SELECT p from Product p", Product.class).getResultList();
    }


    @Override
    public Product findById(Long id) {
        return em.createQuery("SELECT p from Product p where p.id = :id", Product.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public void save(Product title, Product price) {
        em.getTransaction().begin();
        em.persist(title);
        em.persist(price);
        em.getTransaction().commit();
    }

    @Override
    public void update(Product title, Product price) {
        em.getTransaction().begin();
        em.merge(title);
        em.merge(price);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Product title) {
        em.getTransaction().begin();
        em.remove(title);
        em.getTransaction().commit();
    }
}


