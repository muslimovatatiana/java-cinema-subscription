package com.cinema.constructor.models;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
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
        Set<Service> services = new HashSet<>();
        services.add(Service.builder()
                .id(1L)
                .name("Услуга 1")
                .basePrice(100.0)
                .quality(Service.Quality.HD)
                .build());
        services.add(Service.builder()
                .id(2L)
                .name("Услуга 2")
                .basePrice(400.0)
                .quality(Service.Quality.FHD)
                .build());
        services.add(Service.builder()
                .id(3L)
                .name("Услуга 3")
                .basePrice(500.0)
                .quality(Service.Quality.UHD)
                .build());
        return services;
    }
}
