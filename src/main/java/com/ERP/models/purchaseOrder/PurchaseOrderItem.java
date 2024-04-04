package com.ERP.models.purchaseOrder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name="purchaseOrderItems")
@Table(name="purchaseOrderItems")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PurchaseOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String purchaseOrderId;
    private String productId;
    private int quantity;
    private BigDecimal unitPrice;
}
