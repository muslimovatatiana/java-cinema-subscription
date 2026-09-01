package com.cinema.constructor.models;

import java.util.Objects;
import java.util.Set;

public class Subscription {
    private final Set<Service> services;

    public Subscription(Set<Service> services) {
        Objects.requireNonNull(services, "Список услуг не может быть null");

        if (services.isEmpty()) {
            throw new IllegalArgumentException("Список услуг не может быть пустым");
        }

        this.services = Set.copyOf(services);
    }

    public double calculateMonthlyCost() {
        return services.stream()
                .mapToDouble(Service::getBasePrice)
                .sum();
    }

    public Set<Service> getServices() {
        return services;
    }
}
