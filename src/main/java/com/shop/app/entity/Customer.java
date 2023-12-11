package com.shop.app.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;
    @Column(name = "customer_name",length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address",length = 100, nullable = false)
    private String customerAddress;

    @Column(name = "customer_phone",length = 100, nullable = false)
    private String customerPhone;

    @Column(name = "customer_salary",length = 100, nullable = false)
    private double customerSalary;

    @Column(name = "customer_active_state",columnDefinition = "TINYINT default 0")
    private boolean activeState;

}
