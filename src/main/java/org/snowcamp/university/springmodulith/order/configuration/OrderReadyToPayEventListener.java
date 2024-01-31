package org.snowcamp.university.springmodulith.order.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snowcamp.university.springmodulith.order.OrderPaidEvent;
import org.snowcamp.university.springmodulith.order.domain.InitPayment;
import org.snowcamp.university.springmodulith.order.domain.OrderManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OrderReadyToPayEventListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderReadyToPayEventListener.class);

    private final InitPayment initPayment;

    OrderReadyToPayEventListener(InitPayment initPayment) {
        this.initPayment = initPayment;
    }

    @EventListener
    @Transactional
    public void on(OrderPaidEvent event){
        LOGGER.debug("Order paid event: {}", event);
        initPayment.initPayment(event.orderId());
    }
}