package com.ERP.models.purchaseOrder;

import com.ERP.interfaces.Order;
import com.ERP.models.supplier.Supplier;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity(name="purchase_orders")
@Table(name="purchase_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PurchaseOrder implements Serializable, Order {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PurchaseOrderItem> items;

    private LocalDate purchase_date;
    private BigDecimal total_price;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    @Override
    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;

        if(items != null) {
            for (PurchaseOrderItem item: items) {
                BigDecimal itemPrice = item.getUnit_price().multiply(BigDecimal.valueOf(item.getQuantity()));
                totalPrice = totalPrice.add(itemPrice);
            }
        }
        return totalPrice;
    }
}
