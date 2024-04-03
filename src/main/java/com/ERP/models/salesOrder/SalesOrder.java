package com.ERP.models.salesOrder;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private LocalDateTime orderDate;
}
