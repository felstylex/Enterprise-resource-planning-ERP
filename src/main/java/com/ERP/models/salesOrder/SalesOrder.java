package com.ERP.models.salesOrder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name="sales_orders")
@Table(name="sales_orders")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SalesOrder implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String client_id;
    private LocalDate order_date;
    private BigDecimal total_price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
