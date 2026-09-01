package com.cinema.constructor.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTest {

    @Test
    void shouldCreateServiceWithCorrectFields_WhenAllDataProvided() {
        Service service = Service.builder()
                .id(1L)
                .name("Тест")
                .basePrice(100.0)
                .quality(Service.Quality.HD)
                .build();

        assertEquals(1L, service.getId());
        assertEquals("Тест", service.getName());
        assertEquals(100.0, service.getBasePrice());
        assertEquals(Service.Quality.HD, service.getQuality());
    }

    @Test
    void shouldBeEqualAndHaveSameHashCode_WhenObjectsAreIdentical() {
        Service service1 = Service.builder().build();
        Service service2 = Service.builder().build();

        assertEquals(service1, service2);
        assertEquals(service1.hashCode(), service2.hashCode());
    }

    @Test
    void shouldThrowException_WhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                Service.builder().name(null).build()
        );
    }

    @Test
    void shouldThrowException_WhenQualityIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                Service.builder().quality(null).build());
    }

    @Test
    void shouldThrowException_WhenBasePriceIsNegative() {
        assertThrows(IllegalArgumentException.class, () ->
                Service.builder().basePrice(-1.0).build());
    }
}
