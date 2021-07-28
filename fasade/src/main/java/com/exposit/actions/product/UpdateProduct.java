package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;

import lombok.extern.log4j.Log4j;

@Log4j
public class UpdateProduct extends AbstractAction implements IAction {
//    private static final StoreService storeService = StoreServiceImpl.getInstance();

    @Override
    public void execute() {
//        try {
//            System.out.println("Enter id of product to be updated");
//            Long productId = Long.parseLong(reader.readLine());
//
//            System.out.println("Enter new name of product");
//            String productName = reader.readLine();
//
//            System.out.println("Enter new producer of product");
//            String productProducer = reader.readLine();
//
//            System.out.println("Enter new price of product");
//            Integer productPrice = Integer.parseInt(reader.readLine());
//
//            System.out.println("Enter new quantity of product");
//            Integer productQuantity = Integer.parseInt(reader.readLine());
//
//            System.out.println("Enter id of store to sell product");
//            Long storeId = Long.parseLong(reader.readLine());
//
//            System.out.println("Choose new category one of product:");
//            System.out.println("CHILDREN, ADULTS, ANIMALS");
//            String catOne = reader.readLine();
//            CategoryOne categoryOne=CategoryOne.valueOf(catOne);
//            Category categories
//
//            System.out.println("Choose new category two of product:");
//            System.out.println("FOOD, NON_FOOD");
//            String catTwo = reader.readLine();
//           CategoryTwo categoryTwo=CategoryTwo.valueOf(catTwo);
//
//            System.out.println("Choose new category three of product:");
//            System.out.println("TECHNICS, CLOTHES,  NUTRITION");
//            String catThree = reader.readLine();
//            CategoryThree categoryThree=CategoryThree.valueOf(catThree);
//
//           StoreEntity store = storeService.getStoreById(storeId);
//            fasade.updateProduct(productId, productName, productProducer, productPrice,
//            //                  productQuantity, store, categories);
//            System.out.println("product id :" + productId + " updated");
//        } catch (Exception e) {
//            log.warn(e.getLocalizedMessage());
//        }
    }
}
