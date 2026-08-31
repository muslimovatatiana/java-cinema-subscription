package com.cinema.constructor.models;

import java.util.Objects;

public class Service {

    private long id;
    private String name;
    private double basePrice;
    private Quality quality;

    private Service(long id, String name, double basePrice, Quality quality) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.quality = quality;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Quality getQuality() {
        return quality;
    }

    public enum Quality {
        HD, FHD, UHD
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Service service = (Service) object;
        return id == service.id
                && Objects.equals(name, service.name)
                && Double.compare(basePrice, service.basePrice) == 0
                && quality == service.quality;
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + name.hashCode();
        result = 31 * result + Double.hashCode(basePrice);
        result = 31 * result + quality.hashCode();
        return result;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String name;
        private double basePrice;
        private Quality quality;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder basePrice(double basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public Builder quality(Quality quality) {
            this.quality = quality;
            return this;
        }

        public Service build() {
            if (this.name == null) {
                throw new IllegalArgumentException("Имя услуги не может быть null");
            }

            if (this.quality == null) {
                throw new IllegalArgumentException("Качество услуги не может быть null");
            }

            if (this.basePrice < 0) {
                throw new IllegalArgumentException("Цена услуги не может быть отрицательной");
            }

            return new Service(this.id, this.name, this.basePrice, this.quality);
        }
    }
}
