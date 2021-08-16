package com.exposit.controller;

import com.exposit.api.service.CustomerService;
import com.exposit.domain.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private static final String REQUEST = "receive request: /customer/ ";

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
        return ResponseEntity.ok().body(String.format("customer %s successfully deleted", id));
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> save(@Valid @RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body("new customer added");
    }

    @SuppressWarnings("checkstyle:FinalParameters")
    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(id, customerDto);
        log.info(REQUEST);
        return ResponseEntity.ok().body(String.format("customer %s successfully updated", id));
    }
}
