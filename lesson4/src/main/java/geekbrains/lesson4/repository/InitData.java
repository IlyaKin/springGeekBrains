package geekbrains.lesson4.repository;

import geekbrains.lesson4.domain.ProductinShop;

import javax.persistence.EntityManager;

public class InitData {

    private static ProductinShop PRODUCT_1 = new ProductinShop();
    private static ProductinShop PRODUCT_2 = new ProductinShop();
    private static ProductinShop PRODUCT_3 = new ProductinShop();
    private static ProductinShop PRODUCT_4 = new ProductinShop();
    private static ProductinShop PRODUCT_5 = new ProductinShop();

    static {
        PRODUCT_1.setTitle("meat");
        PRODUCT_1.setPrice(306.0);
        PRODUCT_2.setTitle("eggs");
        PRODUCT_2.setPrice(65.50);
        PRODUCT_3.setTitle("tomato");
        PRODUCT_3.setPrice(90.30);
        PRODUCT_4.setTitle("apple");
        PRODUCT_4.setPrice(85.32);
        PRODUCT_5.setTitle("crub");
        PRODUCT_5.setPrice(1500.65);

    }

    public static void initData (EntityManager em){
        initProduct(em);
    }
    private static void initProduct(EntityManager em) {
        em.getTransaction().begin();
        System.out.println("Product initialized");
        PRODUCT_1 = em.merge(PRODUCT_1);
        PRODUCT_2 = em.merge(PRODUCT_2);
        PRODUCT_3 = em.merge(PRODUCT_3);
        PRODUCT_4 = em.merge(PRODUCT_4);
        PRODUCT_5 = em.merge(PRODUCT_5);
        em.getTransaction().commit();
    }

    public static ProductinShop getProduct1() {
        return PRODUCT_1;
    }

    public static ProductinShop getProduct2() {
        return PRODUCT_2;
    }

    public static ProductinShop getProduct3() {
        return PRODUCT_3;
    }

    public static ProductinShop getProduct4() {
        return PRODUCT_4;
    }

    public static ProductinShop getProduct5() {
        return PRODUCT_5;
    }
}
