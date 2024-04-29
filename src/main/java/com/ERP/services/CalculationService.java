package com.ERP.services;

import com.ERP.interfaces.Order;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculationService {

    public BigDecimal calculateTotalPrice(Order order) {
        return order.calculateTotalPrice();
    }
}
