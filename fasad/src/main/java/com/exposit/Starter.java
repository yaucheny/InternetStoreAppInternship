package com.exposit;

import com.exposit.api.dao.ICustomerDao;
import com.exposit.api.dao.IProductDao;
import com.exposit.api.dao.IOrderDao;
import com.exposit.api.dao.IStoreDao;
import com.exposit.api.service.ICustomerService;
import com.exposit.api.service.IProductService;
import com.exposit.api.service.IOrderService;
import com.exposit.api.service.IStoreService;
import com.exposit.dao.CustomerDao;
import com.exposit.dao.ProductDao;
import com.exposit.dao.OrderDao;
import com.exposit.dao.StoreDao;
import com.exposit.marshelling.*;
import com.exposit.menu.MenuController;
import com.exposit.model.CategoryOne;
import com.exposit.model.CategoryThree;
import com.exposit.model.CategoryTwo;
import com.exposit.model.Product;
import com.exposit.model.utils.PriceQuantityInStore;
import com.exposit.service.CustomerService;
import com.exposit.service.ProductService;
import com.exposit.service.OrderService;
import com.exposit.service.StoreService;

import java.util.HashMap;
import java.util.Map;

public class Starter {
    private static final IStoreDao storeDao = StoreDao.getInstance();
    private static final IStoreService storeService = StoreService.getInstance();
    private static final ICustomerDao customerDao = CustomerDao.getInstance();
    private static final ICustomerService customerService = CustomerService.getInstance();
    private static final IProductDao productDao = ProductDao.getInstance();
    private static final IProductService productService = ProductService.getInstance();
    private static final IOrderDao orderDao = OrderDao.getInstance();
    private static final IOrderService orderService = OrderService.getInstance();
    public static void main(String[] args) {



//        storeService.addStore("21vek", "21vek.by", "+375293333333");
//        storeService.addStore("ozon", "ozon.ru", "+375294444444");
//        storeService.addStore("wildberries", "wildberries.ru", "+7777777");
//        storeService.addStore("lamoda", "lamoda.ru", "+8888888");
        //       System.out.println(storeDao.getAll());

//        customerService.addCustomer("Ivan", "Ivanov", "Suvorova 1 , 1", "ivanov@gmail.com");
//        customerService.addCustomer("Petr", "Petrov", "Solomovoy 2 , 2", "petrov@gmail.com");
//        customerService.addCustomer("Sidor", "Sidrov", "Kupaly 3 , 3", "sidorov@gmail.com");
//        customerService.addCustomer("Nestor", "Nesterov", "Repina 4 , 4", "nesterov@gmail.com");
//        customerService.addCustomer("Alina", "Alinova", "Gaya 5 , 5", "alinova@gmail.com");
        //       System.out.println(customerDao.getAll());

//        productService.addProduct("notebook", "sumsung", 1500, 10, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "dell", 1300, 20, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "acer", 2000, 30, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "sumsung", 1300, 30, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "dell", 2000, 20, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "acer", 1500, 10, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "sumsung", 1500, 10, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "dell", 1500, 10, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("notebook", "acer", 1900, 10, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//
//        productService.addProduct("refrigerator", "sumsung", 800, 10, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "LG", 700, 20, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "LG", 600, 30, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "sumsung", 550, 30, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "atlant", 450, 20, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "atlant", 350, 10, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "sumsung", 9500, 10, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "atlant", 850, 10, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("refrigerator", "LG", 750, 10, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//
//        productService.addProduct("TV", "sumsung", 850, 40, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "LG", 900, 20, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "LG", 1000, 30, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "sumsung", 400, 30, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "LG", 900, 30, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "LG", 800, 20, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "sumsung", 600, 30, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "LG", 500, 40, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("TV", "LG", 900, 50, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//
//        productService.addProduct("baby sling", "pampers", 15, 10, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "huggies", 13, 20, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "pampers", 20, 30, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "huggies", 13, 30, storeDao.getById(2L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "merries", 20, 20, storeDao.getById(2L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "merries", 15, 10, storeDao.getById(2L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "merries", 15, 10, storeDao.getById(4L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "huggies", 15, 10, storeDao.getById(4L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("baby sling", "huggies", 19, 10, storeDao.getById(4L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//
//        productService.addProduct("baby carriage", "Anex", 1005, 10, storeDao.getById(1L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Tako", 1003, 20, storeDao.getById(2L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Anex", 2000, 30, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Tako", 1003, 30, storeDao.getById(1L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Anex", 2000, 20, storeDao.getById(2L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Tako", 1005, 10, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Tako", 1005, 10, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Anex", 1005, 10, storeDao.getById(2L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("baby carriage", "Tako", 1009, 10, storeDao.getById(1L), CategoryOne.CHILDREN, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//
//        productService.addProduct("baby food", "buslic", 5, 100, storeDao.getById(4L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "belact", 3, 200, storeDao.getById(4L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "buslic", 2, 300, storeDao.getById(4L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "belact", 1, 300, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "buslic", 2, 200, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "belact", 1, 100, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "buslic", 5, 100, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "belact", 1, 100, storeDao.getById(4L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("baby food", "buslic", 4, 100, storeDao.getById(3L), CategoryOne.CHILDREN, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//
//        productService.addProduct("beer", "lidskoe", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "alivariya", 2, 2000, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "lidskoe", 2, 3000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "bobrov", 1, 3000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "lidskoe", 2, 2000, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "lidskoe", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "bobrov", 2, 1000, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "lidskoe", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("beer", "bobrov", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//
//        productService.addProduct("sausage", "GNK", 5, 1000, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "BMK", 3, 2000, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "GNK", 2, 3000, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "BMK", 1, 3000, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "LMK", 2, 2000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "GNK", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "LMK", 5, 1000, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "BMK", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("sausage", "GNK", 4, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//
//        productService.addProduct("vegetables", "GVV", 5, 1000, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "BVV", 3, 2000, storeDao.getById(1L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "GVV", 2, 3000, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "BVV", 1, 3000, storeDao.getById(2L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "LVV", 2, 2000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "GVV", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "LVV", 5, 1000, storeDao.getById(4L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "BVV", 1, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("vegetables", "GVV", 4, 1000, storeDao.getById(3L), CategoryOne.ADULTS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//
//
//        productService.addProduct("trimer for pet", "dog", 8, 40, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "cat", 9, 20, storeDao.getById(3L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "cat", 10, 30, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "cat", 4, 30, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "cat", 9, 30, storeDao.getById(1L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "cat", 8, 20, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "dog", 6, 30, storeDao.getById(3L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "cat", 5, 40, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//        productService.addProduct("trimer for pet", "dog", 9, 50, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.TECHNICS);
//
//        productService.addProduct("food for pet", "dog", 1, 400, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "cat", 2, 200, storeDao.getById(3L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "rat", 1, 300, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "cat", 3, 300, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "rat", 2, 300, storeDao.getById(1L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "cat", 1, 200, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "dog", 2, 300, storeDao.getById(3L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "cat", 1, 400, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//        productService.addProduct("food for pet", "rat", 3, 500, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.FOOD, CategoryThree.NUTRITION);
//
//        productService.addProduct("clothes for pet", "dog", 2, 40, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "cat", 3, 20, storeDao.getById(3L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "rat", 2, 30, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "cat", 4, 30, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "rat", 3, 30, storeDao.getById(1L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "cat", 2, 20, storeDao.getById(2L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "dog", 3, 30, storeDao.getById(3L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "cat", 2, 40, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        productService.addProduct("clothes for pet", "rat", 1, 50, storeDao.getById(4L), CategoryOne.ANIMALS, CategoryTwo.NON_FOOD, CategoryThree.CLOTHES);
//        Map<Product,Integer> map1=new HashMap<>();
//        map1.put(productDao.getById(1L),1 );
//        map1.put(productDao.getById(2L),2 );
//        map1.put(productDao.getById(10L),3 );
//
//        Map<Product,Integer> map2=new HashMap<>();
//        map2.put(productDao.getById(5L),2 );
//        map2.put(productDao.getById(50L),2 );
//        map2.put(productDao.getById(60L),3 );
//        map2.put(productDao.getById(70L),3 );
//
//        Map<Product,Integer> map3=new HashMap<>();
//        map3.put(productDao.getById(9L),2 );
//        map3.put(productDao.getById(19L),2 );
//        map3.put(productDao.getById(29L),3 );
//
//        Map<Product,Integer> map4=new HashMap<>();
//        map4.put(productDao.getById(28L),2 );
//        map4.put(productDao.getById(49L),2 );
//        map4.put(productDao.getById(101L),3 );
//
//        Map<Product,Integer> map5=new HashMap<>();
//        map5.put(productDao.getById(89L),1 );
//        map5.put(productDao.getById(69L),1 );
//        map5.put(productDao.getById(7L),1 );
//
//        orderService.addOrder(3L, customerDao.getById(1L),map1);
//        orderService.addOrder(3L, customerDao.getById(2L),map2);
//        orderService.addOrder(3L, customerDao.getById(3L),map3);
//        orderService.addOrder(3L, customerDao.getById(4L),map4);
//        orderService.addOrder(3L, customerDao.getById(5L),map5);
//        orderService.updateOrder(2L,3L, customerDao.getById(1L),map1);
//        System.out.println(orderDao.getById(1L));
//        System.out.println(productService.sortByPrice());
        //      storeService.deleteStore(1L);
//        System.out.println(goodsDao.sortByPrice());

//        for (Goods goods : goodsDao.sortByPrice()) {
//            System.out.println(goods);
//       }
//        for (PriceQuantityInStore goods : productDao.infoAboutPriceQuantityInStore("wildberries")) {
//            System.out.println(goods);
//        }
//        //       System.out.println(goodsDao.findByOneAttribute("4","goodsPrice"));
  MenuController.getInstance().run();
////        MarshallingJsonHandlerProduct.serializeProduct(productDao.getAll());
////        MarshallingJsonHandlerStore.serializeStore(storeDao.getAll());
////        MarshallingJsonHandlerCustomer.serializeCustomer(customerDao.getAll());
////        MarshallingJsonHandlerOrder.serializeOrder(orderDao.getAll());
//        UnMarshallingJsonHandlerStore.deSerializeStore();
//        UnMarshallingJsonHandlerProduct.deSerializeProduct();
//        UnMarshallingJsonHandlerCustomer.deSerializeCustomer();
 //       UnMarshallingJsonHandlerOrder.deSerializeOrder();
    }
}
