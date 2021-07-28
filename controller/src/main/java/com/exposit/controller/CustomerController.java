package com.exposit.controller;

import com.exposit.api.service.CustomerService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
}
