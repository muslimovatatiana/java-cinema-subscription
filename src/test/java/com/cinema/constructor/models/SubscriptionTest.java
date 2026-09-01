package com.cinema.constructor.models;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubscriptionTest {

    @Test
    void shouldCalculateSum1000_When3ServicesProvided() {
        Set<Service> services = getDefaultServices();
        Subscription subscription = new Subscription(services);

        double sum = subscription.calculateMonthlyCost();

        assertEquals(1000.0, sum);
    }

    @Test
    void shouldThrowException_WhenServicesIsNull() {
        assertThrows(NullPointerException.class,() -> new Subscription(null));
    }

    @Test
    void shouldThrowException_WhenServicesIsEmpty() {
        assertThrows(IllegalArgumentException.class,() -> new Subscription(Set.of()));
    }

    private Set<Service> getDefaultServices() {
        return Set.of(
                Service.builder().basePrice(100.0).build(),
                Service.builder().basePrice(400.0).build(),
                Service.builder().basePrice(500.0).build()
        );
    }
}
