package com.cinema.constructor.models;

import java.util.Set;

public class Subscription {
    private final Set<Service> services;

    public Subscription(Set<Service> services) {
        this.services = Set.copyOf(services);
    }

    public double calculateMonthlyCost() {
        return services.stream()
                .mapToDouble(Service::getBasePrice)
                .sum();
    }
}
