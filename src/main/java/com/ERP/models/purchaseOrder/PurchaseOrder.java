package com.ERP.models.purchaseOrder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name="purchase_orders")
@Table(name="purchase_orders")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PurchaseOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String supplier_id;
    private LocalDate purchase_date;
    private BigDecimal total_price;
    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

}
