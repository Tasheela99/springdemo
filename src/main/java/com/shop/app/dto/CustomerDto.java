package com.shop.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

    private long customerId;

    private String customerName;

    private String customerAddress;

    private String customerPhone;

    private double customerSalary;

    private boolean activeState;
}
