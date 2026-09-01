package com.cinema.constructor.models;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionTest {

    @Test
    void givenSubscriptionWhen3ServicesThenSum1000() {
        Set<Service> services = getDefaultServices();
        Subscription subscription = new Subscription(services);
        double sum = subscription.calculateMonthlyCost();

        assertEquals(1000.0, sum);
    }

    private Set<Service> getDefaultServices() {
        return Set.of(
                Service.builder().basePrice(100.0).build(),
                Service.builder().basePrice(400.0).build(),
                Service.builder().basePrice(500.0).build()
        );
    }

    @Test
    void givenSubscriptionWhenNotExistsServicesThenSum0() {
        Subscription subscription = new Subscription(null);

        assertEquals(0.0, subscription.calculateMonthlyCost());
    }
}
