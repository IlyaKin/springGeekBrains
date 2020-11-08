package geekbrains.lesson5.repository;

import geekbrains.lesson5.domain.ProductinShop;
import geekbrains.lesson5.domain.ProductinShop;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductImplDAO implements ProductDAO {

    private EntityManager em;

    public ProductImplDAO (EntityManager em){this.em=em;}

    @Override
    public List<ProductinShop> findAll() {
        return em.createQuery("SELECT p from ProductinShop p", ProductinShop.class).getResultList();
    }

    @Override
    public List<ProductinShop> findByPages(int id) {
        return em.createQuery("SELECT p from ProductinShop p where p.id > 5*(:id-1) and p.id <= 5*:id",
                ProductinShop.class).setParameter("id", id).getResultList();
    }
    @Override
    public ProductinShop findById(Long id) {
        return em.createQuery("SELECT p from ProductinShop p where p.id = :id", ProductinShop.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public ProductinShop findmaxPrice(){
        return em.createQuery("select p from ProductinShop p where p.price = (select max(p.price) from p)", ProductinShop.class).getSingleResult();
    }
    @Override
    public ProductinShop findminPrice(){
        return em.createQuery("select p from ProductinShop p where p.price = (select min(p.price) from p)", ProductinShop.class).getSingleResult();
    }

    @Override
    public void save(ProductinShop product) {
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    @Override
    public void update(ProductinShop product) {
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
    }

    @Override
    public void delete(ProductinShop title) {
        em.getTransaction().begin();
        em.remove(title);
        em.getTransaction().commit();
    }

    @Override
    public void deletebyId(Long id) {
        System.out.println("zaglushka");
    }
}

