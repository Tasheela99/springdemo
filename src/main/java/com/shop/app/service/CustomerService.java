package com.shop.app.service;

import com.shop.app.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDto customerDto);

    String updateCustomer(CustomerDto customerDto,long customerId);

    CustomerDto getCustomersById(long customerId);

    List<CustomerDto> getAllCustomers();

    String deleteCustomer(long customerId);

    List<CustomerDto> getCustomersByActiveState(boolean activeState);

    List<CustomerDto> getCustomersByName(String customerName);
}
