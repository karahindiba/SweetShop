package sweetshop;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.Scanner;

public class SweetShop {
private static final Logger logger = Logger.getGlobal(); 
    public static void main(String[] args) throws Exception {
        Products products = new Products();
        StringBuffer data = null;
 
        try {
            Scanner in = new Scanner(new FileReader("C:\\Users\\gavri\\Desktop\\file.txt"));
            data = new StringBuffer();
            while (in.hasNext())
                data.append(in.nextLine()).append("\n");
            System.out.println(data.toString());
        } catch (Exception ex) { 
            ex.printStackTrace();
        }finally {
            if (data.length() == 0) {
            logger.info("Ошибка чтения файла. Нет данных для обработки.");
            }
            else {
            logger.info("Файл успешно прочитан");
            }
        }
        
        String s = data.toString();
        int start = 0, end; 
        ArrayList<String> str = new ArrayList<String>(); //складываем подстроки
        String separator = "\n"; 
        do {
            end = s.indexOf(separator, start);
            if (end >= 0) {
                str.add(s.substring(start, end));
                start = end + separator.length();
            } else
                str.add(s.substring(start));
        } while (end >= 0);
        logger.info("Содержимое файла записано в строковую коллекцию");
 
 
        String[] myArray = {}; 
        myArray = str.toArray(new String[str.size()]);
        
        // Список постоянных клиентов(ключ) с их скидкой(значение)
        Map <String, Integer> vip = new HashMap <String, Integer>();
         vip.put("L.A.James", 5);
         vip.put("K.S.Kameron", 10);
         vip.put("E.J.White", 20);
 
 
        for (int j = 0; j < myArray.length; j++) {
            String[] sub1 = myArray[j].split(" ");
            for (int i = 0; i < sub1.length; i++) {
 
                if (sub1[i].equals("CAKE")) {   
                    Double i1 = Double.valueOf(sub1[i + 2]);
                    Integer i2 = Integer.valueOf(sub1[i + 3]);
                        for (String key : vip.keySet()) { //пересчет цены+скидка постоянным клиентам
                            if (sub1[i + 1].equals(key)){
                                i2 = Integer.valueOf(sub1[i + 3])- Integer.valueOf(sub1[i + 3])*vip.get(key)/100; 
                                if (i2<0) {
                                    i2=i2*(-1);
                                    logger.info("Цена не может быть отрицательной. Знак '-' был проигнорирован.");
                                }
                            }
                        }
                        products.addProduct(new Cake(sub1[i + 1], i1, i2)); 
                }
 
                if (sub1[i].equals("BISQUIT")) {   
                    Double i1 = Double.valueOf(sub1[i + 2]);
                    Integer i2 = Integer.valueOf(sub1[i + 3]);
                        for (String key : vip.keySet()) {
                            if (sub1[i + 1].equals(key)){
                                i2 = Integer.valueOf(sub1[i + 3])- Integer.valueOf(sub1[i + 3])*vip.get(key)/100; 
                                if (i2<0) {
                                    i2=i2*(-1);
                                    logger.info("Цена не может быть отрицательной. Знак '-' был проигнорирован.");
                                }
                            }
                        }
                        products.addProduct(new Bisquit(sub1[i + 1], i1, i2));
                }
 
                if (sub1[i].equals("CANDIES")) {   
                    Double i1 = Double.valueOf(sub1[i + 2]);
                    Integer i2 = Integer.valueOf(sub1[i + 3]);
                        for (String key : vip.keySet()) {
                            if (sub1[i + 1].equals(key)){
                                i2 = Integer.valueOf(sub1[i + 3]) - Integer.valueOf(sub1[i + 3])*vip.get(key)/100;
                                if (i2<0) {
                                    i2=i2*(-1);
                                    logger.info("Цена не может быть отрицательной. Знак '-' был проигнорирован.");
                                }
                            }
                        }
                    products.addProduct(new Candies(sub1[i + 1], i1, i2)); 
                }
            }
        }
        
        logger.info("Данные добавлены в массив и распределены в соответствии с полями класса productStorage.");
        System.out.println("Все заказы с учетом скидок постоянным клиентам:");   
        products.showProducts();
        System.out.println();
        
        System.out.println("Выручка за день с учетом всех скидок = " + products.getSum());
        System.out.println(); 
        
        System.out.println("Крупные заказы:");
        products.getOver3000();
        System.out.println();
        
        System.out.println("Отсортированный список:");
        products.showSorted();
        logger.info("Заказы отсортированы и записаны в соответствующие файлы на рабочем столе.");
}
}