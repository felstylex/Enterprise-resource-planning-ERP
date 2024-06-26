package com.ERP.models.salesOrder;

import com.ERP.interfaces.Order;
import com.ERP.models.client.Client;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name="sales_orders")
@Table(name="sales_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SalesOrder implements Serializable, Order {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SalesOrderItem> items;

    private LocalDate order_date;
    private BigDecimal total_price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Override
    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;

        if(items != null) {
            for(SalesOrderItem item: items) {
                BigDecimal itemPrice = item.getUnit_price().multiply(BigDecimal.valueOf(item.getQuantity()));
                totalPrice = totalPrice.add(itemPrice);
            }
        }

        return totalPrice;
    }
}
