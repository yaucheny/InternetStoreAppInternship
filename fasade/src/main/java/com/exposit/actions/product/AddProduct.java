package com.exposit.actions.product;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.IAction;
import com.exposit.api.service.IStoreService;
import com.exposit.service.StoreServiceImpl;
import lombok.extern.log4j.Log4j;

@Log4j
public class AddProduct extends AbstractAction implements IAction {
    private static final IStoreService STORE_SERVICE
            = StoreServiceImpl.getInstance();

    @Override
    public void execute() {
//

//            System.out.println("Enter name of product");
//            String productName = reader.readLine();
//
//            System.out.println("Enter producer of product");
//            String productProducer = reader.readLine();
//
//            System.out.println("Enter price of product");
//            Integer productPrice = Integer.parseInt(reader.readLine());
//
//            System.out.println("Enter quantity of product");
//            Integer productQuantity = Integer.parseInt(reader.readLine());
//
//            System.out.println("Enter id of store to sell product");
//            Long storeId = Long.parseLong(reader.readLine());
//
//            System.out.println("Choose category one of product:");
//            System.out.println("CHILDREN, ADULTS, ANIMALS");
//            String catOne = reader.readLine();
//            CategoryOne categoryOne=CategoryOne.valueOf(catOne);
//
//            System.out.println("Choose category two of product:");
//            System.out.println("FOOD, NON_FOOD");
//            String catTwo = reader.readLine();
//            CategoryTwo categoryTwo=CategoryTwo.valueOf(catTwo);
//
//            System.out.println("Choose category three of product:");
//            System.out.println("TECHNICS, CLOTHES,  NUTRITION");
//            String catThree = reader.readLine();
//            CategoryThree categoryThree=CategoryThree.valueOf(catThree);

//            Store store = storeService.getStoreById(storeId);
  //          fasade.addProduct(productName, productProducer, productPrice,
   //                 productQuantity, store, categories);
//            System.out.println("product successfully created");
//        } catch (Exception e) {
//            log.warn(e.getLocalizedMessage());
//        }
    }
}
