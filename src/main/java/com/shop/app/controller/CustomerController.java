package com.shop.app.controller;

import com.shop.app.dto.CustomerDto;
import com.shop.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
        return customerDto.getCustomerId() + " Saved!";
    }

    @PutMapping(path = "/update", params = {"customerId"})
    public String updateCustomer(
            @RequestBody CustomerDto customerDto,
            @RequestParam("customerId") long customerId
        ) {
        customerService.updateCustomer(customerDto,customerId);
        return customerDto.getCustomerName() + " Updated";
    }

    @GetMapping(path = "/find-customer/{id}")
    public CustomerDto getCustomersById(@PathVariable(value = "id") long customerId) {
        return customerService.getCustomersById(customerId);
    }

    @GetMapping(path = "/find-customer-by-name/{name}")
    public List<CustomerDto> getCustomersByName(@RequestParam(value = "name") String customerName) {
        return customerService.getCustomersByName(customerName);
    }


    @GetMapping(path = "/get-all")
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deletedCustomer(@RequestParam(value = "id") long customerId) {
        String deletedCustomer = customerService.deleteCustomer(customerId);
        return deletedCustomer;
    }

    @GetMapping(path = "/find-customer-by-active-state/{state}")
    public List<CustomerDto> getCustomerName(@RequestParam(value = "state") boolean activeState) {
        return customerService.getCustomersByActiveState(activeState);
    }

}
