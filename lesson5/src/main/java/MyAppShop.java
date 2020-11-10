
import geekbrains.lesson5.repository.InitData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class MyAppShop {
    public static void main(String[] args) {
        SessionFactory entityFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager em = entityFactory.createEntityManager();

        InitData.initData(em);

        //em.close();


    }
}
