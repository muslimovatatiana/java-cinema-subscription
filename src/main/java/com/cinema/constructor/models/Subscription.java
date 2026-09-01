package com.cinema.constructor.models;

import java.util.Set;

public class Subscription {
    private final Set<Service> services;

    public Subscription(Set<Service> services) {
        if (services == null) {
            throw new IllegalArgumentException("Список услуг не может быть null");
        }

        this.services = Set.copyOf(services);
    }

    public double calculateMonthlyCost() {
        return services.stream()
                .mapToDouble(Service::getBasePrice)
                .sum();
    }
}
