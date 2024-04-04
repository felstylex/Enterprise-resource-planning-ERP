package com.ERP.models.salesOrder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name="sales_order_items")
@Table(name="sales_order_items")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SalesOrderItem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sales_order_id;
    private String product_id;
    private int quantity;
    private BigDecimal unit_price;
}
