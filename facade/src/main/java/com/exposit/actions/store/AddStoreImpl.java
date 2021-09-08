package com.exposit.actions.store;

import com.exposit.actions.AbstractAction;
import com.exposit.actions.Action;
import com.exposit.domain.dto.StoreDto;
import com.exposit.menu.Facade;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link Action} interface.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
@RequiredArgsConstructor
public class AddStoreImpl extends AbstractAction implements Action {

    private static final Logger LOG = LoggerFactory.getLogger(AddStoreImpl.class);
    private final Facade facade;

    @Override
    public void execute() {
        try {
            System.out.println("Enter name of store");
            String storeName = reader.readLine();
            System.out.println("Enter internet page of store");
            String internetPage = reader.readLine();
            System.out.println("Enter phone number of store");
            String phoneNumber = reader.readLine();
            StoreDto storeDto = new StoreDto();
            storeDto.setInternetPage(internetPage);
            storeDto.setName(storeName);
            storeDto.setPhoneNumber(phoneNumber);
            facade.addStore(storeDto);
            System.out.println("store successfully created");
        } catch (Exception e) {
            LOG.error("can not create store");
        }
    }
}
