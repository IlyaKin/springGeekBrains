package geekbrains.lesson5.repository;

import geekbrains.lesson5.domain.ProductinShop;

import javax.persistence.EntityManager;

public class InitData {

    private static ProductinShop PRODUCT_1 = new ProductinShop();
    private static ProductinShop PRODUCT_2 = new ProductinShop();
    private static ProductinShop PRODUCT_3 = new ProductinShop();
    private static ProductinShop PRODUCT_4 = new ProductinShop();
    private static ProductinShop PRODUCT_5 = new ProductinShop();
    private static ProductinShop PRODUCT_6 = new ProductinShop();
    private static ProductinShop PRODUCT_7 = new ProductinShop();
    private static ProductinShop PRODUCT_8 = new ProductinShop();
    private static ProductinShop PRODUCT_9 = new ProductinShop();
    private static ProductinShop PRODUCT_10 = new ProductinShop();
    private static ProductinShop PRODUCT_11 = new ProductinShop();
    private static ProductinShop PRODUCT_12 = new ProductinShop();
    private static ProductinShop PRODUCT_13 = new ProductinShop();
    private static ProductinShop PRODUCT_14 = new ProductinShop();
    private static ProductinShop PRODUCT_15 = new ProductinShop();

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
        PRODUCT_6.setTitle("bread");
        PRODUCT_6.setPrice(306.0);
        PRODUCT_7.setTitle("sandwitch");
        PRODUCT_7.setPrice(65.50);
        PRODUCT_8.setTitle("water");
        PRODUCT_8.setPrice(90.30);
        PRODUCT_9.setTitle("orange");
        PRODUCT_9.setPrice(85.32);
        PRODUCT_10.setTitle("juice");
        PRODUCT_10.setPrice(1500.65);
        PRODUCT_11.setTitle("alcohole");
        PRODUCT_11.setPrice(306.0);
        PRODUCT_12.setTitle("candle");
        PRODUCT_12.setPrice(65.50);
        PRODUCT_13.setTitle("oil");
        PRODUCT_13.setPrice(90.30);
        PRODUCT_14.setTitle("limonade");
        PRODUCT_14.setPrice(85.32);
        PRODUCT_15.setTitle("vodka");
        PRODUCT_15.setPrice(1500.65);

    }

    public static void initData(EntityManager em) {
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
        PRODUCT_6 = em.merge(PRODUCT_6);
        PRODUCT_7 = em.merge(PRODUCT_7);
        PRODUCT_8 = em.merge(PRODUCT_8);
        PRODUCT_9 = em.merge(PRODUCT_9);
        PRODUCT_10 = em.merge(PRODUCT_10);
        PRODUCT_11 = em.merge(PRODUCT_11);
        PRODUCT_12 = em.merge(PRODUCT_12);
        PRODUCT_13 = em.merge(PRODUCT_13);
        PRODUCT_14 = em.merge(PRODUCT_14);
        PRODUCT_15 = em.merge(PRODUCT_15);
        em.getTransaction().commit();
    }
}