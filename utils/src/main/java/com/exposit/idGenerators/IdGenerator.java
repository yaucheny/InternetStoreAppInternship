package com.exposit.idGenerators;

public class IdGenerator {

    private static Long ORDER_ID = 1L;
    private static Long CUSTOMER_ID = 1L;
    private static Long STORE_ID = 1L;
    private static Long GOODS_ID = 1L;

    public static Long generateOrderId() {
        return ORDER_ID++/2;
    }

    public static Long generateCustomerId() {
        return CUSTOMER_ID++/2;
    }

    public static Long generateStoreId() {
        return STORE_ID++/2;
    }

    public static Long generateProductId() {
        return GOODS_ID++/2;
    }
}
