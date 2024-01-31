package org.snowcamp.university.springmodulith.order.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InitPayment {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitPayment.class);

    public void initPayment(String orderId) {
        LOGGER.info("Init payment {}", orderId);
    }
}
