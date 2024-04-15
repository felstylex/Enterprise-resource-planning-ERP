package com.ERP.services;

import com.ERP.interfaces.Order;
import com.ERP.models.salesOrder.SalesOrder;
import com.ERP.models.salesOrder.SalesOrderItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CalculationService {

    public BigDecimal calculateTotalPrice(Order order) {
        return order.calculateTotalPrice();
    }
}
