package com.exposit;

public class Starter {
//    private static final StoreService STORE_SERVICE
//            = StoreServiceImpl.getInstance();
//    private static final CustomerService CUSTOMER_SERVICE
//            = CustomerServiceImpl.getInstance();
//    private static final ProductService PRODUCT_SERVICE
//            = ProductServiceImpl.getInstance();
//    private static final OrderService ORDER_SERVICE
//            = OrderServiceImpl.getInstance();
//    private static final OrderItemService ORDER_ITEM_SERVICE
//            = OrderItemServiceImpl.getInstance();
//    private static final ShopProductService SHOP_PRODUCT_SERVICE
//            = ShopProductServiceImpl.getInstance();
//    private static final CategoryService CATEGORY_SERVICE
//            = CategoryServiceImpl.getInstance();

    public static void main(String[] args) {
//

//        STORE_SERVICE.addStore("21vek", "21vek.by",
//                "+375293333333");
//        STORE_SERVICE.addStore("ozon", "ozon.ru",
//                "+375294444444");
//        STORE_SERVICE.addStore("wildberries", "wildberries.ru",
//                "+7777777");
//        STORE_SERVICE.addStore("lamoda", "lamoda.ru",
//                "+8888888");

//
//        CUSTOMER_SERVICE.addCustomer("Ivan", "Ivanov",
//                "Suvorova 1 , 1", "ivanov@gmail.com");
//        CUSTOMER_SERVICE.addCustomer("Petr", "Petrov",
//                "Solomovoy 2 , 2", "petrov@gmail.com");
//        CUSTOMER_SERVICE.addCustomer("Sidor", "Sidrov",
//                "Kupaly 3 , 3", "sidorov@gmail.com");
//        CUSTOMER_SERVICE.addCustomer("Nestor", "Nesterov",
//                "Repina 4 , 4", "nesterov@gmail.com");
//        CUSTOMER_SERVICE.addCustomer("Alina", "Alinova",
//                "Gaya 5 , 5", "alinova@gmail.com");
//        System.out.println(CUSTOMER_SERVICE.getAllCustomer());
//        System.out.println(STORE_SERVICE.getAllStore());

//        CATEGORY_SERVICE.addCategory("industrial", null); //1
//        CATEGORY_SERVICE.addCategory("nutrition", null);  //2
//
//        CATEGORY_SERVICE.addCategory("technics", CATEGORY_SERVICE.getCategoryById(1L)); //3
//        CATEGORY_SERVICE.addCategory("clothes", CATEGORY_SERVICE.getCategoryById(1L));  //4
//        CATEGORY_SERVICE.addCategory("toys", CATEGORY_SERVICE.getCategoryById(1L));     //5
//        CATEGORY_SERVICE.addCategory("animal_feed", CATEGORY_SERVICE.getCategoryById(2L));//6
//        CATEGORY_SERVICE.addCategory("baby_food", CATEGORY_SERVICE.getCategoryById(2L));   //7
//        CATEGORY_SERVICE.addCategory("food", CATEGORY_SERVICE.getCategoryById(2L));        //8
//        CATEGORY_SERVICE.addCategory("drinks", CATEGORY_SERVICE.getCategoryById(2L));      //9
//
//        CATEGORY_SERVICE.addCategory("type_of_control", CATEGORY_SERVICE.getCategoryById(3L));      //10
//        CATEGORY_SERVICE.addCategory("installation_type", CATEGORY_SERVICE.getCategoryById(3L));      //11
//        CATEGORY_SERVICE.addCategory("dimensions", CATEGORY_SERVICE.getCategoryById(3L));      //12
//
//        CATEGORY_SERVICE.addCategory("age_clothes", CATEGORY_SERVICE.getCategoryById(4L));      //13
//        CATEGORY_SERVICE.addCategory("season", CATEGORY_SERVICE.getCategoryById(4L));      //14
//        CATEGORY_SERVICE.addCategory("class_of_price", CATEGORY_SERVICE.getCategoryById(4L));      //15
//
//        CATEGORY_SERVICE.addCategory("age_toys", CATEGORY_SERVICE.getCategoryById(5L));      //16
//        CATEGORY_SERVICE.addCategory("material", CATEGORY_SERVICE.getCategoryById(5L));      //17
//        CATEGORY_SERVICE.addCategory("development", CATEGORY_SERVICE.getCategoryById(5L));   //18
//
//        CATEGORY_SERVICE.addCategory("type_of_meat", CATEGORY_SERVICE.getCategoryById(6L));   //19
//        CATEGORY_SERVICE.addCategory("type_of_animal", CATEGORY_SERVICE.getCategoryById(6L));   //20
//        CATEGORY_SERVICE.addCategory("age_of_animal", CATEGORY_SERVICE.getCategoryById(6L));   //21
//
//        CATEGORY_SERVICE.addCategory("type_of_mix", CATEGORY_SERVICE.getCategoryById(7L));   //22
//        CATEGORY_SERVICE.addCategory("type_of_instant", CATEGORY_SERVICE.getCategoryById(7L));   //23
//        CATEGORY_SERVICE.addCategory("age_in_month", CATEGORY_SERVICE.getCategoryById(7L));   //24
//
//        CATEGORY_SERVICE.addCategory("age_food", CATEGORY_SERVICE.getCategoryById(8L));   //25
//        CATEGORY_SERVICE.addCategory("health_or_not", CATEGORY_SERVICE.getCategoryById(8L));   //26
//        CATEGORY_SERVICE.addCategory("frozen_or_not", CATEGORY_SERVICE.getCategoryById(8L));   //27
//
//        CATEGORY_SERVICE.addCategory("type_alcohol", CATEGORY_SERVICE.getCategoryById(9L));   //28
//        CATEGORY_SERVICE.addCategory("volume", CATEGORY_SERVICE.getCategoryById(9L));   //29
//        CATEGORY_SERVICE.addCategory("made_in", CATEGORY_SERVICE.getCategoryById(9L));   //30
//
////----------------
//        CATEGORY_SERVICE.addCategory("build_in", CATEGORY_SERVICE.getCategoryById(10L));   //31
//        CATEGORY_SERVICE.addCategory("free_standing", CATEGORY_SERVICE.getCategoryById(10L));   //32
//
//        CATEGORY_SERVICE.addCategory("sensor", CATEGORY_SERVICE.getCategoryById(11L));   //33
//        CATEGORY_SERVICE.addCategory("button", CATEGORY_SERVICE.getCategoryById(11L));   //34
//
//        CATEGORY_SERVICE.addCategory("small", CATEGORY_SERVICE.getCategoryById(12L));   //35
//        CATEGORY_SERVICE.addCategory("big", CATEGORY_SERVICE.getCategoryById(12L));   //36
//
//        //------------
//        CATEGORY_SERVICE.addCategory("children", CATEGORY_SERVICE.getCategoryById(13L));   //37
//        CATEGORY_SERVICE.addCategory("adult", CATEGORY_SERVICE.getCategoryById(13L));   //38
//        CATEGORY_SERVICE.addCategory("animal", CATEGORY_SERVICE.getCategoryById(13L));   //39
//
//        CATEGORY_SERVICE.addCategory("summer", CATEGORY_SERVICE.getCategoryById(14L));   //40
//        CATEGORY_SERVICE.addCategory("winter", CATEGORY_SERVICE.getCategoryById(14L));   //41
//        CATEGORY_SERVICE.addCategory("demi", CATEGORY_SERVICE.getCategoryById(14L));   //42
//
//        CATEGORY_SERVICE.addCategory("premium", CATEGORY_SERVICE.getCategoryById(15L));   //43
//        CATEGORY_SERVICE.addCategory("low_cost", CATEGORY_SERVICE.getCategoryById(15L));   //44
//        //-----------
//        CATEGORY_SERVICE.addCategory("children", CATEGORY_SERVICE.getCategoryById(16L));   //45
//        CATEGORY_SERVICE.addCategory("animal", CATEGORY_SERVICE.getCategoryById(16L));   //46
//
//        CATEGORY_SERVICE.addCategory("wood", CATEGORY_SERVICE.getCategoryById(17L));   //47
//        CATEGORY_SERVICE.addCategory("plastic", CATEGORY_SERVICE.getCategoryById(17L));   //48
//
//        CATEGORY_SERVICE.addCategory("develop", CATEGORY_SERVICE.getCategoryById(18L));   //49
//        CATEGORY_SERVICE.addCategory("not_develop", CATEGORY_SERVICE.getCategoryById(18L));   //50
//        //-----------
//        CATEGORY_SERVICE.addCategory("pig", CATEGORY_SERVICE.getCategoryById(19L));   //51
//        CATEGORY_SERVICE.addCategory("chicken", CATEGORY_SERVICE.getCategoryById(19L));   //52
//
//        CATEGORY_SERVICE.addCategory("dog", CATEGORY_SERVICE.getCategoryById(20L));   //53
//        CATEGORY_SERVICE.addCategory("cat", CATEGORY_SERVICE.getCategoryById(20L));   //54
//
//        CATEGORY_SERVICE.addCategory("young", CATEGORY_SERVICE.getCategoryById(21L));   //55
//        CATEGORY_SERVICE.addCategory("old", CATEGORY_SERVICE.getCategoryById(21L));   //56
//        //--------
//        CATEGORY_SERVICE.addCategory("milk", CATEGORY_SERVICE.getCategoryById(22L));   //57
//        CATEGORY_SERVICE.addCategory("not_milk", CATEGORY_SERVICE.getCategoryById(22L));   //58
//
//        CATEGORY_SERVICE.addCategory("instant", CATEGORY_SERVICE.getCategoryById(23L));   //59
//        CATEGORY_SERVICE.addCategory("not_instant", CATEGORY_SERVICE.getCategoryById(23L));   //60
//
//        CATEGORY_SERVICE.addCategory("before_year", CATEGORY_SERVICE.getCategoryById(24L));   //61
//        CATEGORY_SERVICE.addCategory("after_year", CATEGORY_SERVICE.getCategoryById(24L));   //62
//        //--------
//        CATEGORY_SERVICE.addCategory("food_child", CATEGORY_SERVICE.getCategoryById(25L));   //63
//        CATEGORY_SERVICE.addCategory("food_adult", CATEGORY_SERVICE.getCategoryById(25L));   //64
//
//        CATEGORY_SERVICE.addCategory("sport_food", CATEGORY_SERVICE.getCategoryById(26L));   //65
//        CATEGORY_SERVICE.addCategory("not_sport_food", CATEGORY_SERVICE.getCategoryById(26L));   //66
//
//        CATEGORY_SERVICE.addCategory("frozen", CATEGORY_SERVICE.getCategoryById(27L));   //67
//        CATEGORY_SERVICE.addCategory("not_frozen", CATEGORY_SERVICE.getCategoryById(27L));   //68
//        //--------
//        CATEGORY_SERVICE.addCategory("alcohol", CATEGORY_SERVICE.getCategoryById(28L));   //69
//        CATEGORY_SERVICE.addCategory("alcohol_free", CATEGORY_SERVICE.getCategoryById(28L));   //70
//
//        CATEGORY_SERVICE.addCategory("made_in", CATEGORY_SERVICE.getCategoryById(29L));   //71
//        CATEGORY_SERVICE.addCategory("made_out", CATEGORY_SERVICE.getCategoryById(29L));   //72
//
//        CATEGORY_SERVICE.addCategory("less_litre", CATEGORY_SERVICE.getCategoryById(30L));   //73
//        CATEGORY_SERVICE.addCategory("more_litre", CATEGORY_SERVICE.getCategoryById(30L));   //74



//        CATEGORY_SERVICE.addCategory("industrial", null); //1
//        CATEGORY_SERVICE.addCategory("nutrition", null);  //2
//
//        CATEGORY_SERVICE.addCategory("technics", 1L); //3
//        CATEGORY_SERVICE.addCategory("clothes", 1L);  //4
//        CATEGORY_SERVICE.addCategory("toys", 1L);     //5
//        CATEGORY_SERVICE.addCategory("animal_feed", 2L);//6
//        CATEGORY_SERVICE.addCategory("baby_food",2L);   //7
//        CATEGORY_SERVICE.addCategory("food", 2L);        //8
//        CATEGORY_SERVICE.addCategory("drinks", 2L);      //9
//
//        CATEGORY_SERVICE.addCategory("type_of_control", 3L);      //10
//        CATEGORY_SERVICE.addCategory("installation_type", 3L);      //11
//        CATEGORY_SERVICE.addCategory("dimensions", 3L);      //12
//
//        CATEGORY_SERVICE.addCategory("age_clothes", 4L);      //13
//        CATEGORY_SERVICE.addCategory("season", 4L);      //14
//        CATEGORY_SERVICE.addCategory("class_of_price", 4L);      //15
//
//        CATEGORY_SERVICE.addCategory("age_toys", 5L);      //16
//        CATEGORY_SERVICE.addCategory("material", 5L);      //17
//        CATEGORY_SERVICE.addCategory("development", 5L);   //18
//
//        CATEGORY_SERVICE.addCategory("type_of_meat", 6L);   //19
//        CATEGORY_SERVICE.addCategory("type_of_animal", 6L);   //20
//        CATEGORY_SERVICE.addCategory("age_of_animal", 6L);   //21
//
//        CATEGORY_SERVICE.addCategory("type_of_mix", 7L);   //22
//        CATEGORY_SERVICE.addCategory("type_of_instant", 7L);   //23
//        CATEGORY_SERVICE.addCategory("age_in_month", 7L);   //24
//
//        CATEGORY_SERVICE.addCategory("age_food", 8L);   //25
//        CATEGORY_SERVICE.addCategory("health_or_not", 8L);   //26
//        CATEGORY_SERVICE.addCategory("frozen_or_not", 8L);   //27
//
//        CATEGORY_SERVICE.addCategory("type_alcohol", 9L);   //28
//        CATEGORY_SERVICE.addCategory("volume", 9L);   //29
//        CATEGORY_SERVICE.addCategory("made_in", 9L);   //30
//
////----------------
//        CATEGORY_SERVICE.addCategory("build_in", 10L);   //31
//        CATEGORY_SERVICE.addCategory("free_standing", 10L);   //32
//
//        CATEGORY_SERVICE.addCategory("sensor", 11L);   //33
//        CATEGORY_SERVICE.addCategory("button", 11L);   //34
//
//        CATEGORY_SERVICE.addCategory("small", 12L);   //35
//        CATEGORY_SERVICE.addCategory("big", 12L);   //36
//
//        //------------
//        CATEGORY_SERVICE.addCategory("children", 13L);   //37
//        CATEGORY_SERVICE.addCategory("adult", 13L);   //38
//        CATEGORY_SERVICE.addCategory("animal", 13L);   //39
//
//        CATEGORY_SERVICE.addCategory("summer", 14L);   //40
//        CATEGORY_SERVICE.addCategory("winter", 14L);   //41
//        CATEGORY_SERVICE.addCategory("demi", 14L);   //42
//
//        CATEGORY_SERVICE.addCategory("premium", 15L);   //43
//        CATEGORY_SERVICE.addCategory("low_cost", 15L);   //44
//        //-----------
//        CATEGORY_SERVICE.addCategory("children", 16L);   //45
//        CATEGORY_SERVICE.addCategory("animal", 16L);   //46
//
//        CATEGORY_SERVICE.addCategory("wood", 17L);   //47
//        CATEGORY_SERVICE.addCategory("plastic", 17L);   //48
//
//        CATEGORY_SERVICE.addCategory("develop", 18L);   //49
//        CATEGORY_SERVICE.addCategory("not_develop", 18L);   //50
//        //-----------
//        CATEGORY_SERVICE.addCategory("pig", 19L);   //51
//        CATEGORY_SERVICE.addCategory("chicken", 19L);   //52
//
//        CATEGORY_SERVICE.addCategory("dog", 20L);   //53
//        CATEGORY_SERVICE.addCategory("cat", 20L);   //54
//
//        CATEGORY_SERVICE.addCategory("young", 21L);   //55
//        CATEGORY_SERVICE.addCategory("old", 21L);   //56
//        //--------
//        CATEGORY_SERVICE.addCategory("milk", 22L);   //57
//        CATEGORY_SERVICE.addCategory("not_milk", 22L);   //58
//
//        CATEGORY_SERVICE.addCategory("instant", 23L);   //59
//        CATEGORY_SERVICE.addCategory("not_instant", 23L);   //60
//
//        CATEGORY_SERVICE.addCategory("before_year", 24L);   //61
//        CATEGORY_SERVICE.addCategory("after_year", 24L);   //62
//        //--------
//        CATEGORY_SERVICE.addCategory("food_child", 25L);   //63
//        CATEGORY_SERVICE.addCategory("food_adult", 25L);   //64
//
//        CATEGORY_SERVICE.addCategory("sport_food", 26L);   //65
//        CATEGORY_SERVICE.addCategory("not_sport_food", 26L);   //66
//
//        CATEGORY_SERVICE.addCategory("frozen", 27L);   //67
//        CATEGORY_SERVICE.addCategory("not_frozen", 27L);   //68
//        //--------
//        CATEGORY_SERVICE.addCategory("alcohol", 28L);   //69
//        CATEGORY_SERVICE.addCategory("alcohol_free", 28L);   //70
//
//        CATEGORY_SERVICE.addCategory("made_in", 29L);   //71
//        CATEGORY_SERVICE.addCategory("made_out", 29L);   //72
//
//        CATEGORY_SERVICE.addCategory("less_litre", 30L);   //73
//        CATEGORY_SERVICE.addCategory("more_litre", 30L);   //74
//        for (CategoryEntity category : CATEGORY_SERVICE.getAllCategory()) {
//            System.out.println(category);
//        }
//
//        List<CategoryEntity> list1 = List.of(CATEGORY_SERVICE.getCategoryById(33L), CATEGORY_SERVICE.getCategoryById(35L));
//        List<CategoryEntity> list2 = List.of(CATEGORY_SERVICE.getCategoryById(34L), CATEGORY_SERVICE.getCategoryById(35L));
//        PRODUCT_SERVICE.addProduct("telephone", "lg", list1);
//        PRODUCT_SERVICE.addProduct("telephone", "apple", list2);
//        List<CategoryEntity> list3 = List.of(CATEGORY_SERVICE.getCategoryById(31L), CATEGORY_SERVICE.getCategoryById(33L), CATEGORY_SERVICE.getCategoryById(36L));
//        List<CategoryEntity> list4 = List.of(CATEGORY_SERVICE.getCategoryById(32L), CATEGORY_SERVICE.getCategoryById(34L), CATEGORY_SERVICE.getCategoryById(36L));
//        PRODUCT_SERVICE.addProduct("washer", "lg", list3);
//        PRODUCT_SERVICE.addProduct("washer", "bosch", list4);
//        List<CategoryEntity> list5 = List.of(CATEGORY_SERVICE.getCategoryById(31L), CATEGORY_SERVICE.getCategoryById(33L), CATEGORY_SERVICE.getCategoryById(36L));
//        List<CategoryEntity> list6 = List.of(CATEGORY_SERVICE.getCategoryById(32L), CATEGORY_SERVICE.getCategoryById(34L), CATEGORY_SERVICE.getCategoryById(36L));
//        PRODUCT_SERVICE.addProduct("refrigerator", "lg", list5);
//        PRODUCT_SERVICE.addProduct("refrigerator", "bosch", list6);
//        List<CategoryEntity> list7 = List.of(CATEGORY_SERVICE.getCategoryById(31L), CATEGORY_SERVICE.getCategoryById(34L), CATEGORY_SERVICE.getCategoryById(35L));
//        List<CategoryEntity> list8 = List.of(CATEGORY_SERVICE.getCategoryById(32L), CATEGORY_SERVICE.getCategoryById(33L), CATEGORY_SERVICE.getCategoryById(35L));
//        PRODUCT_SERVICE.addProduct("dishwasher", "bosch", list7);
//        PRODUCT_SERVICE.addProduct("dishwasher", "bosch", list8);
//        // -------
//        List<CategoryEntity> list9 = List.of(CATEGORY_SERVICE.getCategoryById(38L), CATEGORY_SERVICE.getCategoryById(42L), CATEGORY_SERVICE.getCategoryById(43L));
//        List<CategoryEntity> list10 = List.of(CATEGORY_SERVICE.getCategoryById(38L), CATEGORY_SERVICE.getCategoryById(41L), CATEGORY_SERVICE.getCategoryById(44L));
//        PRODUCT_SERVICE.addProduct("jacket", "zara", list9);
//        PRODUCT_SERVICE.addProduct("jacket", "hm", list10);
//        List<CategoryEntity> list11 = List.of(CATEGORY_SERVICE.getCategoryById(37L), CATEGORY_SERVICE.getCategoryById(40L), CATEGORY_SERVICE.getCategoryById(43L));
//        List<CategoryEntity> list12 = List.of(CATEGORY_SERVICE.getCategoryById(38L), CATEGORY_SERVICE.getCategoryById(40L), CATEGORY_SERVICE.getCategoryById(44L));
//        PRODUCT_SERVICE.addProduct("shirt", "zara", list11);
//        PRODUCT_SERVICE.addProduct("shirt", "zara", list12);
//        List<CategoryEntity> list13 = List.of(CATEGORY_SERVICE.getCategoryById(38L), CATEGORY_SERVICE.getCategoryById(42L), CATEGORY_SERVICE.getCategoryById(43L));
//        List<CategoryEntity> list14 = List.of(CATEGORY_SERVICE.getCategoryById(39L), CATEGORY_SERVICE.getCategoryById(42L), CATEGORY_SERVICE.getCategoryById(44L));
//        PRODUCT_SERVICE.addProduct("trousers", "collins", list13);
//        PRODUCT_SERVICE.addProduct("trousers", "collins", list14);
//        List<CategoryEntity> list15 = List.of(CATEGORY_SERVICE.getCategoryById(37L), CATEGORY_SERVICE.getCategoryById(40L), CATEGORY_SERVICE.getCategoryById(43L));
//        List<CategoryEntity> list16 = List.of(CATEGORY_SERVICE.getCategoryById(37L), CATEGORY_SERVICE.getCategoryById(40L), CATEGORY_SERVICE.getCategoryById(44L));
//        PRODUCT_SERVICE.addProduct("shorts", "hm", list15);
//        PRODUCT_SERVICE.addProduct("shorts", "hm", list16);
//        // -------
//        List<CategoryEntity> list17 = List.of(CATEGORY_SERVICE.getCategoryById(45L), CATEGORY_SERVICE.getCategoryById(47L), CATEGORY_SERVICE.getCategoryById(49L));
//        List<CategoryEntity> list18 = List.of(CATEGORY_SERVICE.getCategoryById(45L), CATEGORY_SERVICE.getCategoryById(48L), CATEGORY_SERVICE.getCategoryById(50L));
//        PRODUCT_SERVICE.addProduct("cubes", "play", list17);
//        PRODUCT_SERVICE.addProduct("cubes", "play", list18);
//        List<CategoryEntity> list19 = List.of(CATEGORY_SERVICE.getCategoryById(45L), CATEGORY_SERVICE.getCategoryById(48L), CATEGORY_SERVICE.getCategoryById(49L));
//        List<CategoryEntity> list20 = List.of(CATEGORY_SERVICE.getCategoryById(45L), CATEGORY_SERVICE.getCategoryById(48L), CATEGORY_SERVICE.getCategoryById(50L));
//        PRODUCT_SERVICE.addProduct("car", "child", list19);
//        PRODUCT_SERVICE.addProduct("car", "play", list20);
//        List<CategoryEntity> list21 = List.of(CATEGORY_SERVICE.getCategoryById(45L), CATEGORY_SERVICE.getCategoryById(47L), CATEGORY_SERVICE.getCategoryById(49L));
//        List<CategoryEntity> list22 = List.of(CATEGORY_SERVICE.getCategoryById(45L), CATEGORY_SERVICE.getCategoryById(48L), CATEGORY_SERVICE.getCategoryById(49L));
//        PRODUCT_SERVICE.addProduct("constructor", "grai", list21);
//        PRODUCT_SERVICE.addProduct("constructor", "grai", list22);
//        List<CategoryEntity> list23 = List.of(CATEGORY_SERVICE.getCategoryById(46L), CATEGORY_SERVICE.getCategoryById(47L), CATEGORY_SERVICE.getCategoryById(50L));
//        List<CategoryEntity> list24 = List.of(CATEGORY_SERVICE.getCategoryById(46L), CATEGORY_SERVICE.getCategoryById(48L), CATEGORY_SERVICE.getCategoryById(50L));
//        PRODUCT_SERVICE.addProduct("bone", "grai", list23);
//        PRODUCT_SERVICE.addProduct("bone", "child", list24);
//        //-------
//        List<CategoryEntity> list25 = List.of(CATEGORY_SERVICE.getCategoryById(51L), CATEGORY_SERVICE.getCategoryById(53L), CATEGORY_SERVICE.getCategoryById(56L));
//        List<CategoryEntity> list26 = List.of(CATEGORY_SERVICE.getCategoryById(52L), CATEGORY_SERVICE.getCategoryById(54L), CATEGORY_SERVICE.getCategoryById(56L));
//        PRODUCT_SERVICE.addProduct("canned_food", "animal", list25);
//        PRODUCT_SERVICE.addProduct("canned_food", "pet", list26);
//        List<CategoryEntity> list27 = List.of(CATEGORY_SERVICE.getCategoryById(51L), CATEGORY_SERVICE.getCategoryById(53L), CATEGORY_SERVICE.getCategoryById(55L));
//        List<CategoryEntity> list28 = List.of(CATEGORY_SERVICE.getCategoryById(52L), CATEGORY_SERVICE.getCategoryById(54L), CATEGORY_SERVICE.getCategoryById(55L));
//        PRODUCT_SERVICE.addProduct("dry_food", "vet", list27);
//        PRODUCT_SERVICE.addProduct("dry_food", "vet", list28);
//        List<CategoryEntity> list29 = List.of(CATEGORY_SERVICE.getCategoryById(52L), CATEGORY_SERVICE.getCategoryById(53L), CATEGORY_SERVICE.getCategoryById(56L));
//        List<CategoryEntity> list30 = List.of(CATEGORY_SERVICE.getCategoryById(52L), CATEGORY_SERVICE.getCategoryById(53L), CATEGORY_SERVICE.getCategoryById(55L));
//        PRODUCT_SERVICE.addProduct("bones", "pet", list29);
//        PRODUCT_SERVICE.addProduct("bones", "pet", list30);
//        //  -------
//        List<CategoryEntity> list31 = List.of(CATEGORY_SERVICE.getCategoryById(57L), CATEGORY_SERVICE.getCategoryById(59L), CATEGORY_SERVICE.getCategoryById(61L));
//        List<CategoryEntity> list32 = List.of(CATEGORY_SERVICE.getCategoryById(57L), CATEGORY_SERVICE.getCategoryById(59L), CATEGORY_SERVICE.getCategoryById(62L));
//        PRODUCT_SERVICE.addProduct("baby_mix", "baby", list31);
//        PRODUCT_SERVICE.addProduct("baby_mix", "bany", list32);
//        List<CategoryEntity> list33 = List.of(CATEGORY_SERVICE.getCategoryById(58L), CATEGORY_SERVICE.getCategoryById(60L), CATEGORY_SERVICE.getCategoryById(61L));
//        List<CategoryEntity> list34 = List.of(CATEGORY_SERVICE.getCategoryById(58L), CATEGORY_SERVICE.getCategoryById(60L), CATEGORY_SERVICE.getCategoryById(62L));
//        PRODUCT_SERVICE.addProduct("canned_food", "mmk", list33);
//        PRODUCT_SERVICE.addProduct("canned_food", "mmk", list34);
//        List<CategoryEntity> list35 = List.of(CATEGORY_SERVICE.getCategoryById(57L), CATEGORY_SERVICE.getCategoryById(60L), CATEGORY_SERVICE.getCategoryById(61L));
//        List<CategoryEntity> list36 = List.of(CATEGORY_SERVICE.getCategoryById(58L), CATEGORY_SERVICE.getCategoryById(60L), CATEGORY_SERVICE.getCategoryById(62L));
//        PRODUCT_SERVICE.addProduct("puree", "baby", list35);
//        PRODUCT_SERVICE.addProduct("puree", "baby", list36);
//        List<CategoryEntity> list37 = List.of(CATEGORY_SERVICE.getCategoryById(57L), CATEGORY_SERVICE.getCategoryById(59L), CATEGORY_SERVICE.getCategoryById(61L));
//        List<CategoryEntity> list38 = List.of(CATEGORY_SERVICE.getCategoryById(58L), CATEGORY_SERVICE.getCategoryById(60L), CATEGORY_SERVICE.getCategoryById(62L));
//        PRODUCT_SERVICE.addProduct("cookies", "spartak", list37);
//        PRODUCT_SERVICE.addProduct("cookies", "spartak", list38);
//        // -------
//        List<CategoryEntity> list39 = List.of(CATEGORY_SERVICE.getCategoryById(64L), CATEGORY_SERVICE.getCategoryById(66L), CATEGORY_SERVICE.getCategoryById(67L));
//        List<CategoryEntity> list40 = List.of(CATEGORY_SERVICE.getCategoryById(64L), CATEGORY_SERVICE.getCategoryById(65L), CATEGORY_SERVICE.getCategoryById(67L));
//        PRODUCT_SERVICE.addProduct("dumplings", "bela", list39);
//        PRODUCT_SERVICE.addProduct("dumplings", "bela", list40);
//        List<CategoryEntity> list41 = List.of(CATEGORY_SERVICE.getCategoryById(63L), CATEGORY_SERVICE.getCategoryById(65L), CATEGORY_SERVICE.getCategoryById(68L));
//        List<CategoryEntity> list42 = List.of(CATEGORY_SERVICE.getCategoryById(64L), CATEGORY_SERVICE.getCategoryById(65L), CATEGORY_SERVICE.getCategoryById(68L));
//        PRODUCT_SERVICE.addProduct("crispbread", "mmk", list41);
//        PRODUCT_SERVICE.addProduct("crispbread", "mmk", list42);
//        List<CategoryEntity> list43 = List.of(CATEGORY_SERVICE.getCategoryById(63L), CATEGORY_SERVICE.getCategoryById(66L), CATEGORY_SERVICE.getCategoryById(68L));
//        List<CategoryEntity> list44 = List.of(CATEGORY_SERVICE.getCategoryById(64L), CATEGORY_SERVICE.getCategoryById(65L), CATEGORY_SERVICE.getCategoryById(68L));
//        PRODUCT_SERVICE.addProduct("cheese", "mmk", list43);
//        PRODUCT_SERVICE.addProduct("cheese", "mmk", list44);
//        List<CategoryEntity> list45 = List.of(CATEGORY_SERVICE.getCategoryById(64L), CATEGORY_SERVICE.getCategoryById(66L), CATEGORY_SERVICE.getCategoryById(67L));
//        List<CategoryEntity> list46 = List.of(CATEGORY_SERVICE.getCategoryById(64L), CATEGORY_SERVICE.getCategoryById(66L), CATEGORY_SERVICE.getCategoryById(68L));
//        PRODUCT_SERVICE.addProduct("hot_dog", "mmk", list45);
//        PRODUCT_SERVICE.addProduct("hot_dog", "bela", list46);
//        //  -------
//        List<CategoryEntity> list47 = List.of(CATEGORY_SERVICE.getCategoryById(69L), CATEGORY_SERVICE.getCategoryById(70L), CATEGORY_SERVICE.getCategoryById(74L));
//        List<CategoryEntity> list48 = List.of(CATEGORY_SERVICE.getCategoryById(69L), CATEGORY_SERVICE.getCategoryById(72L), CATEGORY_SERVICE.getCategoryById(73L));
//        PRODUCT_SERVICE.addProduct("beer", "goot", list47);
//        PRODUCT_SERVICE.addProduct("beer", "goot", list48);
//        List<CategoryEntity> list49 = List.of(CATEGORY_SERVICE.getCategoryById(69L), CATEGORY_SERVICE.getCategoryById(71L), CATEGORY_SERVICE.getCategoryById(74L));
//        List<CategoryEntity> list50 = List.of(CATEGORY_SERVICE.getCategoryById(70L), CATEGORY_SERVICE.getCategoryById(72L), CATEGORY_SERVICE.getCategoryById(73L));
//        PRODUCT_SERVICE.addProduct("cocktail", "mmk", list49);
//        PRODUCT_SERVICE.addProduct("cocktail", "mmk", list50);
//        List<CategoryEntity> list51 = List.of(CATEGORY_SERVICE.getCategoryById(70L), CATEGORY_SERVICE.getCategoryById(71L), CATEGORY_SERVICE.getCategoryById(74L));
//        List<CategoryEntity> list52 = List.of(CATEGORY_SERVICE.getCategoryById(70L), CATEGORY_SERVICE.getCategoryById(72L), CATEGORY_SERVICE.getCategoryById(73L));
//        PRODUCT_SERVICE.addProduct("water", "aliv", list51);
//        PRODUCT_SERVICE.addProduct("water", "aliv", list52);
//        List<CategoryEntity> list53 = List.of(CATEGORY_SERVICE.getCategoryById(69L), CATEGORY_SERVICE.getCategoryById(71L), CATEGORY_SERVICE.getCategoryById(74L));
//        List<CategoryEntity> list54 = List.of(CATEGORY_SERVICE.getCategoryById(69L), CATEGORY_SERVICE.getCategoryById(72L), CATEGORY_SERVICE.getCategoryById(73L));
//        PRODUCT_SERVICE.addProduct("vodka", "mmk", list53);
//        PRODUCT_SERVICE.addProduct("vodka", "goot", list54);
//        for (ProductEntity product : PRODUCT_SERVICE.getAllProducts()) {
//            System.out.println(product);
//        }
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(1L), 250, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(1L), 300, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(2L), 350, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(2L), 450, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(3L), 1050, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(3L), 750, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(4L), 850, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(4L), 950, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(5L), 1150, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(5L), 1250, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(6L), 1050, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(6L), 1600, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(7L), 1000, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(7L), 1050, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(8L), 950, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(8L), 960, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(9L), 150, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(9L), 250, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(10L), 350, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(10L), 450, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(11L), 50, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(11L), 60, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(12L), 70, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(12L), 55, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(13L), 150, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(13L), 140, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(14L), 130, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(14L), 120, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(15L), 50, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(15L), 100, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(16L), 90, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(16L), 80, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(17L), 10, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(17L), 50, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(18L), 20, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(18L), 25, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(19L), 250, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(19L), 200, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(20L), 20, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(20L), 150, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(21L), 250, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(21L), 200, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(22L), 150, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(22L), 200, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(23L), 20, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(23L), 10, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(24L), 15, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(24L), 16, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(25L), 1, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(25L), 2, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(26L), 3, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(26L), 4, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(27L), 4, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(27L), 3, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(28L), 2, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(28L), 1, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(29L), 1, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(29L), 2, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(30L), 2, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(30L), 1, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(31L), 7, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(31L), 6, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(32L), 8, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(32L), 9, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(33L), 3, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(33L), 2, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(34L), 4, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(34L), 5, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(35L), 1, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(35L), 2, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(36L), 2, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(36L), 1, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(37L), 5, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(37L), 4, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(38L), 3, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(38L), 2, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(39L), 1, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(39L), 5, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(40L), 4, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(40L), 5, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(41L), 4, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(41L), 1, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(42L), 2, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(42L), 3, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(43L), 4, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(43L), 5, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(44L), 2, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(44L), 1, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(45L), 1, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(45L), 2, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(46L), 2, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(46L), 2, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(47L), 1, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(47L), 1, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(48L), 1, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(48L), 2, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(49L), 3, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(49L), 4, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(50L), 1, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(50L), 2, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(51L), 3, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(51L), 1, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(52L), 1, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(52L), 2, 5, STORE_SERVICE.getStoreById(4L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(53L), 10, 5, STORE_SERVICE.getStoreById(1L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(53L), 15, 5, STORE_SERVICE.getStoreById(2L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(54L), 11, 5, STORE_SERVICE.getStoreById(3L), "none");
//        SHOP_PRODUCT_SERVICE.addShopProduct(PRODUCT_SERVICE.getProductById(54L), 12, 5, STORE_SERVICE.getStoreById(4L), "none");
//        for (ShopProductEntity shopProduct : SHOP_PRODUCT_SERVICE.getAllShopProduct()) {
//            System.out.println(shopProduct);
//        }
//
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(1L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(2L), 2);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(3L), 3);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(11L), 3);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(12L), 2);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(13L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(21L), 4);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(22L), 5);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(23L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(31L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(32L), 2);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(33L), 3);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(41L), 4);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(42L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(43L), 2);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(51L), 3);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(52L), 4);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(53L), 5);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(61L), 4);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(62L), 3);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(63L), 2);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(71L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(72L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(73L), 2);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(81L), 3);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(82L), 4);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(83L), 3);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(91L), 2);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(92L), 1);
//        ORDER_ITEM_SERVICE.addOrderItem(SHOP_PRODUCT_SERVICE.getShopProductById(93L), 5);
//        for (OrderItemEntity orderItem : ORDER_ITEM_SERVICE.getAllOrderItem()) {
//            System.out.println(orderItem);
//        }
//        List<OrderItemEntity> listOrder1 = List.of(ORDER_ITEM_SERVICE.getOrderItemById(1L),
//                ORDER_ITEM_SERVICE.getOrderItemById(4L), ORDER_ITEM_SERVICE.getOrderItemById(8L),
//                ORDER_ITEM_SERVICE.getOrderItemById(12L), ORDER_ITEM_SERVICE.getOrderItemById(16L),
//                ORDER_ITEM_SERVICE.getOrderItemById(20L), ORDER_ITEM_SERVICE.getOrderItemById(24L),
//                ORDER_ITEM_SERVICE.getOrderItemById(28L));
//        ORDER_SERVICE.addOrder(1L, CUSTOMER_SERVICE.getCustomerById(1L), listOrder1);
//
//        List<OrderItemEntity> listOrder2 = List.of(ORDER_ITEM_SERVICE.getOrderItemById(2L),
//                ORDER_ITEM_SERVICE.getOrderItemById(5L), ORDER_ITEM_SERVICE.getOrderItemById(9L),
//                ORDER_ITEM_SERVICE.getOrderItemById(13L), ORDER_ITEM_SERVICE.getOrderItemById(17L),
//                ORDER_ITEM_SERVICE.getOrderItemById(21L), ORDER_ITEM_SERVICE.getOrderItemById(25L),
//                ORDER_ITEM_SERVICE.getOrderItemById(29L));
//        ORDER_SERVICE.addOrder(2L, CUSTOMER_SERVICE.getCustomerById(2L), listOrder2);
//
//        List<OrderItemEntity> listOrder3 = List.of(ORDER_ITEM_SERVICE.getOrderItemById(3L),
//                ORDER_ITEM_SERVICE.getOrderItemById(6L), ORDER_ITEM_SERVICE.getOrderItemById(10L),
//                ORDER_ITEM_SERVICE.getOrderItemById(14L), ORDER_ITEM_SERVICE.getOrderItemById(18L),
//                ORDER_ITEM_SERVICE.getOrderItemById(22L), ORDER_ITEM_SERVICE.getOrderItemById(26L),
//                ORDER_ITEM_SERVICE.getOrderItemById(30L));
//        ORDER_SERVICE.addOrder(3L, CUSTOMER_SERVICE.getCustomerById(3L), listOrder3);
//        for (OrderEntity order : ORDER_SERVICE.getAllOrder()) {
//            System.out.println(order);
//        }
//        CUSTOMER_SERVICE.saveCustomerToFile();
//        STORE_SERVICE.saveStoreToFile();
//        PRODUCT_SERVICE.saveProductToFile();
//        SHOP_PRODUCT_SERVICE.saveShopProductToFile();
//        ORDER_ITEM_SERVICE.saveOrderItemToFile();
//        ORDER_SERVICE.saveOrderToFile();
//        CATEGORY_SERVICE.saveCategoryToFile();
//               System.out.println(CUSTOMER_SERVICE.getAllCustomer());
//
//        System.out.println(PRODUCT_SERVICE.getAllProducts());
//        System.out.println(SHOP_PRODUCT_SERVICE.getAllShopProduct());
//        System.out.println(CUSTOMER_SERVICE.getAllCustomer());
//        System.out.println(ORDER_ITEM_SERVICE.getAllOrderItem());
//        System.out.println(ORDER_SERVICE.getAllOrder());
//        System.out.println(STORE_SERVICE.getAllStore());
//        System.out.println(CATEGORY_SERVICE.getAllCategory());
//        MarshallingCategoryJson.serializeCategory(CATEGORY_SERVICE.getAllCategory());
//        MarshallingStoreJson.serializeStore(STORE_SERVICE.getAllStore());
//        MarshallingProductJson.serializeProduct(PRODUCT_SERVICE.getAllProducts());
//        MarshallingOrderJson.serializeOrder(ORDER_SERVICE.getAllOrder());
//        MarshallingOrderItemJson.serializeOrderItem(ORDER_ITEM_SERVICE.getAllOrderItem());
//        MarshallingShopProductJson.serializeShopProduct(SHOP_PRODUCT_SERVICE.getAllShopProduct());
//        MarshallingCustomerJson.serializeCustomer(CUSTOMER_SERVICE.getAllCustomer());


//              MenuController.getInstance().run();
    }
}
