/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sweetshop;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.List;
 
public class Products {
private static final Logger log = Logger.getLogger(Products.class.getName());
    List<ProductStorage> products = new ArrayList<ProductStorage>();
    public void addProduct(ProductStorage productStorage) {
        products.add(productStorage); 
    }
    
 
    public void showProducts() { 
        for (ProductStorage q : products) {
            System.out.println(q.toString()); // переопределить в ProductStorage
        }
    }
 
    public int getSum() {    // выручка магазина за день
        int sum = 0;
        for (ProductStorage q : products) {
            sum = sum + q.getCostWithDiscount();   // переопределить в индивидуальных классах
        }
        log.info("Цены просуммированы с учетом скидок как постоянным клиентам, так и на определенные виды изделия");
        return sum;
    }
 
    public void getOver3000() {    // крупные заказы за день
 
        for (ProductStorage q : products) {
            if (q.getCost() >= 3000) {
                System.out.println(q.toString());
            }
        }
        log.info("Изделия со стоимостью 3000 и выше определены");
    }
 
    public void showSorted() {
        System.out.println("BISQUIT:");
        for (ProductStorage q : products) {
            if (q.getType().equals("BISQUIT")) {
                try (PrintWriter out1 = new PrintWriter(
                        new FileWriter("C:\\Users\\gavri\\Desktop\\bisquits.txt",true )
                )) {
                    System.out.println(q.toString());
                    out1.println(q.toString());
                } catch  (Exception exx) { 
            exx.printStackTrace();
            log.info("Запись в файл bisquits.txt не была выполнена. Проверьте правильность указания директории.");
                }
            }
        }
 
        System.out.println("CAKE:");
        for (ProductStorage q : products) {
            if (q.getType().equals("CAKE")) {
                try (PrintWriter out2 = new PrintWriter(new FileWriter("C:\\Users\\gavri\\Desktop\\cakes.txt",true ))) {
                    System.out.println(q.toString());
                    out2.println(q.toString());
                }catch  (Exception exx) { 
            exx.printStackTrace();
            log.info("Запись в файл cakes.txt не была выполнена. Проверьте правильность указания директории.");
                }
            }
        }
 
        System.out.println("CANDIES:");
        for (ProductStorage q : products) {
            if (q.getType().equals("CANDIES")) {
                try (PrintWriter out3 = new PrintWriter(new FileWriter("C:\\Users\\gavri\\Desktop\\candies.txt",true ))) {
                    System.out.println(q.toString());
                    out3.println(q.toString());
                }catch  (Exception exx) {
            exx.printStackTrace();
            log.info("Запись в файл candies.txt не была выполнена. Проверьте правильность указания директории.");
                }
            }
        }
    log.info("Данные успешно сгруппированы");
    }
 
 
}