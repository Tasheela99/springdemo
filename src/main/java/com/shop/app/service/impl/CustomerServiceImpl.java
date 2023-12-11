package com.shop.app.service.impl;

import com.shop.app.dto.CustomerDto;
import com.shop.app.entity.Customer;
import com.shop.app.exception.NotFoundException;
import com.shop.app.repo.CustomerRepo;
import com.shop.app.service.CustomerService;
import com.shop.app.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomerDto customerDto) {
        if (customerRepo.existsById(customerDto.getCustomerId())) {
            return "Customer Already Exists";
        }
        Customer customer = new Customer(
                customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getCustomerAddress(),
                customerDto.getCustomerPhone(),
                customerDto.getCustomerSalary(),
                customerDto.isActiveState()
        );
        customerRepo.save(customer);
        return customerDto.getCustomerId() + " Saved Successfully";
    }

    @Override
    public String updateCustomer(CustomerDto customerDto, long customerId) {

        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isEmpty()) {
            throw new NotFoundException("Not found");
        }

        Customer updatedCustomer = customer.get();
        updatedCustomer.setCustomerName(customerDto.getCustomerName());
        updatedCustomer.setCustomerAddress(customerDto.getCustomerAddress());
        updatedCustomer.setCustomerPhone(customerDto.getCustomerPhone());
        updatedCustomer.setCustomerSalary(customerDto.getCustomerSalary());
        customerRepo.save(updatedCustomer);
        return "updated";
    }

    @Override
    public CustomerDto getCustomersById(long customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            return new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerPhone(),
                    customer.getCustomerSalary(),
                    customer.isActiveState()
            );
        } else {
            throw new RuntimeException("No Found");
        }
    }


    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        if (!customers.isEmpty()) {
            List<CustomerDto> customerDtoList = new ArrayList<>();
            for (Customer customer : customers) {
                CustomerDto customerDto = new CustomerDto(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerPhone(),
                        customer.getCustomerSalary(),
                        customer.isActiveState()
                );
                customerDtoList.add(customerDto);
            }
            return customerDtoList;
        } else {
            throw new NotFoundException("No Customer Found");
        }
    }

    @Override
    public String deleteCustomer(long customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return customerId + " Customer Deleted";
        } else {
            throw new RuntimeException("Customer Not Found");
        }
    }

    @Override
    public List<CustomerDto> getCustomersByActiveState(boolean activeState) {
        List<Customer> customers = customerRepo.findAllByActiveState(activeState);
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerPhone(),
                    customer.getCustomerSalary(),
                    customer.isActiveState()
            );
            customerDtoList.add(customerDto);
        }
        return customerDtoList;
    }

    @Override
    public List<CustomerDto> getCustomersByName(String customerName) {
        List<Customer> customers = customerRepo.findByCustomerName(customerName);
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer :
                customers) {
            CustomerDto customerDto = new CustomerDto(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerPhone(),
                    customer.getCustomerSalary(),
                    customer.isActiveState()
            );
            customerDtoList.add(customerDto);
        }
        return customerDtoList;
    }


}
