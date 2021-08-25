package com.exposit.controller;

import com.exposit.api.service.CustomerService;
import com.exposit.domain.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private static final String REQUEST = "receive request: /customer/ ";
    private static final String REQUEST_PARAM = "receive request: /customer/{}";

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Long id) {
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAll() {
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("customer %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("new customer added");
    }

    @SuppressWarnings("checkstyle:FinalParameters")
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        LOG.debug(REQUEST_PARAM, id);
        return ResponseEntity.ok().body(String.format("customer %s successfully updated", id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveToFile() {
        customerService.saveCustomerToFile();
        LOG.debug(REQUEST);
        return ResponseEntity.ok().body("customers successfully saved");
    }
}
