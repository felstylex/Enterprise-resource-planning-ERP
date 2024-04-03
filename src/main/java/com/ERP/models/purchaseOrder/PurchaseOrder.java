package com.ERP.models.purchaseOrder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name="purchaseOrders")
@Table(name="purchaseOrders")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String supplierId;
    private LocalDate purchaseDate;
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

}
