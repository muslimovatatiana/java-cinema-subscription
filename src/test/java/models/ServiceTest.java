package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServiceTest {

    private final long defaultId = 1L;
    private final String defaultName = "Услуга";
    private final double defaultBasePrice = 100.0;
    private final Service.Quality defaultQuality = Service.Quality.HD;

    @Test
    void shouldCreateServiceWhenCallBuilder() {
        Service service = Service.builder()
                .id(defaultId)
                .name(defaultName)
                .basePrice(defaultBasePrice)
                .quality(defaultQuality)
                .build();

        assertEquals(defaultId, service.getId());
        assertEquals(defaultName, service.getName());
        assertEquals(defaultBasePrice, service.getBasePrice());
        assertEquals(defaultQuality, service.getQuality());
    }

    @Test
    void given2ServicesWhenIdEqualsThenHashCodesEquals() {
        Service service1 = Service.builder()
                .id(defaultId)
                .name(defaultName)
                .basePrice(defaultBasePrice)
                .quality(defaultQuality)
                .build();
        Service service2 = Service.builder()
                .id(service1.getId())
                .name(service1.getName())
                .basePrice(service1.getBasePrice())
                .quality(service1.getQuality())
                .build();

        assertEquals(service1, service2);
        assertEquals(service1.hashCode(), service2.hashCode());
    }

    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> Service.builder()
                .id(defaultId)
                .name(null)
                .basePrice(defaultBasePrice)
                .quality(defaultQuality)
                .build());
    }

    @Test
    void shouldThrowExceptionWhenQualityIsNull() {
        assertThrows(IllegalArgumentException.class, () -> Service.builder()
                .id(defaultId)
                .name(defaultName)
                .basePrice(defaultBasePrice)
                .quality(null)
                .build());
    }

    @Test
    void shouldThrowExceptionWhenBasePriceIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> Service.builder()
                .id(defaultId)
                .name(defaultName)
                .basePrice(-1.0)
                .quality(defaultQuality)
                .build());
    }
}
