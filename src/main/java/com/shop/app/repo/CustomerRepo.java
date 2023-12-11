package com.shop.app.repo;

import com.shop.app.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    List<Customer> findAllByActiveState(boolean activeState);

    List<Customer> findByCustomerName(String customerName);
}
