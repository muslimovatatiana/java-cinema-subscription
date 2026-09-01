package com.cinema.constructor.models;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubscriptionTest {

    @Test
    void shouldCalculateSum1000_When3ServicesProvided() {
        double sum = getDefaultSubscription().calculateMonthlyCost();

        assertEquals(1000.0, sum);
    }

    @Test
    void shouldReturnCount3_When3ServicesProvided() {
        int count = getDefaultSubscription().getServices().size();

        assertEquals(3, count);
    }

    @Test
    void shouldThrowException_WhenServicesIsNull() {
        assertThrows(NullPointerException.class, () -> new Subscription(null));
    }

    @Test
    void shouldThrowException_WhenServicesIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Subscription(Set.of()));
    }

    @Test
    void shouldThrowException_WhenAttemptingToModifyServicesList() {
        Subscription subscription = getDefaultSubscription();
        Set<Service> subscriptionServices = subscription.getServices();
        Set<Service> modificationServices = getDefaultServices();

        assertThrows(UnsupportedOperationException.class, () ->
                subscriptionServices.addAll(modificationServices));
    }

    private Subscription getDefaultSubscription() {
        return new Subscription(getDefaultServices());
    }

    private Set<Service> getDefaultServices() {
        return Set.of(
                Service.builder().basePrice(100.0).build(),
                Service.builder().basePrice(400.0).build(),
                Service.builder().basePrice(500.0).build()
        );
    }
}
