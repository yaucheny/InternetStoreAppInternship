package com.exposit.controller;

import com.exposit.api.service.IStoreService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
//@RestController
@RequestMapping("/store")
public class StoreController {

    private final IStoreService storeService;

    @Autowired
    public StoreController(IStoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    public void saveStoreToFile(@RequestBody String value){
        storeService.saveStoreToFile();
    }
}
