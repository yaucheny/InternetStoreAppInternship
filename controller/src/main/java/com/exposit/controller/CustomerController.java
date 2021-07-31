package com.exposit.controller;

import com.exposit.api.service.CustomerService;
import com.exposit.dto.CustomerDto;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Log4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private static final String REQUEST = "receive request: /customer/ ";

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id) {
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAll() {
        log.info(REQUEST);
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        log.info(REQUEST + id);
        return ResponseEntity.ok().body(String
                .format("customer %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new customer added");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String
                .format("customer %s successfully updated", id));
    }
}
